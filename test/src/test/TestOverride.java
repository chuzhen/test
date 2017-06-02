package test;

import java.io.IOException;

public class TestOverride {

	public static void main(String[] args) throws IOException {
		Flyable derived = new Derived1();
		
//		System.out.println(derived.i);
		derived.fly();
	}
}

class Base1 implements Flyable{
	public int i = 1;
	
	private final void test() throws IOException {
		System.out.println("base test");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
}

class Derived1 extends Base1 {
	public int i = 2;

//	@Override
	void test() {
		System.out.println("derived test");
	}
}

interface Flyable {
	void fly() throws IOException;
}
