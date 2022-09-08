package test;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InstanceAndAddr {
	String name;
	int a;
	InstanceAndAddr(){ this.name = "재민"; }
	
	static void ma (InstanceAndAddr a) {
		a = new InstanceAndAddr();
		a.name = a.name.concat("hello");
	}
	void mc (InstanceAndAddr a) {
		a = new InstanceAndAddr();
		this.name = this.name.concat("hello");
	}
	
	static InstanceAndAddr mb () {
		
		return new InstanceAndAddr();
	}
	
	
	public static void main(String[] args) {
		
		Comparator<InstanceAndAddr> p = (o1, o2) -> {
			return o1.a - o2.a;
		};
		
		InstanceAndAddr a = new InstanceAndAddr();
		System.out.println(a);
		
		a = new InstanceAndAddr(); // 실행문에서 새로운 인스턴스 참조 가능
		System.out.println(a); 
		System.out.println(a.name);
		
		ma(a); // 메소드 내부에서 새로운 참조 불가능
		System.out.println(a);
		System.out.println(a.name);
		
		a = mb(); // 반환 값으로 새로운 참조 가능
		System.out.println(a);
		
		a.mc(a);
		System.out.println(a);
		System.out.println(a.name);
		Callable<Integer> call = () -> {
			return 100;
		};
		ExecutorService exr = Executors.newSingleThreadExecutor();
		Future<Integer> i = exr.submit(call);
		exr.shutdown();
	
		temp.method();
		System.out.println(0x7852e922);
		System.out.println(System.identityHashCode(a));
		
		String str = new String("hello");
		String str2 = new String("hello");
		System.out.println(System.identityHashCode(str));
		System.out.println(System.identityHashCode(str2));
		
		System.out.println(Integer.MAX_VALUE + 1);
	}
	interface temp{
		public static void method() {
			System.out.println("method");
		}
	}
	
}
