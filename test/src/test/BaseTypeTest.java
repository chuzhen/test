package test;

public class BaseTypeTest {

	public static void main(String[] args) {
		char a = '²ã';
		System.out.println(a);
		
		test2();
	}

	private static void test1() {
		short a = 128;
		
		byte b = (byte) a;
		
		System.out.println(b);
	}
	
	static void test2() {
		Integer i01 = 59;
		int i02 = 59;
		Integer i03 =Integer.valueOf(59);
		Integer i04 = new Integer(59);

		System.out.println(i04 == i03);
	}
	
	static void test3() {
		
	}
}
