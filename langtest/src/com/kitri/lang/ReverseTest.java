package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class ReverseTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "!!! avaJ olleH";	
		char ch = 'e';
		
		String result = "";
		
		//최소 3가지 방법을 뽑아내기
		// 1) Hello Java !!! 만들기
		// 2) e는 2번째 있습니다.
				
		// 1. charAt()
		int len = str.length();
		for (int i = len-1; i >= 0; i--) {
			result += str.charAt(i);
		}
		System.out.println(result);

		System.out.println(ch + "는 " + (result.indexOf(ch)+1) + "번째 있습니다.");

		result = "";
		
		// 2. toCharArray() : 영어, 한글
		char c[] = str.toCharArray();
		for(int i = len-1; i>=0; i--) {
			result += c[i];
		}
		System.out.println(result);
		
		System.out.println(ch + "는 " + (result.indexOf(ch)+1) + "번째 있습니다.");
		
		result = "";

		
		// 3. getBytes() : 영어
		byte b[] = str.getBytes();		
		byte b2[] = new byte[len];
		
		int x = 0;
		for(int i = len-1; i>=0; i--) {
			b2[x++] += b[i];
		}
		
		String result2 = new String(b2);
		System.out.println(result2);
		
		System.out.println(ch + "는 " + (result2.indexOf(ch)+1) + "번째 있습니다.");	
				
		//String은 지정된 값 자체를 바꿀 수 없음!
		//따라서 문자열의 변형은 StringBuffer(임시 저장 공간)를 이용해야 함
		StringBuffer sb = new StringBuffer(str)	;
		System.out.println(sb.reverse());
		
	}

}
