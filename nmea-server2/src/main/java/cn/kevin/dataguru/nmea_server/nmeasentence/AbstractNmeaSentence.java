package cn.kevin.dataguru.nmea_server.nmeasentence;

public abstract class AbstractNmeaSentence {

	
	public String sentenceType;

	public String getSentenceType() {
		return sentenceType;
	}

	public void setSentenceType(String sentenceType) {
		this.sentenceType = sentenceType;
	}

}
