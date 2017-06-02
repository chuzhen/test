package test.javase;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class MyList {
	
	private static final Random random = new Random();
	
	public static void main(String[] args) {
		for(int i = 2; i<80; i = i*2) {
			System.out.println(random(i));
		}
	}
	
	static int random(int n) {
		return Math.abs(random.nextInt());
	}
}

