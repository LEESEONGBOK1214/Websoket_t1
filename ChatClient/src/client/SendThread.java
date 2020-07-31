package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class SendThread extends Thread {
	private Socket m_Socket;

	@Override
	public void run() {

		super.run();

		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			
			String sendString;
			
			System.out.print("사용할 ID를 입력해주십시오 : ");
			ChatClient.UserID = tmpbuf.readLine();
			// id 를 묻고 입력받은 ID를 userid에 대입.
			
			
			sendWriter.println("IDhighkrs12345" + ChatClient.UserID);
			sendWriter.flush();
			// id를 서버로 최초 한번 전송.			
			while (true) {
				sendString = tmpbuf.readLine();

				if(sendString.equals("exit")) {
					break;
				}
				
				sendWriter.println(sendString);
				sendWriter.flush();
				// 챗 데이터들을 전송.
			}	
			
			sendWriter.close();
			tmpbuf.close();
			m_Socket.close();
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
	}
}
