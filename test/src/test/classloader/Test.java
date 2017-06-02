package test.classloader;

public class Test {

	static {
		System.out.println("static block1");
	}
	
	static T1 t1 = new T1();
	
	static {
		System.out.println("static block2 i = ");
	}
	
	public static void main(String[] args) {
		
	}
}

class T1 {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	T1() {
		System.out.println("T1 constructor");
	}
}