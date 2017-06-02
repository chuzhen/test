package test.javase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Autoboxing {

	private String name = "Autoboxing";
	
	public static void main(String[] args) {
		System.out.println("args.length = " + args.length);
		for(String arg:args) {
			System.out.println(arg);
		}
		
		Set<Integer> intSet = new TreeSet<Integer>();
		Integer a = new Integer(1);
		Integer b = new Integer(1);
		intSet.add(a);
		intSet.add(b);
		
		System.out.println(a == b);
		System.out.println(a.equals(b));
		System.out.println("a.hashCode() = " + a.hashCode());
		System.out.println("b.hashCode() = " + b.hashCode());
		System.out.println(intSet);
	}
}
