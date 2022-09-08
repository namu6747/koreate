package t05_control_method.stop;

class InterruptThread extends Thread{
	public void run() {
		while(true) {
			System.out.println("실행중");
			if(Thread.interrupted()) {
				break;
			}
		}
		System.out.println("자원해제");
		System.out.println("실행종료");
	}
}

public class InterruptedExample {

	public static void main(String[] args) {
		InterruptThread t = new InterruptThread();
		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		t.interrupt();
	}

}
