package cn.kevin.dataguru.nmea_server.codecmanager;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Buffer {

	//capacity is 1024
	private CharBuffer charBuffer = CharBuffer.allocate(1024);
	
	public List<String> appendContent(char[] content){
		List<String> list = new ArrayList<String>();
		if(charBuffer.remaining() > content.length){
			charBuffer.put(content);
			charBuffer.flip();
			int begin = -1, end = -1;
			do{
				begin = findBeginMark();
				end = findEndMark(begin + 1);
				if (begin >=0 && end > begin) {
					char[] sentence = new char[end + 1];
					charBuffer.get(sentence, 0, end + 1);
					extract(sentence, begin, end, list);
				}
			}while (begin >= 0 && end > 0);
			if(charBuffer.hasRemaining()){
				CharBuffer temp = CharBuffer.allocate(charBuffer.remaining());
				temp.put(charBuffer);
				temp.flip();
				charBuffer.clear();
				charBuffer.put(temp);
			}
		}
		return list;
	}
	
	/**
	 * find the last index which char is '!' or '$'
	 * @return
	 */
	private int findBeginMark() {
		for (int index = 0 ; index < charBuffer.remaining(); index ++) {
			char c = charBuffer.charAt(index);
			if (c == '!' || c == '$'){
				if(index + 1 < charBuffer.remaining()){
					char nextc = charBuffer.charAt(index + 1);
					if(nextc == '!' || nextc == '$' )
						return index + 1;
				}
				return index;
			}
		}
	    return -1;
	}
	
	/**
	 * find the first index which char is '\n' or '\r'
	 * if not found, get the next index of '!' or '$'  
	 * @param startindex
	 * @return
	 */
	private int findEndMark(int startindex) {
		for (int index = startindex; index < charBuffer.remaining(); index ++) {
			char c = charBuffer.charAt(index);
			if (c == '\n' || c == '\r') {
				return index;
			} else if (c == '!' || c == '$') {
				return index - 1;
			}
		}
		return -1;
	}
	
	private void extract(char[] original, int from, int to, List<String> list){
		int end = to;
		if(original[to] != '\r' && original[to] != '\n'){
			end = end + 1;
		}
		char[] sentence = Arrays.copyOfRange(original, from + 1, end);
		list.add(new String(sentence));
	}
	
	public void printBuffer(){
		System.out.println("---charBuffer print start---");
		System.out.println(charBuffer.position());
		System.out.println(charBuffer.limit());
		System.out.println(charBuffer.capacity());
		System.out.println(charBuffer.remaining());
		System.out.println("---charBuffer print end---");
	}
	
}
