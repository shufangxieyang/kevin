package cn.kevin.dataguru.nmea_server.nmeacodec;

import java.util.List;
import java.util.Observable;

import cn.kevin.dataguru.nmea_server.nmeaobject.AbstractNmeaObject;

public abstract class AbstractNmeaCodec extends Observable{

	public abstract void decode(String content);
	
	public abstract List<String> encode(AbstractNmeaObject obj);
	
	public void addObserver(Object obj){
		this.addObserver(obj);
	}
	
	public void decodeNotify(){
		setChanged();
		notifyObservers();
	}
}
