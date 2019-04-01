package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest4 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		// [getBytes] : ���ڿ��� byte�� �ɱ��� ��ȯ
		String str = "abcdef";
		byte b[] = str.getBytes();
		
		int len = b.length;
		for (int i = 0; i < len; i++) {
			System.out.println("b[" + i + "] = " + b[i]);
		}
		
		// [getBytes] : ���ڿ��� byte[]�� �ɱ��� ��ȯ
		String str2 = "�ȳ��ϼ���.";
		byte b2[] = str2.getBytes("utf-8"); //�ѱ��� 3byte�� �ɰ�
//		byte b2[] = str2.getBytes();
		
		int len2 = b2.length;
		for (int i = 0; i < len2; i++) {
			System.out.println("b2[" + i + "] = " + b2[i]); // 16���� byte�� ���� (5����*3byte + 1(.))
		}
		
		// [toCharArray] : ���ڿ��� char�� �ɰ��� char[]�� ��ȯ
		char c[] = str2.toCharArray(); //�ѱ��� char�� �ɰ�
		
		int len3 = c.length;
		for (int i = 0; i < len3; i++) {
			System.out.println("c[" + i + "] = " + c[i]); //6������ char�� ����
		}
	}

}
