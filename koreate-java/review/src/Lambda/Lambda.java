package Lambda;

import java.util.Random;

interface Printable{
	void print(String s);
}

@FunctionalInterface
interface Calculate<T>{
	T cal(T a, T b);
	default int add(int a,int b) { return a+b;}
	static int sub(int a,int b) { return a-b;}
}

interface HowLong{
	int len(String s);
}

interface Generator{
	int rand();
}
class Printer implements Printable{
	public void print(String s) {
		System.out.println(s);
	}
}

public class Lambda {

	public static void main(String[] args) {
		
		
		Printable printer = new Printer();
		printer.print("hello world");
		
		Printable AnonymousPrinter = new Printable () {
			@Override
			public void print(String s){
				System.out.println("hello World");
			}
		};
		AnonymousPrinter.print("hello world");
		
		
		
		
		
		Printable lambda = (String s) -> {System.out.println(s);};
		lambda = (String s) -> System.out.println(s);
		lambda = (s) -> System.out.println(s);
		lambda = s -> System.out.println(s);
		
		lambda.print("hello world");
		
		Calculate<Integer> c;
		c = (a,b) -> {return a + b;};
		c = (a,b) -> a + b;
		System.out.println(c.cal(3, 5));
		
		String text = "asdsabejs";
		HowLong h = s -> s.length();
		System.out.println(h.len(text));
		
		Generator g = () -> {
			Random rand = new Random();
			return rand.nextInt();
			};
		System.out.println(g.rand());
		
		
	}

}
