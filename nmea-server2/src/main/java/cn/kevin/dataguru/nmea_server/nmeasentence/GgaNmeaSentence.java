package cn.kevin.dataguru.nmea_server.nmeasentence;

import cn.kevin.dataguru.nmea_server.definition.SentenceDefinition;

@SentenceDefinition
public class GgaNmeaSentence extends ParametricSentence {

	@SentenceDefinition(order = 0)
	public String sentenceType;

	@SentenceDefinition(order = 1)
	public String UTC;
	
	@SentenceDefinition(order = 2)
	public String latitude;
	
	@SentenceDefinition(order = 3)
	public String latitudeFlag;
	
	@SentenceDefinition(order = 4)
	public String longitude;
	
	@SentenceDefinition(order = 5)
	public String longitudeFlag;
	
	@SentenceDefinition(order = 6)
	public String gpsStatus;
	
	@SentenceDefinition(order = 7)
	public String satelliteNum;
	
	@SentenceDefinition(order = 8)
	public String hdop;
	
	@SentenceDefinition(order = 9)
	public String higher;
	
	@SentenceDefinition(order = 10)
	public String sealevel;
	
	@SentenceDefinition(order = 11)
	public String difftime;
	
	@SentenceDefinition(order = 12)
	public String diffid;
	
	public String getSentenceType() {
		return sentenceType;
	}

	public void setSentenceType(String sentenceType) {
		this.sentenceType = sentenceType;
	}

	public String getUTC() {
		return UTC;
	}

	public void setUTC(String uTC) {
		UTC = uTC;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLatitudeFlag() {
		return latitudeFlag;
	}

	public void setLatitudeFlag(String latitudeFlag) {
		this.latitudeFlag = latitudeFlag;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLongitudeFlag() {
		return longitudeFlag;
	}

	public void setLongitudeFlag(String longitudeFlag) {
		this.longitudeFlag = longitudeFlag;
	}

	public String getGpsStatus() {
		return gpsStatus;
	}

	public void setGpsStatus(String gpsStatus) {
		this.gpsStatus = gpsStatus;
	}

	public String getSatelliteNum() {
		return satelliteNum;
	}

	public void setSatelliteNum(String satelliteNum) {
		this.satelliteNum = satelliteNum;
	}

	public String getHdop() {
		return hdop;
	}

	public void setHdop(String hdop) {
		this.hdop = hdop;
	}

	public String getHigher() {
		return higher;
	}

	public void setHigher(String higher) {
		this.higher = higher;
	}

	public String getSealevel() {
		return sealevel;
	}

	public void setSealevel(String sealevel) {
		this.sealevel = sealevel;
	}

	public String getDifftime() {
		return difftime;
	}

	public void setDifftime(String difftime) {
		this.difftime = difftime;
	}

	public String getDiffid() {
		return diffid;
	}

	public void setDiffid(String diffid) {
		this.diffid = diffid;
	}

	@Override
	public String toString() {
		return "GGA";
	}

}
