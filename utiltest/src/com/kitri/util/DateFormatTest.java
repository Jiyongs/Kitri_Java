package com.kitri.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatTest {
	
	public static void main(String[] args) {
		// 2019.03.26 14:25:30 뿌리기
		
		// [java.text 패키지] - [Format 클래스] - [DateFormat 클래스] - [SimpleDateFormat 클래스]
		
		Date date = new Date();
		System.out.println(date);
		
		Format f = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss"); //시간 포맷 지정 (아직 실제 날짜는 없음)
		String today = f.format(date);
		System.out.println(today);
		
	}

}
