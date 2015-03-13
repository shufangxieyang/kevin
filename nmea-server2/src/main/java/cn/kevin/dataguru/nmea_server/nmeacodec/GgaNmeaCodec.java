package cn.kevin.dataguru.nmea_server.nmeacodec;

import cn.kevin.dataguru.nmea_server.definition.CodecDefinition;

@CodecDefinition(name="GGA")
public class GgaNmeaCodec extends AbstractNmeaCodec {

	@Override
	public String getCodecType() {
		return "GGA";
	}

}
