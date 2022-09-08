package test;

import java.util.function.Consumer;

public class any4 {
	
	static int asdf(int a) {
		return 0;
	}
	
	static Consumer<Integer> con = any4::asdf;  

	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");
		
		
		System.out.println(str1 == str2);
		System.out.println(str2 == str3);
		System.out.println(str3 == str4);
		System.out.println(str1.equals(str2));
		System.out.println(str2.equals(str3));
		System.out.println(str3.equals(str4));
		System.out.println();
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		System.out.println(str3.hashCode());
		System.out.println(str4.hashCode());
		System.out.println();
		System.out.println(str1.intern());
		System.out.println(str2.intern());
		System.out.println(str3.intern());
		System.out.println(str4.intern());
		
		System.out.println();
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		
		con.accept(5);
	}
	
}
