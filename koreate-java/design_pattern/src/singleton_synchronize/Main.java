package singleton_synchronize;

public class Main {
	private static final int THREAD_NUM = 5;

	public static void main(String[] args) {
		UserThread[] user = new UserThread[THREAD_NUM];

		for (int i = 0; i < THREAD_NUM; i++) {
			user[i] = new UserThread((i + 1) + "-thread") {
				public void run() {
					Printer printer = Printer.getPrinter();
					printer.print(Thread.currentThread().getName() + " printer using " + printer.toString() + ".");
				}
			};
			try {Thread.sleep(100);}catch(Exception e) {};
			user[i].start(); // Runnable의 실체 메소드 run은 start로 호출
		}
		;
	}
}
