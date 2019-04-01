package com.kitri.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarTest {

	public static void main(String[] args) {
		
		// [Calendar class]
		// *��¥ ������ �� ���� ��, get() ���
		// '2019�� 03�� 26�� ���� 1�� 17�� 35��' ���
		
		// Calendar ��ü ���� : 1) ���� Ŭ���� ��ü ����
		//Calendar cal = new GregorianCalendar();
		
		// Calendar ��ü ���� : 2) �ڽ��� ��ü �����ϴ� static �޼ҵ� �̿�
		Calendar cal = Calendar.getInstance();
		
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH + 1);
		int d = cal.get(Calendar.DATE);
		int apm = cal.get(Calendar.AM_PM);
		int h = cal.get(Calendar.HOUR);
		int mi = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		
		
		System.out.println(y+ "�� " + zeroPlus(m) + "�� " + zeroPlus(d) + "�� " +
				zeroPlus(h) + "�� " + zeroPlus(mi) + "�� " + zeroPlus(s) + "��");
		
		// [Date class]
		Date date = new Date();
		System.out.println(date.toString());
		
		
	}
	
	// *static �޼ҵ� ��� ������ ��� : �޼ҵ� ȣ�� ����� ���� ���������� ���� ���ϴ°�? (-> ������ ������ ����)
	// 0�� ���̱� ���� �޼ҵ�  ... 03�� 06�� ��
	private static String zeroPlus(int num) {
		return num < 10 ? "0" + num : Integer.toString(num);
	}

}
