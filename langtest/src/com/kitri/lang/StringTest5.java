package com.kitri.lang;

public class StringTest5 {

	public static void main(String[] args) {
		
		// [indexOf / lastIndexOf]
		String str = "hello java !!!";
		int x = str.indexOf('a'); //x=a�� ó�� ��ġ
		System.out.println(str + "���� a�� "+ (x+1) + "��° �ִ�.");
		x = str.indexOf('a', 8);  //x=8��° ���Ŀ� �ִ� a�� ��ġ
		System.out.println(str + "���� 8��°���� a�� " + (x+1) + "��° �ִ�.");
		x = str.indexOf("java");  //x = java�� ������
		System.out.println(str + "���� java�� " + (x+1) + "��° �ִ�.");
		
		x = str.lastIndexOf('a');  //x = a�� ������ ��ġ
		System.out.println(str + "���� ������ ���� a�� " + (x+1) + "��° �ִ�.");
		
		// [isEmpty]
		String str2 = "";
		System.out.println("str2 �� ���� : " + str2.length());
		if(str2.isEmpty())
			System.out.println("�� ���ڿ��̴�.");
		else
			System.out.println("str2 = " + str2);
		
		// [trim]
		String str3 = "  hello     ";
		System.out.println(str3 + "�� ���� : " + str3.length());
		System.out.println(str3 + "�� ���� ���� �� ���� : " + str3.trim().length());

		// [replace / replaceAll]
		String str4 = "jaba";
		System.out.println(str4.replace('b', 'v'));
		System.out.println(str4.replace("jaba", "java"));
		System.out.println(str4.replaceAll("jaba", "java"));
		
		// [sprit]
		String str5 = "hello java !!!";
		String s[] = str5.split(" ");
		int len = s.length;
		for (int i = 0; i < len; i++) {
			System.out.println("s[" + i + "] = " + s[i]);
		}
		
		// [substring]
		System.out.println(str5.substring(6));
		System.out.println(str5.substring(6, 9));  //6��°���� 9������
		
		// [���� -> ���ڿ�]
		// 1) ���� + ���ڿ�
		// 2) stringŬ������ valueOf()
		// 3) IntegerŬ������ toString()
		int num = 100;
		String sn1 = num + "";
		System.out.println(sn1 + 100);
		String sn2 = String.valueOf(num);
		System.out.println(sn2 + 100);
		String sn3 = Integer.toString(num);
		System.out.println(sn3 + 100);
		
		// [���ڿ� -> ����]
		// 1) IntegerŬ������ parseInt()
		String ns = "100";
		num = Integer.parseInt(ns);
		System.out.println(num + 100);
		
	}

}
