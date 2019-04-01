package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {
	
	public static void main(String[] args) {
		
		// [StringTokenizer 클래스]
		String str = "hello java !!!";
		StringTokenizer st1 = new StringTokenizer(str); //str을 자를 준비가 됐음
		//StringTokenizer st2 = new StringTokenizer(str, "j");
		// *StringTokenizer() 생성 시, 문자열만 지정하면 default로 공백을 중심으로 자름
		//                                   기준도 지정하면 기준을 중심으로 자름
		
		// [countTokens()]
		int cnt = st1.countTokens();
		System.out.println("st1의 토큰 수 : " + cnt); //토큰 수 : 3 (공백 기준)
		//cnt = st2.countTokens();
		//System.out.println("st2의 토큰 수 : " + cnt); //토큰 수 : 2 ("j" 기준)
		
		// [hasMoreTokens()]
		// [nextToken()]
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken()); //공백 기준 토큰 3개를 각 줄에 출력! (3줄)
		}
		
		// *프로토콜 : 클라이언트와 서버의 통신 규약 (약속)
		//               송수신하는 정보의 기능을 명시하는 암호
		// |를 구분자로 하는 프로토콜 지정해보기
		str = "TO|수신자명|안녕하세요 오늘 뭐해요?";
		
		StringTokenizer st2 = new StringTokenizer(str, "|");
		String protocol = st2.nextToken();
		String to = st2.nextToken();
		String msg = st2.nextToken();
		System.out.println("기능 : " + protocol);
		System.out.println("누구에게 : " + to);
		System.out.println("보내는 메세지 : " + msg);
		
		// [UUID.randomUUID()]
		System.out.println(UUID.randomUUID());
	
	}
	
}
