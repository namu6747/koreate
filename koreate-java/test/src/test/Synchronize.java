package test;

class Calculator {
	private int memory;
	
	int getMemory() {
		return memory;
	}
	
	 synchronized void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		}catch(Exception e){};
		System.out.println(Thread.currentThread().getName()+": "+this.memory);
	}
}

class User1 extends Thread{
	private Calculator calculator;
	void setCalculator(Calculator calculator) {
		this.setName("User1");
		this.calculator = calculator;
	}
	public void run() {
		calculator.setMemory(100);
	}
}
class User2 extends Thread{
	private Calculator calculator;
	void setCalculator(Calculator calculator) {
		this.setName("User2");
		this.calculator = calculator;
	}
	public void run() {
		calculator.setMemory(50);
	}
}

public class Synchronize {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
//		Scanner
		User1 user1 = new User1();
		user1.setCalculator(calculator);
		user1.start();
		User2 user2 = new User2();
		user2.setCalculator(calculator);
		user2.start();
	}
}
