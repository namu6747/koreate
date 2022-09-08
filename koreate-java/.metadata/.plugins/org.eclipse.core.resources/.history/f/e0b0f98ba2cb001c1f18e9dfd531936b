package singleton;

public class Printer {

	private static Printer printer;
	int page = 50;
	
	private Printer() {
		
	}
	public static  Printer getPrinter() {
		if(printer == null) {
			printer = new Printer();
		}
		return printer;
	}

	public void print(String message) {
		System.out.println(message);
		page--;
		System.out.println("남은 용지: "+page);
		}
	}
	

