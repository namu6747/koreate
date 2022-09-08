package singleton_static;

public class Printer {

	private static int counter = 0;
	
	private Printer() {
		
	}
	public synchronized static void print(String message) {
		counter++;
		System.out.println(message + counter);
	}
	
}
