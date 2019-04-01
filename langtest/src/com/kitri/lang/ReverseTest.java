package com.kitri.lang;

import java.io.UnsupportedEncodingException;

public class ReverseTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "!!! avaJ olleH";	
		char ch = 'e';
		
		String result = "";
		
		//�ּ� 3���� ����� �̾Ƴ���
		// 1) Hello Java !!! �����
		// 2) e�� 2��° �ֽ��ϴ�.
				
		// 1. charAt()
		int len = str.length();
		for (int i = len-1; i >= 0; i--) {
			result += str.charAt(i);
		}
		System.out.println(result);

		System.out.println(ch + "�� " + (result.indexOf(ch)+1) + "��° �ֽ��ϴ�.");

		result = "";
		
		// 2. toCharArray() : ����, �ѱ�
		char c[] = str.toCharArray();
		for(int i = len-1; i>=0; i--) {
			result += c[i];
		}
		System.out.println(result);
		
		System.out.println(ch + "�� " + (result.indexOf(ch)+1) + "��° �ֽ��ϴ�.");
		
		result = "";

		
		// 3. getBytes() : ����
		byte b[] = str.getBytes();		
		byte b2[] = new byte[len];
		
		int x = 0;
		for(int i = len-1; i>=0; i--) {
			b2[x++] += b[i];
		}
		
		String result2 = new String(b2);
		System.out.println(result2);
		
		System.out.println(ch + "�� " + (result2.indexOf(ch)+1) + "��° �ֽ��ϴ�.");	
				
		//String�� ������ �� ��ü�� �ٲ� �� ����!
		//���� ���ڿ��� ������ StringBuffer(�ӽ� ���� ����)�� �̿��ؾ� ��
		StringBuffer sb = new StringBuffer(str)	;
		System.out.println(sb.reverse());
		
	}

}
