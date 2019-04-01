package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class StringTokenizerTest {
	
	public static void main(String[] args) {
		
		// [StringTokenizer Ŭ����]
		String str = "hello java !!!";
		StringTokenizer st1 = new StringTokenizer(str); //str�� �ڸ� �غ� ����
		//StringTokenizer st2 = new StringTokenizer(str, "j");
		// *StringTokenizer() ���� ��, ���ڿ��� �����ϸ� default�� ������ �߽����� �ڸ�
		//                                   ���ص� �����ϸ� ������ �߽����� �ڸ�
		
		// [countTokens()]
		int cnt = st1.countTokens();
		System.out.println("st1�� ��ū �� : " + cnt); //��ū �� : 3 (���� ����)
		//cnt = st2.countTokens();
		//System.out.println("st2�� ��ū �� : " + cnt); //��ū �� : 2 ("j" ����)
		
		// [hasMoreTokens()]
		// [nextToken()]
		while(st1.hasMoreTokens()) {
			System.out.println(st1.nextToken()); //���� ���� ��ū 3���� �� �ٿ� ���! (3��)
		}
		
		// *�������� : Ŭ���̾�Ʈ�� ������ ��� �Ծ� (���)
		//               �ۼ����ϴ� ������ ����� ����ϴ� ��ȣ
		// |�� �����ڷ� �ϴ� �������� �����غ���
		str = "TO|�����ڸ�|�ȳ��ϼ��� ���� ���ؿ�?";
		
		StringTokenizer st2 = new StringTokenizer(str, "|");
		String protocol = st2.nextToken();
		String to = st2.nextToken();
		String msg = st2.nextToken();
		System.out.println("��� : " + protocol);
		System.out.println("�������� : " + to);
		System.out.println("������ �޼��� : " + msg);
		
		// [UUID.randomUUID()]
		System.out.println(UUID.randomUUID());
	
	}
	
}
