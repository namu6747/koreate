package ex_5_16;

class Animal{}

class Cat extends Animal{}

class Tiger extends Animal {}

public class ExtendsTest {

	public static void main(String[] args) {
		
		Animal c = new Cat();
		Animal t = new Tiger();
		if(t instanceof Cat) {
			Cat cat = (Cat)t;
			System.out.println("Cat type 맞음");
			System.out.println(cat);
		}else {
			System.out.println("Cat type 아님");
		}
		
	}
}
