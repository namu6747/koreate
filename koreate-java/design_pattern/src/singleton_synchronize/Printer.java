package singleton_synchronize;

public class Printer {

	private static Printer printer = null;
	int page = 50;
	
	private Printer() {
		
	}
	//synchronized
	public static  Printer getPrinter() {
		if(printer == null) {
			
			printer = new Printer();
		}
		return printer;
	}

	public void print(String message) {
		synchronized(this) { // 오직 하나의 스레드만 접근 허용
		System.out.println(message);
		page--;
		System.out.println("남은 용지: "+page);
		}
	}
	
}
