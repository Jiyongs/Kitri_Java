package com.kitri.lang;

public class StringBufferTest1 {

	public static void main(String[] args) {
		
		//[capacity()] : 문자열버퍼 크기
		StringBuffer sb1 = new StringBuffer("hello ");
		System.out.println("1. sb1 = " + sb1);
		int cap = sb1.capacity();
		System.out.println("초기 크기 : " + cap); //초기 크기 : 22 (16+6)
		
		//[length()] : 버퍼에 담긴 문자열 크기
		System.out.println("문자열 수 : " + sb1.length()); //문자열 수 : 6
		
		//CharSequence 는 interface
		//-> 객체 생성 불가
		//->String
		
		//[append()] : 문자열버퍼 + 문자열
		// *String과는 다르게, StringBuffer는 기존 문자열 자체를 변형시킬 수 있음
		// *String의 concat()은 임시 변형, StringBuffer의 append()는 원본 변형
		sb1.append("java");
		cap = sb1.capacity();
		System.out.println("2. sb1 = " + sb1);  //sb1 = "hello java"
		System.out.println("크기 : " + cap + "\t문자열 수 : " + sb1.length()); //크기 : 22, 문자열 수 : 10

		sb1.append(" !!!!!!!!!!!!");
		cap = sb1.capacity();
		System.out.println("3. sb1 = " + sb1);  //sb1 = "hello java !!!!!!!!!!!!"
		System.out.println("크기 : " + cap + "\t문자열 수 : " + sb1.length()); //크기 : 46, 문자열 수 : 23
																							 // 기존 크기<문자열 수가 되면, 자동으로 크기를 두 배 늘림
		//[insert()] : 특정 위치에 문자열을 삽입
		sb1.insert(10, "@@@");
		System.out.println("4. sb1 = " + sb1);  //sb1 = "hello java@@@ !!!!!!!!!!!!"

		//[delete()] : 특정 범위의 문자열을 지움
		sb1.delete(10, 12);  //10번째부터 12번째 전까지의 문자열을 지움
		System.out.println("5. sb1 = " + sb1);  //sb1 = "hello java@ !!!!!!!!!!!!"
		
		//[deleteCharAt()] : 특정 위치의 문자를 지움
		sb1.deleteCharAt(10); //10번째 문자 하나만 지움
		System.out.println("6. sb1 = " + sb1);  //sb1 = "hello java !!!!!!!!!!!!"
		
		//[replace()] : 특정 범위의 문자열을 새 문자열로 대체
		sb1.replace(6, 10, "자바");
		System.out.println("7. sb1 = " + sb1);  //sb1 = "hello 자바 !!!!!!!!!!!!"
		
		//[reverse()] : 버퍼 안의 문자열 순서를 거꾸로 뒤집어줌
		// *String의 reverse()와 다르게 영어, 한글 모두 가능
		sb1.reverse()	;
		System.out.println("8. sb1 = " + sb1);  //sb1 = "!!!!!!!!!!!! 바자 olleh"
		sb1.reverse();
		
		//[setCharAt()] : 특정 위치의 문자를 지정 문자로 변경
		sb1.setCharAt(9, '@');
		System.out.println("9. sb1 = " + sb1);  //sb1 = "hello 자바 @!!!!!!!!!!!"
		
		// <String 객체 안에, StringBuffer안의 문자열을 저장하는 법
		// 1) 인자로 StringBuffer 객체를 가짐 String 생성자를 생성
		String s1 = new String(sb1);
		// 2) StringBuffer 객체를 toString()을 이용하여 String으로 변형하여 저장
		String s2 = sb1.toString();
		
		System.out.println();
		
		///////////////////////////////////////// 예제 ////////////////////////////////////////
		//str에 findStr이 있는지의 여부에 따라, 다르게 출력하라.
		
		String str = "hello 자바 !!!";
		String findStr = "자바";
//		String findStr = "오라클";
		String replaceStr = "java";
		
		//findStr이 있는 경우에만 StringBuffer를 만들게 함! (메모리 절약)
		int start = str.indexOf(findStr); // 시작점 //-1이면 findStr이 없는 것, -1 이상이면 findStr이 있는 것
		if(start != -1) { //findStr이 있다면
			StringBuffer sb = new StringBuffer(str);
			int end = start + findStr.length(); //끝나는 점
			sb.replace(start, end, replaceStr);
			System.out.println(sb);
		} else
			System.out.println(findStr + "은 없습니다.");
			
	}
}
