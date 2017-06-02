package test;

public class TestFinally {
	
	public static void main(String[] args) {
		int result = testFinally1();
		System.out.println(result);
		
		StringBuffer buffer = testFinally2();
		System.out.println(buffer);
		
		testFinally3();
	}

	@SuppressWarnings("finally")
	static int testFinally() {
		try {
			return 1;
		} catch (Exception e) {
			return 0;
		} finally {
			System.out.println("execute finally");
			return 3;
		}
	}
	
	static int testFinally1() {
		int result = 1;
		try {
			result = 2;
			return result;
		} catch (Exception e) {
			return 0;
		} finally {
			result = 3;
			System.out.println("execute finally1");
		}
	}
	
	static StringBuffer testFinally2() {
		StringBuffer s = new StringBuffer("Hello");
		try {
			return s;
		} catch (Exception e) {
			return null;
		} finally {
			s.append(" World");
			System.out.println("execute finally2");
		}
	}
	
	static void testFinally3() {
		try {
			System.out.println("try block");
			System.exit(0);
		} catch (Exception e) {
			System.out.println("catch block");
		} finally {
			System.out.println("finally block");
		}
	}
}
