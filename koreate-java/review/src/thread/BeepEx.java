package thread;

import java.awt.Toolkit;

class BeepThread extends Thread {

	BeepThread() {
		this.setName("BeepThread");
	}

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			;
		}
	}
}

public class BeepEx {
	public static void main(String[] args) {

		BeepThread beep = new BeepThread();

		Thread thread = new Thread() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("띵");
					try {Thread.sleep(1000);} catch (Exception E) {};
				}
			}
		};
		System.out.println(beep.getName());
		beep.start();
		thread.start();
		for(int i=0; i<5; i++) {
			System.out.println("띵띵");
			try {Thread.sleep(1000);} catch (Exception E) {};
		}

	}
}
