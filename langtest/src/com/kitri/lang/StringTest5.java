package com.kitri.lang;

public class StringTest5 {

	public static void main(String[] args) {
		
		// [indexOf / lastIndexOf]
		String str = "hello java !!!";
		int x = str.indexOf('a'); //x=a의 처음 위치
		System.out.println(str + "에서 a는 "+ (x+1) + "번째 있다.");
		x = str.indexOf('a', 8);  //x=8번째 이후에 있는 a의 위치
		System.out.println(str + "에서 8번째부터 a는 " + (x+1) + "번째 있다.");
		x = str.indexOf("java");  //x = java의 시작점
		System.out.println(str + "에서 java는 " + (x+1) + "번째 있다.");
		
		x = str.lastIndexOf('a');  //x = a의 마지막 위치
		System.out.println(str + "에서 끝에서 부터 a는 " + (x+1) + "번째 있다.");
		
		// [isEmpty]
		String str2 = "";
		System.out.println("str2 의 길이 : " + str2.length());
		if(str2.isEmpty())
			System.out.println("빈 문자열이다.");
		else
			System.out.println("str2 = " + str2);
		
		// [trim]
		String str3 = "  hello     ";
		System.out.println(str3 + "의 길이 : " + str3.length());
		System.out.println(str3 + "의 공백 제거 후 길이 : " + str3.trim().length());

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
		System.out.println(str5.substring(6, 9));  //6번째부터 9전까지
		
		// [숫자 -> 문자열]
		// 1) 숫자 + 문자열
		// 2) string클래스의 valueOf()
		// 3) Integer클래스의 toString()
		int num = 100;
		String sn1 = num + "";
		System.out.println(sn1 + 100);
		String sn2 = String.valueOf(num);
		System.out.println(sn2 + 100);
		String sn3 = Integer.toString(num);
		System.out.println(sn3 + 100);
		
		// [문자열 -> 숫자]
		// 1) Integer클래스의 parseInt()
		String ns = "100";
		num = Integer.parseInt(ns);
		System.out.println(num + 100);
		
	}

}
