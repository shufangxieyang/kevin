package cn.kevin.dataguru.nmea_server.nmeaobject;

public abstract class AbstractNmeaObject {

	public String objType;

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}
	
}
