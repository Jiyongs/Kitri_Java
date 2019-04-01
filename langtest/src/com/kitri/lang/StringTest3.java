package com.kitri.lang;

public class StringTest3 {

	public static void main(String[] args) {
		String str = "Hello Java !!!";
		char c = str.charAt(4);
		System.out.println("c = " + c);
		
		//char -> int 자동형 변환 시, ascii code로 변환됨
		//문자는 0-9까지밖에 없음
		
		// [charAt]
		//str이 숫자인지의 여부를 출력하기
		str = "1a3";
		int len = str.length();
		System.out.println("length == " + len);
		
		String result ="은 숫자이다.";
		
		for(int i = 0; i < len; i++) {
			int x = str.charAt(i) - 48;  //x는 아스키 코드
			if(x < 0 || x > 9) {
				result = "은 숫자가 아니다.";
				break;
			}
		}
		
		System.out.println(str + result);
		
		// [concat]
		String str1 = "hello";
		String str2 = "java";
		System.out.println(str1 + str2);         //str1, str2에는 영향 X
		System.out.println(str1.concat(str2));  //str1, str2에는 영향 X
		
		// [startsWith]
		str = "hello java !!!";
		if(str.startsWith("h")) {  //만약 H면 false (java는 대소문자 구분)
			System.out.println(str + "은 h로 시작한다.");
		}
		if(str.endsWith("!!")) {  //만약 H면 false (java는 대소문자 구분)
			System.out.println(str + "은 !!로 끝난다.");
		}
		
		// [toUpperCase / toLowerCase]
		String s1 = "java";
		String s2 = "JavA";
		System.out.println("s1.toUpperCase() == " + s1.toUpperCase());
		System.out.println("s1.toLowerCase() == " + s1.toLowerCase());
		
		// [equals]
		if(s1.equals(s2))
			System.out.println(s1 + "과 " + s2 + "는 같은 문자열이다.");
		else
			System.out.println(s1 + "과 " + s2 + "는 다른 문자열이다.");

		if(s1.toUpperCase().equals(s2.toUpperCase()))
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 같은 문자열이다.");
		else
			System.out.println(s1 + "과 " + s2 + "는 다른 문자열이다.");
		
		// [equalsIgnoreCase]
		if(s1.equalsIgnoreCase(s2))
			System.out.println(s1 + "과 " + s2 + "는 대소문자 구분없이 같은 문자열이다.");
		else
			System.out.println(s1 + "과 " + s2 + "는 다른 문자열이다.");
		
	}
	
	

}
