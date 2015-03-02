package cn.kevin.dataguru.nmea_server.codecmanager;

import java.util.List;

import cn.kevin.dataguru.nmea_server.nmeacodec.AbstractNmeaCodec;
import cn.kevin.dataguru.nmea_server.nmeaobject.AbstractNmeaObject;

public class CodecManager {

	private AbstractNmeaCodec nmeaCodec;
	
	public void decode(String content) {
		nmeaCodec = getNmeaCodec(content);
		nmeaCodec.decodeNotify();
	}

	public List<String> encode(AbstractNmeaObject obj) {
		nmeaCodec = getNmeaCodec(obj.getObjType());
		return null;
	}
	
	public AbstractNmeaCodec getNmeaCodec(String content) {
		if(content == null || content.length() == 0)
			return null;
		String head = content.substring(0, content.indexOf(","));
		String objType = head.substring(head.length() - 3, head.length());
		return CodecFactory.getNmeaCodec(objType);
	}

	public AbstractNmeaCodec getNmeaCodec() {
		return nmeaCodec;
	}

	public void setNmeaCodec(AbstractNmeaCodec nmeaCodec) {
		this.nmeaCodec = nmeaCodec;
	}

}
