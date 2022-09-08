package n3_chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class asdf {
	public static void main(String[] args) {
		while (true) {
			try {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Socket socket = new Socket();
				socket.connect(new InetSocketAddress("192.168.1.47", 5003));
				System.out.println("연결 완료");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
