package cn.kevin.dataguru.nmea_server.codecmanager;

import java.util.ArrayList;
import java.util.List;

public class Buffer {

	public List<String> appendContent(String content){
		List<String> list = new ArrayList<String>();
		list.add(content);
		return list;
	}
}
