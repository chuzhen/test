package test.classloader;

public class Test2 {

	{
		new A(2);
	}
	private A i = new A(1);
	
	
	Test2() {
	}
	
	public static void main(String[] args) {
		new Test2();
	}
}

class A {
	public A(int i) {
		System.out.println("A" + i);
	}
}

