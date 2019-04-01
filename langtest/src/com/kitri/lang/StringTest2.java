package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class StringTest2 {

	public static void main(String[] args) throws UnsupportedEncodingException {

		// NullPointer Exception error : null���� ���� ��ü�� ���� �޸𸮿� �ö󰡱� ���̱� ����
		//                                     ��ü�� �����ϴ� �ּҰ��� ���ٴ� ����
		//String str = null;  
		
		// [ String() ]
		String str1 = new String();  // = ""
		System.out.println("���ڿ� ���� : " + str1.length()); // ���ڿ� ���� : 0
		
		//byte b[] = new byte[4];      //�迭 ���� ��� 1
		//byte b[] = {97, 98, 99, 100};  //�迭 ���� ��� 2
		//String str2 = new String(b);
		//System.out.println("str2 : "+ str2);  // str2 : abcd (ASI code)
		
		// [ String(byte[] bytes) ]
		byte b[] = {-66, -56, -77, -25, -57,-49, -68, -68, -65, -28, 46};
		String str2 = new String(b);
//		String str2 = new String(b, "euc-kr"); // ����Ʈ�� euc-kr
		System.out.println("str2 : "+ str2);  // str2 : �ȳ��ϼ���. (ASCII code)
		
		byte b2[] = {-20, -107, -120, -21, -123, -107, -19, -107, -104, -20, -124, -72, -20, -102, -108, 46}; // utf-8�� �ɰ�(�� ���� ��, 3byte)
		String str3 = new String(b2, "utf-8"); // utf-8�� �ٽ� ��ħ
		System.out.println("str3 : "+ str3);  // str2 : �ȳ��ϼ���. (utf-8)
		
		// ascii code ���� �ٸ���, �� �ؿ��� �ȳ��ϼ��� �ϱ� (��û �߿�)
		// ���� �ϼ��� �ѱ� (ascii / 2byte)
		// �Ʒ��� ����, ���� ���� �ִ� �ѱ� (utf-8 / 3byte) ... ���ڸ� �׸���
		
		// [ String(byte[] bytes, int offset, int length) ]
		byte b3[] = {97, 98, 99, 100, 101, 102, 103, 104};
		String str4 = new String(b3, 2, 4);  // b3�� index 2��°���� 4���� �̾Ƽ� str4�� ����
		System.out.println("str4 : " + str4);   //str4 : cdef
		
		// [ String(char[] values) ]
//		char c[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		char c[] = {'��', '��', '��', '��', '��', '.'};
		String str5 = new String(c);
		System.out.println("str5 : " + str5); //str5 : abcdef
		
		// [ String(char[] valuse, int offset, int count) ]
		String str6 = new String(c, 2, 4);
		System.out.println("str6 : " + str6); //str6 : cdef
	}

}
