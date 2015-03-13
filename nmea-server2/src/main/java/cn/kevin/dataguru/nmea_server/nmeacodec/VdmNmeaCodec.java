package cn.kevin.dataguru.nmea_server.nmeacodec;

import cn.kevin.dataguru.nmea_server.definition.CodecDefinition;

@CodecDefinition(name="VDM")
public class VdmNmeaCodec extends AbstractNmeaCodec {

	@Override
	public String getCodecType() {
		return "VDM";
	}

}
