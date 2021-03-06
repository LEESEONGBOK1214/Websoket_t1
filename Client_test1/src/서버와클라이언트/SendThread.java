package 서버와클라이언트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread{
	private Socket m_Socket;
	
	public void run() {
		
		super.run();
		
		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
			
			String sendString;
			
			while(true)
			{
				sendString = tmpbuf.readLine();
				
				if(sendString.equals("exit"))
				{
					break;
				}
				// exit을 입력시, 소켓 접속을 끊고 프로그램 종료.
				
				sendWriter.println(sendString);
				sendWriter.flush();
			}
			
			sendWriter.close();
			tmpbuf.close();
			m_Socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void setSocket(Socket _socket)
	{
		m_Socket = _socket;
	}
}
