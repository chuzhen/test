package test;

public class TestParameter {

	static void changeString(StringBuffer ss1, StringBuffer ss2) {
		ss1.append(" World");
		ss2 = ss1;
		
	}
	
	public static void main(String[] args) {
		Integer a = 1;
		Integer b = a;
		b++;
		
		System.out.println(a);
		System.out.println(b);
		
		StringBuffer s1 = new StringBuffer("Hello");
		StringBuffer s2 = new StringBuffer("Hello");
		
		changeString(s1, s2);
		
		System.out.println(s1);
		System.out.println(s2);
		
		int c = 'Œ“';
		System.out.println("c = " + c);
//		int i = 1;
		String s = "a";
//		int i = Integer.parseInt(s);
//		System.out.println(i);
		
//		int x = 1, y = 2, z = 3;
		double x = 1, y = 2, z = 3;
		y += z--/++x;
		System.out.println(y);
	}
}
