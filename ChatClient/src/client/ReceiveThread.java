package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread {
	private Socket m_Socket;

	// -------------------------------------------------------
	public void run() {
		super.run();

		try {
			BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));

			String receiveString;
			String[] split;

			while (true) {
				receiveString = tmpbuf.readLine();

				split = receiveString.split(">");

				if (split.length >= 2 && split[0].equals(ChatClient.UserID)) {
					continue;
					
				}
				// 메세지를 받아왔을때 해당 메세지의 ID가 자기 자신이라면,
				// 콘솔창에 출력을 막아주는 부분.
				//  -> 자기 자신이 쓴 메세지를 서버에 보내고 서버에서는
				//	모든 클라이언트에게 전달하기 때문에 다시 돌려받는다.
				//	그러므로 자기자신의 메세지는 뿌려줄 필요가 없으므로 걸러줌.

				// 그 외는 전 강의와 동일.
				System.out.println(receiveString);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setSocket(Socket _socket) {
		m_Socket = _socket;
		// 메인으로부터 "Socket" 객체를 받기 위한 메소드.
	}
}
