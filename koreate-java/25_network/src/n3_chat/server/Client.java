package n3_chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

// socket으로 연결된 client의 정보를 저장하고
// 기능을 수행 할 class
public class Client {
	
	// 연결된 Client socket정보를 저장할 필드
	Socket socket;

	public Client(Socket socket) {
		this.socket = socket;
		receive();
	}
	
	// 연결된 client에게 메세지를 전달할 메소드
	public void send(String message) {
		OutputStream os = null;
		byte[] bytes = message.getBytes();
		
		try {
			os = socket.getOutputStream();
			os.write(bytes);
			os.flush();
		} catch (IOException e) {
			System.out.println("Client 통신 안됨");
			try {
				if(os != null) os.close();
				if(socket != null && !socket.isClosed()) {
					socket.close();
				}
				ChatServerExample.clients.remove(this);
			} catch (IOException e1) {}
		}
		
	}
	
	// client가 전달하는 메세지를 읽음.
	public void receive() {
		System.out.println("receive 호출 완료");
		Thread t = new Thread(new Runnable() {
			public void run() {
				while(true) {
					InputStream is = null;
					byte[] bytes = new byte[100];
					
					try {
						is = socket.getInputStream();
						int readCount = is.read(bytes);
						String sender = socket.getInetAddress().getHostAddress()+":"+socket.getPort();
						String data = new String(bytes,0,readCount,"UTF-8");
						data = sender+" : "+data;
						System.out.println("[ 요청 처리 완료 ] - "+data);
						for(Client c : ChatServerExample.clients) {
							c.send(data);
						}
					} catch (IOException e) {
						System.out.println("Client 통신안됨 -");
						try {
							if(is != null) is.close();
							if(!socket.isClosed())socket.close();
						} catch (IOException e1) {}
						ChatServerExample.clients.remove(Client.this);
						break;
					}
				} // while 문 종료
			}
		});
		t.start();
	}

}



