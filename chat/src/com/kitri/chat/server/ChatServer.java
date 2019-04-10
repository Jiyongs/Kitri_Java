package com.kitri.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import com.kitri.chat.util.ChatConstance;
//Address already in use: JVM_Bind 에러 : 접속하려는 포트가 이미 사용중이라는 에러임


// 내 서버
// server >> client(상대방)
public class ChatServer implements Runnable {    //*프레임 extends할 예정이므로, 스레드 처리를 위해 Runnable을 implements

	// * 서버 소켓 한 번만 생성
	ServerSocket ss = null;
	
	// *만들어진 클라이언트를 저장할 vector 생성
	Vector<ChatClient> list = new Vector<ChatClient>();

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
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// [메인 실행 메소드]
	public static void main(String[] args) {
//		ChatServer cs = new ChatServer();
//		Thread t = new Thread(cs);     //*스레드의 타겟 Runnable 객체로써, Runnable을 implements한 ChatServer객체를 넣음
//		t.start();
		
		new Thread(new ChatServer()).start(); //t로는 start()밖에 할 일이 없으므로, 익명객체로 해버린다.
		
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// 내 창
	// server >> clients(각자)  
	// [inner class] : 클라이언트 만들기 / 바깥 변수를 맘대로 사용 가능함
	class ChatClient extends Thread {

		String name;           //내 대화명
		BufferedReader in;
		OutputStream out;
		
		Socket socket;
		
		public ChatClient(Socket socket) { //**
			try {
				this.socket = socket;
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
							// *나를 제외한 모든 사람(Vector)에게 대화명 전송하기   //멀티캐스트
							multicast(ChatConstance.SC_CONNECT + "|" + name);
							// *Vector에 나를 포함시킴
							list.add(this);
							
							// *나에게 접속된 대화명들을 알려주기                       //유니캐스트
							for(ChatClient cc : list) {
								unicast(ChatConstance.SC_CONNECT + "|" + cc.name);
							}
							
						} break;
						
						case ChatConstance.CS_ALL : {
							// 200|안녕하세요.
							String tmp = st.nextToken();
							multicast(ChatConstance.SC_MESSAGE+ "|[" + name +"] " + tmp); //멀티캐스트
						} break;
						
						case ChatConstance.CS_TO : {
							// 250|홍길동|안녕하세요.
							String to = st.nextToken();     //홍길동
							String tmp = st.nextToken();   //안녕하세요.
							for(ChatClient cc : list) {
								if(cc.name.equals(to)) {
									cc.unicast(ChatConstance.SC_MESSAGE + "|☆" + name + "☆" + tmp);  // 발신자 + 받은 귓속말
									break;
								}
							}
						} break;
						///////////////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
						case ChatConstance.CS_PAPER : {
							// 300|홍길동|홍길동님 쪽지 보냅니다.
							String to = st.nextToken();   //홍길동
							String tmp = st.nextToken(); //홍길동님 쪽지 보냅니다.
							for(ChatClient cc : list) {
								if(cc.name.equals(to)) {
									cc.unicast(ChatConstance.SC_PAPER + "|" + name + "|" + tmp);  // 발신자 + 받은 쪽지
								}
							}
						} break;
						
						case ChatConstance.CS_RENAME : {
							//400|새대화명
							String newname = st.nextToken(); //새대화명
							multicast(ChatConstance.SC_RENAME + "|" + name + "|" + newname);
							name = newname; //서버상의 대화명도 바꾼 대화명으로 변경!
						} break;
						
						case ChatConstance.CS_DISCONNECT : {
							// 900|
							multicast(ChatConstance.SC_DISCONNECT + "|" + name);  // ① Vector에 아직 내가 있기떄문에, 나한테도 이 메세지가 옴
							list.remove(this);                                                    // ② Vector에서 나를 뻄
							flag = false;                                                         // ③ 스레드를 종료한다고 명시
							in.close();                                                            // ④ 입출력, 소켓을 닫음         //if(in, out, socket==null)안하는 이유는 null이었음 일로 오지도 못했기 때문. 안 해도 됨!
							out.close();
							socket.close();
						} break;
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// <멀티캐스트> 메소드                  // 모든 사람에게 메세지 전송
		private void multicast(String msg) {
			// *나를 제외한 모든 사람(Vector)에게 얻어온 내 대화명 알려주기
//			int size = list.size();
//			for(int i = 0; i<size; i++) {
//				ChatClient cc = list.get(i);
//			}	
			// => 향상된 for문 사용
//			for(ChatClient cc : list) {
//				cc.out.write((msg + "\n").getBytes());
//			}
			// => unicast() 호출
			for(ChatClient cc : list) {
				cc.unicast(msg);
			}
		}
		
		// <유니캐스트> 메소드                // 한 사람에게 메세지 전송
		private void unicast(String msg) {
			try {
				out.write((msg + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	} //ChatClient 끝
	

	
} // ChatServer 끝

