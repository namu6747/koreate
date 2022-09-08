package ex_5_06;

public class Main {

	public static <T> void printArray(T[] t){
		for(T m:t) {
			System.out.print(m+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Integer[] iArray = { 10, 20, 30, 40, 50 };
		Double[] dArray = { 1.1, 1.2, 1.3, 1.4, 1.5 };
		Character[] cArray = { 'K', 'O', 'R', 'E', 'A' };
//		배열출력
		printArray(iArray);
		printArray(dArray);
		printArray(cArray);
	}

}
