package cn.kevin.dataguru.nmea_server.codecmanager;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kevin.dataguru.nmea_server.definition.SentenceDefinition;
import cn.kevin.dataguru.nmea_server.nmeasentence.AbstractNmeaSentence;
import cn.kevin.dataguru.nmea_server.util.StringUtils;

public class SentenceFactory {

	private static SentenceFactory sentenceFactory = new SentenceFactory();
	private List<String> sentenceList = new ArrayList<String>();
	private String basePackage = "cn.kevin.dataguru.nmea_server.nmeasentence";
	private Map<String, Class<AbstractNmeaSentence>> sentenceMap = new HashMap<String, Class<AbstractNmeaSentence>>();
	
	public static SentenceFactory getInstance(){
		return sentenceFactory;
	}
	
	private SentenceFactory(){
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
					sentenceList.add(StringUtils.toFullName(basePackage, name));
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
		for(String sentence : sentenceList){
			try {
				@SuppressWarnings("unchecked")
				Class<AbstractNmeaSentence> clazz = (Class<AbstractNmeaSentence>) Class.forName(sentence);
				if(clazz.getAnnotation(SentenceDefinition.class) != null){
					sentenceMap.put(StringUtils.getSentenceType(sentence), clazz);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public AbstractNmeaSentence createSentence(String sentenceType){
		if(sentenceMap.containsKey(sentenceType.toUpperCase())){
			try {
				return sentenceMap.get(sentenceType).newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
