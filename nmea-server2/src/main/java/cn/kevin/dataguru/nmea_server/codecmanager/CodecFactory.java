package cn.kevin.dataguru.nmea_server.codecmanager;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kevin.dataguru.nmea_server.definition.CodecDefinition;
import cn.kevin.dataguru.nmea_server.nmeacodec.AbstractNmeaCodec;
import cn.kevin.dataguru.nmea_server.util.StringUtils;

public class CodecFactory {

	private static CodecFactory codecFactory = new CodecFactory();
	private List<String> codecList = new ArrayList<String>();
	private String basePackage = "cn.kevin.dataguru.nmea_server.nmeacodec";
	private Map<String, Class<AbstractNmeaCodec>> codecMap = new HashMap<String, Class<AbstractNmeaCodec>>();
	
	public static CodecFactory getInstance(){
		return codecFactory;
	}
	
	private CodecFactory(){
		doScanFile(basePackage);
		initInstance();
	}

	private void doScanFile(String basePackage) {
		ClassLoader cl = getClass().getClassLoader();
		String splashPath = StringUtils.dotToSplash(basePackage);
		URL url = cl.getResource(splashPath);
		if(null != url){
			String filePath = StringUtils.getRootPath(url);
			List<String> names = null;
			names = readFromDirectory(filePath);
			for (String name : names) {
				if (StringUtils.isClassFile(name)) {
					codecList.add(StringUtils.toFullName(basePackage, name));
				}else{
					doScanFile(basePackage + "." + name);
				}
			}
		}
	}

	private List<String> readFromDirectory(String path) {
		File file = new File(path);
		String[] names = file.list();
		if (null == names) {
			return null;
		}
		return Arrays.asList(names);
	}
	
	private void initInstance() {
		for(String codec : codecList){
			try {
				@SuppressWarnings("unchecked")
				Class<AbstractNmeaCodec> clazz = (Class<AbstractNmeaCodec>) Class.forName(codec);
				if(clazz.getAnnotation(CodecDefinition.class) != null){
					codecMap.put(StringUtils.getSentenceType(codec), clazz);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public AbstractNmeaCodec createCodec(String codecType){
		if(codecMap.containsKey(codecType.toUpperCase())){
			try {
				return codecMap.get(codecType).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
