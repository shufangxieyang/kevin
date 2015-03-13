package cn.kevin.dataguru.nmea_server;

import java.util.List;

import cn.kevin.dataguru.nmea_server.codecmanager.Buffer;

public class BufferTest {
	
	public static void main(String[] args){
//		CharBuffer charBuffer = CharBuffer.allocate(1024);
//		charBuffer.append('1');
//		charBuffer.append('2');
//		charBuffer.append('3');
//		
//		System.out.println(charBuffer.position());
//		System.out.println(charBuffer.limit());
//		System.out.println(charBuffer.capacity());
//		System.out.println(charBuffer.remaining());
//		
//		charBuffer.rewind();
//		System.out.println(charBuffer.get());
//		
//		System.out.println(charBuffer.position());
//		System.out.println(charBuffer.limit());
//		System.out.println(charBuffer.capacity());
//		System.out.println(charBuffer.remaining());
		
		Buffer buffer = new Buffer();
		List<String> list = buffer.appendContent(new String("123!$abcdefg\r\n123!$hijklmn\r!$opq").toCharArray());
		for(String str : list){
			System.out.println(str);
		}
		
		list = buffer.appendContent(new String("123456\n!123").toCharArray());
		for(String str : list){
			System.out.println(str);
		}
		
		list = buffer.appendContent(new String("456789!").toCharArray());
		for(String str : list){
			System.out.println(str);
		}
		
		list = buffer.appendContent(new String("abcdefghijklmn\r$xyz").toCharArray());
		for(String str : list){
			System.out.println(str);
		}
		
		list = buffer.appendContent(new String("\r\n123!$456\r\n").toCharArray());
		for(String str : list){
			System.out.println(str);
		}
		
		list = buffer.appendContent(new String("!$111\r\n").toCharArray());
		for(String str : list){
			System.out.println(str);
		}
		
		buffer.printBuffer();
//		Buffer buffer = new Buffer("123!$abcdefg\r\n123!$hijklmn\r!$opq");
//		int begin = buffer.findBeginMark();
//		System.out.println(begin);
//		System.out.println(buffer.findEndMark(begin + 1));
		
	}

}
