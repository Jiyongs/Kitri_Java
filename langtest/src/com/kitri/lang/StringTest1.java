package com.kitri.lang;

public class StringTest1 {
	
	public static void main(String[] args) {
		
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		String s4 = new String("java");
		
		if(s1 == s2)
			System.out.println("s1 s2는 주소값이 같다"); //O
		if(s1 == s3)
			System.out.println("s1 s3는 같다"); //X
		if(s1 == s4)
			System.out.println("s1 s4는 같다"); //X
		if(s2 == s3)
			System.out.println("s2 s3는 같다"); //X
		if(s2 == s4)
			System.out.println("s2 s4는 같다"); //X
		if(s3 == s4)
			System.out.println("s3 s4는 같다"); //X
		
		System.out.println("-----------------------------------------");
		
		if(s1.equals(s2))
			System.out.println("s1 s2는 주소값이 같다"); //O
		if(s1.equals(s3))
			System.out.println("s1 s3는 같다"); //O
		if(s1.equals(s4))
			System.out.println("s1 s4는 같다"); //O
		if(s2.equals(s3))
			System.out.println("s2 s3는 같다"); //O
		if(s2.equals(s4))
			System.out.println("s2 s4는 같다"); //O
		if(s3.equals(s4))
			System.out.println("s3 s4는 같다"); //O
		
		//String class에서 equals() 를 오버라이드
		// : String 객체의 문자열값을 비교하게끔 오버라이드했음

	}
	
}
