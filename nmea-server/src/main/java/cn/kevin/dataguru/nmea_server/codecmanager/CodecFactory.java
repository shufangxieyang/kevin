package cn.kevin.dataguru.nmea_server.codecmanager;

import cn.kevin.dataguru.nmea_server.nmeacodec.AbstractNmeaCodec;
import cn.kevin.dataguru.nmea_server.nmeacodec.GgaNmeaCodec;
import cn.kevin.dataguru.nmea_server.nmeacodec.GllNmeaCodec;
import cn.kevin.dataguru.nmea_server.nmeacodec.RmcNmeaCodec;
import cn.kevin.dataguru.nmea_server.nmeacodec.VdmNmeaCodec;

public class CodecFactory {

	public static AbstractNmeaCodec getNmeaCodec(String objType){
		if("GGA".equals(objType)){
			return new GgaNmeaCodec();
		}else if("GLL".equals(objType)){
			return new GllNmeaCodec();
		}else if("RMC".equals(objType)){
			return new RmcNmeaCodec();
		}else if("VDM".equals(objType)){
			return new VdmNmeaCodec();
		}
		return null;
	}
}
