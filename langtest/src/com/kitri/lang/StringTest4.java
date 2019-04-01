package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest4 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		// [getBytes] : 문자열을 byte로 쪼깨어 반환
		String str = "abcdef";
		byte b[] = str.getBytes();
		
		int len = b.length;
		for (int i = 0; i < len; i++) {
			System.out.println("b[" + i + "] = " + b[i]);
		}
		
		// [getBytes] : 문자열을 byte[]로 쪼깨어 반환
		String str2 = "안녕하세요.";
		byte b2[] = str2.getBytes("utf-8"); //한글을 3byte씩 쪼갬
//		byte b2[] = str2.getBytes();
		
		int len2 = b2.length;
		for (int i = 0; i < len2; i++) {
			System.out.println("b2[" + i + "] = " + b2[i]); // 16개의 byte값 나열 (5글자*3byte + 1(.))
		}
		
		// [toCharArray] : 문자열을 char로 쪼개어 char[]를 반환
		char c[] = str2.toCharArray(); //한글을 char씩 쪼갬
		
		int len3 = c.length;
		for (int i = 0; i < len3; i++) {
			System.out.println("c[" + i + "] = " + c[i]); //6글자의 char깂 나열
		}
	}

}
