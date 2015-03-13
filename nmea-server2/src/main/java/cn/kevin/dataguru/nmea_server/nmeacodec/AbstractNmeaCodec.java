package cn.kevin.dataguru.nmea_server.nmeacodec;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import cn.kevin.dataguru.nmea_server.codecmanager.SentenceFactory;
import cn.kevin.dataguru.nmea_server.definition.SentenceDefinition;
import cn.kevin.dataguru.nmea_server.definition.SentenceFieldAnnotationSorter;
import cn.kevin.dataguru.nmea_server.nmeasentence.AbstractNmeaSentence;

public abstract class AbstractNmeaCodec extends Observable{

	public void decode(String[] content, String sentenceType){
		AbstractNmeaSentence nmeaSentence = SentenceFactory.getInstance().createSentence(sentenceType);
		List<Field> annotatedFields = getSentenceFields(nmeaSentence);
		try {
			int index = 0;
			for(Field field : annotatedFields){
				field.set(nmeaSentence, content[index]);
				index ++;
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public List<String> encode(String prefix, AbstractNmeaSentence nmeaSentence){
		List<String> result = new ArrayList<String>();
		List<Field> annotatedFields = getSentenceFields(nmeaSentence);
		StringBuilder builder = new StringBuilder("!$");
		try {
			builder.append(prefix).append(nmeaSentence.getSentenceType().toUpperCase());
			for(Field field : annotatedFields){
				Object value = field.get(nmeaSentence);
				builder.append(',').append(value.toString());
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		builder.append("\r\n");
		result.add(builder.toString());
		return result;
	}
	
	public List<Field> getSentenceFields(AbstractNmeaSentence sentence) {
		List<Field> annotatedFields = new ArrayList<Field>();
		for (Field field : sentence.getClass().getFields()) {
			if (field.isAnnotationPresent(SentenceDefinition.class)) {
				annotatedFields.add(field);
			}
		}
		Collections.sort(annotatedFields, new SentenceFieldAnnotationSorter());
		return annotatedFields;
	}

	public abstract String getCodecType();
	
	public void addObserver(Object obj){
		this.addObserver(obj);
	}
	
	public void decodeNotify(){
		setChanged();
		notifyObservers();
	}
}
