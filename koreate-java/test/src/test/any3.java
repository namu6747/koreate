package test;

interface inter{
	void method();
}
class aa implements inter{

	@Override
	public void method() {
		System.out.println("hello");
	}
	
}
class bb extends aa{
}

public class any3 {
	
	public static void main(String[] args) {
		bb b = new bb();
		aa a = new aa();
		inter i = a;
		i.method();
		a.method();
		b.method();
	}
	
	
}
