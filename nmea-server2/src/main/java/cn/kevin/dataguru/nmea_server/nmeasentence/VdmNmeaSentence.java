package cn.kevin.dataguru.nmea_server.nmeasentence;

import cn.kevin.dataguru.nmea_server.definition.SentenceDefinition;

@SentenceDefinition
public class VdmNmeaSentence extends ParametricSentence {

	@SentenceDefinition(order = 0)
	public String sentenceType;
	
	@SentenceDefinition(order = 1)
	public String totalNumberOfSentences = "1";
	
	@SentenceDefinition(order = 2)
	public String sentenceNumber = "1";
	
	@SentenceDefinition(order = 3, isRequired = false)
	public String sequentialMessageIdentifier = null;
	
	@SentenceDefinition(order = 4)
	public String aisChannel;
	
	@SentenceDefinition(order = 5)
	public String encapsulatedContent;
	
	@SentenceDefinition(order = 6)
	public String fillBits;

	public String getSentenceType() {
		return sentenceType;
	}

	public void setSentenceType(String sentenceType) {
		this.sentenceType = sentenceType;
	}

	public String getTotalNumberOfSentences() {
		return totalNumberOfSentences;
	}

	public void setTotalNumberOfSentences(String totalNumberOfSentences) {
		this.totalNumberOfSentences = totalNumberOfSentences;
	}

	public String getSentenceNumber() {
		return sentenceNumber;
	}

	public void setSentenceNumber(String sentenceNumber) {
		this.sentenceNumber = sentenceNumber;
	}

	public String getSequentialMessageIdentifier() {
		return sequentialMessageIdentifier;
	}

	public void setSequentialMessageIdentifier(String sequentialMessageIdentifier) {
		this.sequentialMessageIdentifier = sequentialMessageIdentifier;
	}

	public String getAisChannel() {
		return aisChannel;
	}

	public void setAisChannel(String aisChannel) {
		this.aisChannel = aisChannel;
	}

	public String getEncapsulatedContent() {
		return encapsulatedContent;
	}

	public void setEncapsulatedContent(String encapsulatedContent) {
		this.encapsulatedContent = encapsulatedContent;
	}

	public String getFillBits() {
		return fillBits;
	}

	public void setFillBits(String fillBits) {
		this.fillBits = fillBits;
	}

}
