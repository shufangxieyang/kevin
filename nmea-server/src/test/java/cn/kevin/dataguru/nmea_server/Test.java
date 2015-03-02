package cn.kevin.dataguru.nmea_server;

public class Test {

	public static void main(String[] args){
		String content = "$GPGGA,092204.999,4250.5589,S,14718.5084,E,1,04,24.4,19.7,M,,,,0000*1F";
		String objType = "";
		String head = content.substring(0, content.indexOf(","));
		objType = head.substring(head.length() - 3, head.length());
		System.out.println(objType);
	}
}
