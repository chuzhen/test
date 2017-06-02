package test.tupu360;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i<Integer.MAX_VALUE; i++) {
			list.add(String.valueOf(i).intern());
		}
	}
}
