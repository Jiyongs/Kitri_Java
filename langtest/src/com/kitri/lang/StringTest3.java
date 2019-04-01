package com.kitri.lang;

public class StringTest3 {

	public static void main(String[] args) {
		String str = "Hello Java !!!";
		char c = str.charAt(4);
		System.out.println("c = " + c);
		
		//char -> int �ڵ��� ��ȯ ��, ascii code�� ��ȯ��
		//���ڴ� 0-9�����ۿ� ����
		
		// [charAt]
		//str�� ���������� ���θ� ����ϱ�
		str = "1a3";
		int len = str.length();
		System.out.println("length == " + len);
		
		String result ="�� �����̴�.";
		
		for(int i = 0; i < len; i++) {
			int x = str.charAt(i) - 48;  //x�� �ƽ�Ű �ڵ�
			if(x < 0 || x > 9) {
				result = "�� ���ڰ� �ƴϴ�.";
				break;
			}
		}
		
		System.out.println(str + result);
		
		// [concat]
		String str1 = "hello";
		String str2 = "java";
		System.out.println(str1 + str2);         //str1, str2���� ���� X
		System.out.println(str1.concat(str2));  //str1, str2���� ���� X
		
		// [startsWith]
		str = "hello java !!!";
		if(str.startsWith("h")) {  //���� H�� false (java�� ��ҹ��� ����)
			System.out.println(str + "�� h�� �����Ѵ�.");
		}
		if(str.endsWith("!!")) {  //���� H�� false (java�� ��ҹ��� ����)
			System.out.println(str + "�� !!�� ������.");
		}
		
		// [toUpperCase / toLowerCase]
		String s1 = "java";
		String s2 = "JavA";
		System.out.println("s1.toUpperCase() == " + s1.toUpperCase());
		System.out.println("s1.toLowerCase() == " + s1.toLowerCase());
		
		// [equals]
		if(s1.equals(s2))
			System.out.println(s1 + "�� " + s2 + "�� ���� ���ڿ��̴�.");
		else
			System.out.println(s1 + "�� " + s2 + "�� �ٸ� ���ڿ��̴�.");

		if(s1.toUpperCase().equals(s2.toUpperCase()))
			System.out.println(s1 + "�� " + s2 + "�� ��ҹ��� ���о��� ���� ���ڿ��̴�.");
		else
			System.out.println(s1 + "�� " + s2 + "�� �ٸ� ���ڿ��̴�.");
		
		// [equalsIgnoreCase]
		if(s1.equalsIgnoreCase(s2))
			System.out.println(s1 + "�� " + s2 + "�� ��ҹ��� ���о��� ���� ���ڿ��̴�.");
		else
			System.out.println(s1 + "�� " + s2 + "�� �ٸ� ���ڿ��̴�.");
		
	}
	
	

}
