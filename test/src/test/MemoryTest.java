package test;

import java.util.HashSet;
import java.util.Set;

public class MemoryTest {
	public static void main(String[] args) {
		Set<Person> set = new HashSet<Person>();
		Person p1 = new Person("��ɮ", "pwd1", 25);
		Person p2 = new Person("�����", "pwd2", 26);
		Person p3 = new Person("��˽�", "pwd3", 27);
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println("�ܹ���:" + set.size() + " ��Ԫ��!"); // ������ܹ���:3 ��Ԫ��!
		printPerson(set);
		
		p3.setAge(2); // �޸�p3������,��ʱp3Ԫ�ض�Ӧ��hashcodeֵ�����ı�
//		set.remove(p3); // ��ʱremove����������ڴ�й©
		System.out.println("�ܹ���:" + set.size() + " ��Ԫ��!"); // ������ܹ���:��Ԫ��!
		printPerson(set);

		set.add(p3); // ������ӣ���Ȼ��ӳɹ�
		System.out.println("�ܹ���:" + set.size() + " ��Ԫ��!"); // ������ܹ���:4 ��Ԫ��!
		printPerson(set);
	}

	private static void printPerson(Set<Person> set) {
		for (Person person : set) {
			System.out.println(person);
		}
	}

}

class Person {
	private String name;
	private String password;
	private int age;

	public Person(String name, String password, int age) {
		super();
		this.name = name;
		this.password = password;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return super.toString() + this.name+ "=" + this.password+ "=" + this.age;
	}

	
}
