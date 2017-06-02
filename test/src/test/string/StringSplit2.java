package test.string;

import java.util.StringTokenizer;

public class StringSplit2 {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<1000; i++) {
			sb.append("NAME=MR03=2016N0001=441");
		}
		
		String orgStr = sb.toString();
		
		long start = System.currentTimeMillis();
		
		for(int i=0; i<10000; i++) {
			//TODO
//			split(orgStr);
			indexOf(orgStr);
//			stringTokenizer(orgStr);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("ʱ�䣺" + (end - start));
	}
	
	public static void split(String str) {
		str.split("=");
	}
	
	public static void indexOf(String temp) {
		int index = 0;//temp.indexOf("=");
		while((index=temp.indexOf('=')) >= 0) {
			temp = temp.substring(index + 1);
		}
	}
	
	public static void stringTokenizer(String str) {
		StringTokenizer tokenizer = new StringTokenizer(str, "=");
		while(tokenizer.hasMoreTokens()) {
			tokenizer.nextToken();
		}
	}
}

