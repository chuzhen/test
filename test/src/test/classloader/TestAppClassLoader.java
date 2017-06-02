package test.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import test.consts.TestConsts;

public class TestAppClassLoader {
	
	private static String name = TestConsts.NAME;

	public static void main(String[] args) throws IOException {
		ClassLoader classLoader = TestAppClassLoader.class.getClassLoader();
		System.out.println(classLoader);
		
		InputStream is = classLoader.getResourceAsStream("1.txt");
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		int len = 0;
		while((len = is.read(b)) != -1) {
			bos.write(b, 0, len);
		}
		
		String string = bos.toString();
		System.out.println(string);
		
		System.out.println(name);
	}
}
