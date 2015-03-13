package cn.kevin.dataguru.nmea_server.nmeasentence;

import cn.kevin.dataguru.nmea_server.definition.SentenceDefinition;

@SentenceDefinition
public class RmcNmeaSentence extends ParametricSentence {

	@SentenceDefinition(order = 0)
	public String sentenceType;

	@SentenceDefinition(order = 1)
	public String utchh;
	
	@SentenceDefinition(order = 2)
	public String status;
	
	@SentenceDefinition(order = 3)
	public String latitude;
	
	@SentenceDefinition(order = 4)
	public String latitudeFlag;
	
	@SentenceDefinition(order = 5)
	public String longitude;
	
	@SentenceDefinition(order = 6)
	public String longitudeFlag;
	
	@SentenceDefinition(order = 7)
	public String speed;
	
	@SentenceDefinition(order = 8)
	public String position;
	
	@SentenceDefinition(order = 9)
	public String utcdd;
	
	@SentenceDefinition(order = 10)
	public String declination;
	
	@SentenceDefinition(order = 11)
	public String declinationdir;

	public String getSentenceType() {
		return sentenceType;
	}

	public void setSentenceType(String sentenceType) {
		this.sentenceType = sentenceType;
	}

	public String getUtchh() {
		return utchh;
	}

	public void setUtchh(String utchh) {
		this.utchh = utchh;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUtcdd() {
		return utcdd;
	}

	public void setUtcdd(String utcdd) {
		this.utcdd = utcdd;
	}

	public String getDeclination() {
		return declination;
	}

	public void setDeclination(String declination) {
		this.declination = declination;
	}

	public String getDeclinationdir() {
		return declinationdir;
	}

	public void setDeclinationdir(String declinationdir) {
		this.declinationdir = declinationdir;
	}
	
}
