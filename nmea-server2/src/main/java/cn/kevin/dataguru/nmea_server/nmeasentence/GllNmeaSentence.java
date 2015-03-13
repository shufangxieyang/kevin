package cn.kevin.dataguru.nmea_server.nmeasentence;

import cn.kevin.dataguru.nmea_server.definition.SentenceDefinition;

@SentenceDefinition
public class GllNmeaSentence extends AbstractNmeaSentence {

	@SentenceDefinition(order = 0)
	public String sentenceType;

	@SentenceDefinition(order = 1)
	public String latitude;

	@SentenceDefinition(order = 2)
	public String latitudeFlag;

	@SentenceDefinition(order = 3)
	public String longitude;

	@SentenceDefinition(order = 4)
	public String longitudeFlag;

	@SentenceDefinition(order = 5)
	public String UTC;

	@SentenceDefinition(order = 6)
	public String status;

	public String getSentenceType() {
		return sentenceType;
	}

	public void setSentenceType(String sentenceType) {
		this.sentenceType = sentenceType;
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

	public String getUTC() {
		return UTC;
	}

	public void setUTC(String uTC) {
		UTC = uTC;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
