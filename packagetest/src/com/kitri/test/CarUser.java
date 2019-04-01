package com.kitri.test;

import com.kitri.car.Car;

public class CarUser {

	public static void main(String[] args) {
		Car car = new Car("쏘나타", "검정색", "현대");
		System.out.println("이름 : "+car.getName());
		System.out.println("색상 : "+car.getColor());
		System.out.println("제조사 : "+car.getMaker());
		
		car.setColor("흰색");
		System.out.println("색상 : "+car.getColor());
		
		System.out.println(car); // car가 가진 toString()이 호출됨 (return 주소값)
		
		}

}
