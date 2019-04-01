package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest2 {

	public static void main(String[] args) throws UnsupportedEncodingException {

		// NullPointer Exception error : null값을 가진 객체는 아직 메모리에 올라가기 전이기 때문
		//                                     객체가 참조하는 주소값이 없다는 에러
		//String str = null;  
		
		// [ String() ]
		String str1 = new String();  // = ""
		System.out.println("문자열 길이 : " + str1.length()); // 문자열 길이 : 0
		
		//byte b[] = new byte[4];      //배열 생성 방법 1
		//byte b[] = {97, 98, 99, 100};  //배열 생성 방법 2
		//String str2 = new String(b);
		//System.out.println("str2 : "+ str2);  // str2 : abcd (ASI code)
		
		// [ String(byte[] bytes) ]
		byte b[] = {-66, -56, -77, -25, -57,-49, -68, -68, -65, -28, 46};
		String str2 = new String(b);
//		String str2 = new String(b, "euc-kr"); // 디폴트가 euc-kr
		System.out.println("str2 : "+ str2);  // str2 : 안녕하세요. (ASCII code)
		
		byte b2[] = {-20, -107, -120, -21, -123, -107, -19, -107, -104, -20, -124, -72, -20, -102, -108, 46}; // utf-8로 쪼갬(한 글자 당, 3byte)
		String str3 = new String(b2, "utf-8"); // utf-8로 다시 합침
		System.out.println("str3 : "+ str3);  // str2 : 안녕하세요. (utf-8)
		
		// ascii code 값이 다른데, 왜 밑에도 안녕하세요 일까 (엄청 중요)
		// 위는 완성형 한글 (ascii / 2byte)
		// 아래는 자음, 모음 따로 있는 한글 (utf-8 / 3byte) ... 글자를 그린다
		
		// [ String(byte[] bytes, int offset, int length) ]
		byte b3[] = {97, 98, 99, 100, 101, 102, 103, 104};
		String str4 = new String(b3, 2, 4);  // b3의 index 2번째부터 4개를 뽑아서 str4를 만듦
		System.out.println("str4 : " + str4);   //str4 : cdef
		
		// [ String(char[] values) ]
//		char c[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		char c[] = {'안', '녕', '하', '세', '요', '.'};
		String str5 = new String(c);
		System.out.println("str5 : " + str5); //str5 : abcdef
		
		// [ String(char[] valuse, int offset, int count) ]
		String str6 = new String(c, 2, 4);
		System.out.println("str6 : " + str6); //str6 : cdef
	}

}
