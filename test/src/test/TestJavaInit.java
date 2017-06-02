package test;

/**
 * 变量>代码块>构造方法
 * @author chuzhen
 *
 */
public class TestJavaInit {
	
	final int i = 0;
	final int j;
	final static int k = 0;
	
	TestJavaInit() {
		j = 1;
		
	}
	
//	{
//		j = 1;
//	}
//	
//	static {
//		k = 1;
//	}

	public static void main(String[] args) {
		new Derived();
	}
}

class Base {
	
	private static int base = 1;
	
	static {
		System.out.println("Base static block base = " + base);
		base = 2;
	}
	
	{
		System.out.println("Base None static block base = " + base);
		base = 3;
	}
	
	Base() {
		System.out.println("Base Constructor base = " + base);
		base = 4;
	}
}

class Derived extends Base {
	
	private static int base = 1;
	
	static {
		System.out.println("	Derived static block base = " + base);
		base = 5;
	}
	
	{
		System.out.println("	Derived None static block base = " + base);
		base = 6;
	}
	
	Derived() {
		System.out.println("	Derived Constructor base = " + base);
		base = 7;
	}
}