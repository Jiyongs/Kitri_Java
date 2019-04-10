package com.kitri.chat.util;

	// client(나) >> server >> client(상대방)

public class ChatConstance {
	
	// ip 정의
	public static final int PORT = 9876;

	// 프로토콜 정의
	// client(나) >> server                                                   //[Login.java]
	// ① 접속								100|대화명  
	// ② 모든사람 메세지					200|메세지
	// ③ 특정사람 메세지 (귓속말)		250|대상자|메세지
	// ④ 쪽지 보내기						300|대상자|메세지
	// ⑤ 대화명 변경						400|변경할대화명
	// ⑥ 접속 종료							900|
	
	public static final int CS_CONNECT = 100;
	public static final int CS_ALL = 200;
	public static final int CS_TO = 250;
	public static final int CS_PAPER = 300;
	public static final int CS_RENAME = 400;
	public static final int CS_DISCONNECT = 900;
	
	// server >> client(상대방)                                              //[ChatServer.java]
	// ① 접속								100|접속자대화명
	// ② 메세지	(전체)						200|[보낸사람대화명] 메세지         //메세지 출력 형태로 보내버림
	// ③ 메세지  (특정)						200|☆보낸사람대화명☆ 메세지
	// ④ 쪽지 보내기						300|보낸사람대화명|메세지
	// ⑤ 대화명 변경						400|변경전대화명|변경할대화명      //변경전과 후를 띄워줘야 하니까
	// ⑥ 접속 종료							900|접속자대화명                       //누가 나갔는지 띄워줘야 하니까
	
	public static final int SC_CONNECT = 100;
	public static final int SC_MESSAGE = 200;
	public static final int SC_PAPER = 300;
	public static final int SC_RENAME = 400;
	public static final int SC_DISCONNECT = 900;
	
}
