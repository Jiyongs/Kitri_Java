package com.kitri.util;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		
		// [Random 클래스]
		Random random = new Random();
		boolean b = random.nextBoolean();
		System.out.println(b);
		
		double d = random.nextDouble();
		System.out.println(d);
		
		int i = random.nextInt();
		System.out.println(i);
		
		int r = random.nextInt(256); //0~255까지의 난수 발생
		System.out.println(r);
	}
	
}
