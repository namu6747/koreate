package test;

import java.awt.Toolkit;
import java.util.Objects;

interface inf {
	default void sys() {
		System.out.println("hello");
	}
}

class superr implements inf{
	int hash;
	
	public superr(int hash) {
		this.hash = hash;
	}

	public static void checker(Object o) {
		System.out.println(o.getClass());
		if(o instanceof inf)System.out.println("true");
		else {System.out.println("false"); return;}
	}
	
}

class sub extends superr {
	
	int num = 5;
	
	public sub(int hash) {
		super(hash);
	}
	
}

public class any {

	
	public static void main(String[] args) {
		
		
		sub a = new sub(5);
		sub b = new sub(5);
		System.out.println(a);
		System.out.println(b);
		System.out.println(a.equals(b));
		System.out.println(Objects.equals(a, b));
		superr c = new superr(3);
		inf d = new sub(10);
		inf e = d;
		System.out.println(e + " " + d); 
		d.sys();
		c.sys();
		a.sys();
		// 부모 클래스로 형변환 됐다면 자식 클래스에 있던 필드에 접근할 수 없다.
		superr.checker(a);
		superr.checker(b);
		superr.checker(c);
		superr.checker(d);
		
	
		
		
				
	}

}
