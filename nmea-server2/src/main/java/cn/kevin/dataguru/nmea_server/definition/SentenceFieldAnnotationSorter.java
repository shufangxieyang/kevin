package cn.kevin.dataguru.nmea_server.definition;

import java.lang.reflect.Field;
import java.util.Comparator;

public class SentenceFieldAnnotationSorter implements Comparator<Field> {

	public int compare(Field arg0, Field arg1) {
		SentenceDefinition a = arg0.getAnnotation(SentenceDefinition.class);
		SentenceDefinition b = arg1.getAnnotation(SentenceDefinition.class);
		return new Integer(a.order()).compareTo(new Integer(b.order()));
	}

}
