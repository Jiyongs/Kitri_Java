package com.kitri.util;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		
		// [Random Ŭ����]
		Random random = new Random();
		boolean b = random.nextBoolean();
		System.out.println(b);
		
		double d = random.nextDouble();
		System.out.println(d);
		
		int i = random.nextInt();
		System.out.println(i);
		
		int r = random.nextInt(256); //0~255������ ���� �߻�
		System.out.println(r);
	}
	
}
