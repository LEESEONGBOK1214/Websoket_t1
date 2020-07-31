package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;



public class ChatClient {

	public static String UserID;
	// 여러명이서 대화하는 프로그램이다보니 "UserID"를 사용.
	// 외에 전과 다른점은 없다.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("클라이언트가 시작됐습니다.");
		
		try {
			Socket c_socket = new Socket("192.168.0.3", 8888);
			
			ReceiveThread rec_thread = new ReceiveThread();
			rec_thread.setSocket(c_socket);
			
			SendThread send_thread = new SendThread();
			send_thread.setSocket(c_socket);
			
			rec_thread.start();
			send_thread.start();

			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
