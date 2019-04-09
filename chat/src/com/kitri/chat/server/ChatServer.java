package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;


//Address already in use: JVM_Bind 에러 : 접속하려는 포트가 이미 사용중이라는 에러임

// 내 서버
// 내 창

public class ChatServer implements Runnable {    //*프레임 extends할 예정이므로, 스레드 처리를 위해 Runnable을 implements

	// *만들어진 클라이언트를 저장할 vector 생성
//	Vector<ChatClient> list = new Vector<ChatServer.ChatClient>();
	Vector<ChatClient> list = new Vector<ChatClient>();
	
	// * ① 서버 소켓 한 번만 생성
	ServerSocket ss = null;

	// [생성자]
	public ChatServer() {
	
		try {
			ss = new ServerSocket(ChatConstance.PORT);
			System.out.println("클라이언트 접속 대기중............");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	// *클라이언트 접속 처리
	@Override
	public void run() {
		while(true) {
			try {
				Socket socket = ss.accept();
				System.out.println("클라이언트 접속 성공 :: " + socket);  //socket은 socket이 가진 toString() 호출 : 주소값 출력할 것임
				
				new ChatClient(socket).start(); //**
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// [inner class] : 클라이언트 만들기 / 바깥 변수를 맘대로 사용 가능함
	class ChatClient extends Thread {

		String name;           //대화명
		BufferedReader in;
		OutputStream out;
		
		public ChatClient(Socket socket) { //**
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				out = socket.getOutputStream();
				// 이제 메세지 주고 받을 수 있다
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// *클라이언트 메세지 처리
		@Override
		public void run() {
			boolean flag = true;
			while(flag) {
				try {
					String msg = in.readLine();
					System.out.println("클라이언트가 보낸 메세지 : " + msg); //프로토콜|메세지형식...
					StringTokenizer st = new StringTokenizer(msg, "|");
					int protocol = Integer.parseInt(st.nextToken());
					
					switch(protocol) {
						case ChatConstance.CS_CONNECT : {
							// 100|신지영
							// *내 대화명 얻어오기
							name = st.nextToken(); // name = "신지영"
							// *나를 제외한 모든 사람(Vector)에게 얻어온 내 대화명 알려주기
//							int size = list.size();
//							for(int i = 0; i<size; i++) {
//								ChatClient cc = list.get(i);
//							}							
							// 향상된 for문 사용
							for(ChatClient cc : list) {
								cc.out.write((ChatConstance.SC_CONNECT + "|" + name +"\n").getBytes());
							}
							// *Vector에 나를 포함시킴
							list.add(this);
							
							// *나를 포함한 모든 사람(Vector)에게 모든사람의 대화명을 알려주기
							for(ChatClient cc : list) {
								this.out.write((ChatConstance.SC_CONNECT + "|" + cc.name +"\n").getBytes());
							}
							
						} break;
						
						case ChatConstance.CS_ALL : {
							String tmp = st.nextToken();
							for(ChatClient cc : list) {
								cc.out.write((ChatConstance.SC_MESSAGE+ "|[" + name +"] " + tmp + "\n").getBytes());
							}
						} break;
						
						case ChatConstance.CS_TO : {
							
						} break;
						
						case ChatConstance.CS_PAPER : {
							
						} break;
						
						case ChatConstance.CS_RENAME : {
							
						} break;
						
						case ChatConstance.CS_DISCONNECT : {
							
						} break;
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	// [메인 실행 메소드]
	public static void main(String[] args) {
//		ChatServer cs = new ChatServer();
//		Thread t = new Thread(cs);     //*스레드의 타겟 Runnable 객체로써, Runnable을 implements한 ChatServer객체를 넣음
//		t.start();
		
		new Thread(new ChatServer()).start(); //t로는 start()밖에 할 일이 없으므로, 익명객체로 해버린다.
		
	}
	
}

