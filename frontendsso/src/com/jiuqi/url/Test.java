package com.jiuqi.url;

import com.jiuqi.util.JqLib;

public class Test {

	public static void main(String[] args) {
		String encodePassword = JqLib.encodePassword("admin", 20);
		System.out.println(encodePassword);
		
		String decodePassword = JqLib.decodePassword(encodePassword);
		System.out.println(decodePassword);
		
		decodePassword = JqLib.decodePassword(encodePassword);
		System.out.println(decodePassword);
	}
}
