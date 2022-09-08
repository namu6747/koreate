package singleton;

public class del {

	public static void main(String[] args) {
		int[] array = new int[10];
		for(int i=0; i<10; i++) {
			if(!(i>3 && i<7)) {
				array[i] = i;
				
			}
			System.out.println(array[i]);
		}
		
	}

}
