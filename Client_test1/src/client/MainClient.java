package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class MainClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 2.Ŭ���̾�Ʈ ��Ÿ�� �ۼ�.
		// Ŭ���̾�Ʈ�� ������ �ٸ��� ���� �����ϰ� �ۼ��� ����
		// "Socket"��ü�� �����Ͽ� ������ ���� �õ�,
		// ����Ǹ� ��Ʈ�� ���·� �����͸� �ְ� �ޱ⸸ �ϸ� �ȴ�.
		
		try {
			// ---------------------------------------------------
			Socket c_socket = new Socket("192.168.0.3", 8888);
			// "Socket" ��ü�� �����Ͽ� ������ �õ��ϴ� �κ�.
			// ������ IP�ּҿ� Port ��ȣ�� �Ű������� �Ѱ��־�� �ش� �ּҷ� ������ �õ�.
			// ������ �ּҿ�, port��ȣ�� �°� �ۼ�����.
			// ---------------------------------------------------
			
			
			// ---------------------------------------------------
			InputStream input_data = c_socket.getInputStream();
			
			byte[] receiveBuffer = new byte[100];
			input_data.read(receiveBuffer);
			
			System.out.println(new String(receiveBuffer));
			// ���� ������ �Ϸ� �Ǿ��ٸ� �����͸� ��Ʈ�� ���·� �޾ƿͼ� �ܼ�â�� ���.
			// ---------------------------------------------------
			
			// ---------------------------------------------------
			// ��� :
			// 	1. "Socket"�� ����Ͽ�, IP, Port �ּҷ� ���� ��û.
			//	2. ������ �Ǹ� ��Ʈ�� ���·� �����͸� �ְ� �޴´�.
			// ---------------------------------------------------
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// ������ ���� �����Ŵ => Ŭ���̾�Ʈ�� ���.
		// Ŭ���̾�Ʈ�� �����Ű�� ������ ������ �õ���.
		// Ŭ���̾�Ʈ�� ������� ������ ����. => ������ ��.
		// ����Ǹ� ������ Welcome to My Server ���ڿ��� Ŭ���̾�Ʈ���� ����, ����.
		// Ŭ���̾�Ʈ�� �������� ���� ���ڿ��� ��� �� ����.
	}

}
