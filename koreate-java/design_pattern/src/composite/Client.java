package composite;

public class Client {
	public static void main(String[] args) {
		int i = 0;
		Computer computer = new Computer();

		for (i = 0; i < 100; i++) {
			computer.addComponent(new Monitor(10, 10));
			computer.addComponent(new Keyboard(1, 1));
			computer.addComponent(new Body(100, 100));
		}
		
		int j = 0;
		
		for (i = 0; i < 10; i++) {
			long start = System.nanoTime();
			computer.getPrice();
			long end = System.nanoTime();
			int sum = Math.toIntExact(end - start);
			System.out.println("if      : " + sum);

			start = System.nanoTime();
			computer.getPower();
			end = System.nanoTime();
			int sum2 = Math.toIntExact(end - start);
			System.out.println("향상 for문: " + sum2);
			if(sum > sum2)j++;
		}
		System.out.println("향상 for가 더 빠른 횟수: "+j);
		
	}
}
