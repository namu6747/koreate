package test.temp;

public class single {
	
	private static single s;
	
	private single(){};
	
	public static single getSingle() {
		if(s == null) {
		s = new single();
		}
		return s;
	}
	
	public static void methodA() {}
	
	public void methodB() {
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		single.methodA();
		single a = single.getSingle();
		a.methodB();
		a.methodA();
	}

}
