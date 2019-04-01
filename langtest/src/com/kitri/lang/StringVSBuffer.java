package com.kitri.lang;

public class StringVSBuffer {

	public static void main(String[] args) {
		// *대부분의 문자열 변형은, 문자열 + 문자열
		// *문자열의 결합에서, String과 StringBuffer의 차이!
		
		long st = System.nanoTime();  //현재 시간
//		String str = "hello ";
//		for (int i = 0; i < 5000; i++) {
//			str += i;
//		}
		// 500번 반복 시, String 실행 시간   : 1010966 ...
		// 5000번 반복 시, String 실행 시간  : 46120485 ...
		
		StringBuffer sb = new StringBuffer("hello ");
		for (int i = 0; i < 5000; i++) {
			sb.append(i);
		}		
		// 500번 반복 시, StringBuffer 실행 시간  : 256269 ...
		// 5000번 반복 시, StringBuffer 실행 시간 : 1035342 ...
		System.out.println(System.nanoTime() - st); //실행 시간
		
		
		// *결론 : 문자열 결합 시, StringBuffer가 더 빠르다
		//          간단한 문자열의 결합은 String, 긴 문자열의 결합은 StringBuffer를 쓰자!
		
	}

}
