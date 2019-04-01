public class CarUser {
	public static void main(String[] args) {
		Car car1;   // JAVA의 NULL = 아직 메모리에 올리지 않은 값(=주소값이 없다) //car1 = null한 이유?
		car1 = new Car();

		Car car2;
		car2 = new Car();

		//Car의 carName, color, maker는 전역변수로, 자동으로 null로 초기화되어 있다
		System.out.println("1. 차이름 : " + car1 .carName + " 색상 : " + car1.color + " 제조사 : " + car1.maker);

		car1.carName = "쏘나타";
		car1.color = "검정색";
		car1.maker = "현대";

		System.out.println("1. 차이름 : " + car1.carName + " 색상 : " + car1.color + " 제조사 : " + car1.maker);

		car2.carName = "k5";
		car2.color = "흰색";
		car2.maker = "기아";
		System.out.println("2. 차이름 : " + car2.carName + " 색상 : " + car2.color + " 제조사 : " + car2.maker);

		//car1과 car2의 주소값 출력
		System.out.println("car1 : " + car1);
		System.out.println("car2 : " + car2);

		// 메소드 호출
		System.out.println("최초 " + car1.carName + "의 속도 : " + car1.speed);
		System.out.println("car1의 속도를 2회 증가!!!");
		car1.speedUp();
		car1.speedUp();
		System.out.println("2회 증가 후 " + car1.carName + "의 속도 : " + car1.speed);

		// 메소드 호출 (for문 이용)
		System.out.println("car1의 속도를 8회 증가!!!");
		for(int i = 0; i<8; i++){
			car1.speedUp();
		}
		System.out.println("8회 증가 후 " + car1.carName + "의 속도 : " + car1.speed);

		System.out.println("car1의 속도를 4회 감소!!!");
		for(int i =0; i<4; i++){
			car1.speedDown();
		}
		System.out.println("4회 감소 후 " + car1.carName + "의 속도 : " + car1.speed);

		System.out.println("car1의 속도를 10회 감소!!!");
		for(int i =0; i<10; i++){
			car1.speedDown();
		}
		System.out.println("10회 감소 후 " + car1.carName + "의 속도 : " + car1.speed);


		//java 특징 . 플랫폼 독립이다 (wora / write ones runs anywhere)
		//              = java 코드는 모든 OS에서 실행됨
		//              -> jvm (java virtual machine)이 모든 os에서 실행가능하게 해줌 (우리는 window용 jvm을 깔았다)

		// jvm (자바 가상 머신)
		// jvm의 메모리 영역의 구분
		// 1) static 
		// 2) heep : 동적 메모리 할당 공간 / new를 이용하여 객체 생성되는 공간
		// 3) stack : 변수명, 객체명이 할당되는 공간

		//**참고**
		//java에서는 포인터 기능을 jvm이 알아서 해줌
		//java에서는 소멸자 기능도 jvm이 해줌 (garbage 수집소가 있어서 소멸자 따로 정의 안해도됨 / c랑 달리)
	}
}
