package cn.kevin.dataguru.nmea_server.nmeacodec;

import cn.kevin.dataguru.nmea_server.definition.CodecDefinition;

@CodecDefinition(name="GGL")
public class GllNmeaCodec extends AbstractNmeaCodec {

	@Override
	public String getCodecType() {
		return "GGL";
	}

}
