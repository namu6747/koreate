package test;

import java.awt.Toolkit;

public class temp {

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				Thread thread = new Thread(new Runnable() {
					Toolkit tool = Toolkit.getDefaultToolkit();

					@Override
					public void run() {
						for (int i = 0; i < 5; i++) {
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
							}
							tool.beep();
							System.out.println("beep");
						}
					}
				});
				thread.start();
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			System.out.println("띵");
		}
		System.out.println(String.class);

	}

}
