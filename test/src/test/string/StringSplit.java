package test.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringSplit {

	public static void main(String[] args) {
		List<String> strList = new ArrayList<String>();
		
		for(int i=0; i<4000000; i++) {
			strList.add("NAME"+i+"=MR03=2016N0001=441"+i);
		}
		
		long start = System.currentTimeMillis();
		//TODO
		int i = 0;
		for(String str:strList) {
//			String[] split = split(str);
//			String[] split = indexOf(str);;
			String[] split = stringTokenizer(str);
			for(String s:split) {
//				System.out.println(s);
				i++;
			}
		}
		System.out.println("i£º" + i);
		
		long end = System.currentTimeMillis();
		System.out.println("Ê±¼ä£º" + (end - start));
	}
	
	public static String[] split(String str) {
		List<String> result = new ArrayList<String>();
		String[] splits = str.split("=");
		
		return splits;
		
//		for(String split:splits) {
//			result.add(split);
//		}
//		
//		return result.toArray(new String[result.size()]);
	}
	
	public static String[] indexOf(String temp) {
		List<String> result = new ArrayList<String>();
		
		int index = 0;//temp.indexOf("=");
		while((index=temp.indexOf("=")) > 0) {
			String current = temp.substring(0, index);
			result.add(current);

			temp = temp.substring(index + 1);
		}
		result.add(temp);
		
		return result.toArray(new String[result.size()]);
	}
	
	public static String[] stringTokenizer(String str) {
		List<String> result = new ArrayList<String>();

		StringTokenizer tokenizer = new StringTokenizer(str, "=");
		while(tokenizer.hasMoreTokens()) {
			result.add(tokenizer.nextToken());
		}
		
		return result.toArray(new String[result.size()]);
	}
}

