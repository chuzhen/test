package test.classloader;

public class Singleton {

	public static int counter1;
	public static int counter2 = 0;
	private static Singleton singleton = new Singleton();

	private Singleton() {
		counter1++;
		counter2++;
	}

	public static Singleton getSingleton() {
		return singleton;
	}

	public static void main(String[] args) {
		Singleton singleton = Singleton.getSingleton();
		System.out.println("counter1=" + singleton.counter1);
		System.out.println("counter2=" + singleton.counter2);

	}
}
