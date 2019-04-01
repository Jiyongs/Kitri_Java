package com.kitri.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {

	public static void main(String[] args) {
		
		// [Calendar class]
		// *날짜 각각의 값 얻을 때, get() 사용
		// '2019년 03월 26일 오후 1시 17분 35초' 출력
		
		// Calendar 객체 생성 : 1) 하위 클래스 객체 참조
		//Calendar cal = new GregorianCalendar();
		
		// Calendar 객체 생성 : 2) 자신의 객체 리턴하는 static 메소드 이용
		Calendar cal = Calendar.getInstance();
		
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH + 1);
		int d = cal.get(Calendar.DATE);
		int apm = cal.get(Calendar.AM_PM);
		int h = cal.get(Calendar.HOUR);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		
		
		System.out.println(y+ "년 " + zeroPlus(m) + "월 " + zeroPlus(d) + "일 " +
				zeroPlus(h) + "시 " + zeroPlus(mi) + "분 " + zeroPlus(s) + "초");
		
		// [Date class]
		Date date = new Date();
		System.out.println(date.toString());
		
		
	}
	
	// *static 메소드 사용 가능한 경우 : 메소드 호출 결과에 따라 전역변수의 값이 변하는가? (-> 변하지 않으면 가능)
	// 0을 붙이기 위한 메소드  ... 03월 06분 등
	private static String zeroPlus(int num) {
		return num < 10 ? "0" + num : Integer.toString(num);
	}

}
