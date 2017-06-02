package test;

public /*strictfp*/ class TestStrict {

	static Integer i;
	byte b = 127;
	
	static void testStrict() {
		float f  = 0.12365f;
		double d = 0.03496421d;
//				   0.15861421
		double fd = f;
		System.out.println(fd);
		
		double sum = f + d;
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		testStrict();
		
		System.out.println(i);
	}
}
