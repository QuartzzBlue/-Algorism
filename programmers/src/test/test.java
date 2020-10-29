package test;

import java.util.*;

public class test {
	public static void main(String[] args) {
		ArrayList<Person> list = new ArrayList<>();
		
		list.add(new Person("홍길동", 20));
		
		list.add(new Person("강동원", 40));
		list.add(new Person("나동현", 30));
		
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				int n1 = o1.getAge();
				int n2 = o2.getAge();
				
				return n2 - n1;
//				if(n1 > n2) {
//					return -1;
//				}else if(n1 < n2){
//					return 1;
//				}else {
//					return 0;
//				}
			}
			
//			@Override
//			public int compare(Person o1, Person o2) {
//				return (o2.getName()+o1.getName()).compareTo(o1.getName()+o2.getName());
////				return (o1.getName()+o2.getName()).compareTo(o2.getName()+o1.getName());
//			}
			
		});
		
		System.out.println(list.toString());
		

	}
}

class Person{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	

}