package com.kitri.util.jcf;

public class SonataArrayTest {
	public static void main(String[] args) {
		System.out.println("========================= Sonata 생산 시작 =========================");
		Car car1 = new Sonata("흰색", 5000, "NF", "승용");
		Car car2 = new Sonata("은색", 7000, "Brilliant", "업무");
		Car car3 = new Sonata("감홍색", 4000, "EF", "택시");
		Car car4 = new Sonata("검정색", 6000, "Hybrid", "승용");
	
		Car[] carArray = new Car[4];
		carArray[0] = car1;
		carArray[1] = car2;
		carArray[2] = car3;
		carArray[3] = car4;
		
		int len = carArray.length;
		for (int i = 0; i < len; i++) {
			System.out.println(carArray[i]);
		}
		
	}
}
