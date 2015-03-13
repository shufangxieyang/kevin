package cn.kevin.dataguru.nmea_server.codecmanager;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.kevin.dataguru.nmea_server.nmeacodec.AbstractNmeaCodec;
import cn.kevin.dataguru.nmea_server.nmeasentence.AbstractNmeaSentence;
import cn.kevin.dataguru.nmea_server.nmeasentence.EncapsulationSentence;
import cn.kevin.dataguru.nmea_server.nmeasentence.ParametricSentence;

public class CodecManager {

	private Buffer buffer;
	
	private static Log logger = LogFactory.getLog(CodecManager.class);
	
	public CodecManager() {
		this.buffer = new Buffer();
	}
	
	public void decode(String content) {
		CodecManager.logger.info("received: " + new String(content));
		List<String> rawSentences = buffer.appendContent(content.toCharArray());
		for (String sentence : rawSentences) {
			int checkIndex = sentence.lastIndexOf('*');
			//CheckSentenceValid
			String[] segments = null;
			if (checkIndex > -1) {
				segments = sentence.substring(0, checkIndex).trim().split(",");
			} else {
				segments = sentence.trim().split(",");
			}
			// proprietary sentence
			if (sentence.startsWith("$P") || sentence.startsWith("!P")) {
				
			} else if (segments[0].startsWith("$") && segments[0].length() == 6
					&& segments[0].charAt(5) == 'Q') { // query sentence
				
			} else { // parametric or encapsulation sentence
				String sentenceType = getSentenceType(sentence);
				AbstractNmeaCodec nmeaCodec = getNmeaCodec(sentence);
				nmeaCodec.decode(segments, sentenceType);
			}
		}
	}

	public List<String> encode(String prefix, AbstractNmeaSentence sentence) {
		String sentenceType = sentence.getSentenceType();
		if (sentence instanceof ParametricSentence) {//parametric sentence
			CodecManager.logger.info("encoding parametric sentence, type: " + sentenceType);
			AbstractNmeaCodec nmeaCodec = getNmeaCodec(sentenceType);
			return nmeaCodec.encode(prefix, sentence);
		} else if (sentence instanceof EncapsulationSentence) {//encapsulation sentence
			CodecManager.logger.info("encoding encapsulation sentence, type: " + sentenceType);
		
		} else {//proprietary sentence
			CodecManager.logger.info("encoding query sentence, type: " + sentenceType);
		
		}
		return null;
	}
	
	public AbstractNmeaCodec getNmeaCodec(String sentenceType) {
		return CodecFactory.getInstance().createCodec(sentenceType);
	}
	
	public String getSentenceType(String content){
		String head = content.substring(0, content.indexOf(","));
		String sentenceType = head.substring(head.length() - 3, head.length());
		return sentenceType;
	}

}
