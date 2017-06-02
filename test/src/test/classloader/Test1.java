package test.classloader;

public class Test1 {
	public static void main(String args[]) {
		System.out.println(FinalTest.x);
//		FinalTest.x =3;
	}
}

class FinalTest {
	public static final int x = 6 / 3;
	static {
		System.out.println("FinalTest static block");
	}
}
