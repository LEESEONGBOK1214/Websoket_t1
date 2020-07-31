package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;



public class ChatClient {

	public static String UserID;
	// �������̼� ��ȭ�ϴ� ���α׷��̴ٺ��� "UserID"�� ���.
	// �ܿ� ���� �ٸ����� ����.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Ŭ���̾�Ʈ�� ���۵ƽ��ϴ�.");
		
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
