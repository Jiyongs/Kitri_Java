package com.kitri.array;

public class ArrayTest1 {

	public static void main(String[] args) {

		int x1 = 10;
		int x2 = 20;
		int x3 = 30;
		
		System.out.println("x1=" + x1 + "\tx2=" + x2 + "\tx3=" + x3 );

		int x[];
		x = new int[3];
		x[0] = 10;
		x[1] = 20;
		x[2] = 30;
		
		System.out.println("x[0]=" + x[0] + "\tx[1]=" + x[1] + "\tx[2]=" + x[2] );

		printArray(x);
	}

	//배열의 값 출력 메소드
	static public void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print("x[" + i + "]=" + a[i] + "\t");
		}
	}
		
}
