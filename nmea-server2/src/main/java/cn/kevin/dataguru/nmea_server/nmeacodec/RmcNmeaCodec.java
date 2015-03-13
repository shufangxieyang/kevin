package cn.kevin.dataguru.nmea_server.nmeacodec;

import cn.kevin.dataguru.nmea_server.definition.CodecDefinition;

@CodecDefinition(name="RMC")
public class RmcNmeaCodec extends AbstractNmeaCodec {

	@Override
	public String getCodecType() {
		return "RMC";
	}

}
