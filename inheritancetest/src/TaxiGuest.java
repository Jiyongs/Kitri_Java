public class TaxiGuest {
	public static void main(String[] args) {
		//Taxi의 생성자로, 상위 클래스인 Car의 디폴트 생성자 Car()를 호출함
		Taxi t1 = new Taxi();
		System.out.println("t1 >> " + t1.toString() + "    기본 요금 : " + t1.basicPrice);  //Car 클래스 ← Taxi 클래스 (상속)이라서 info() 사용 가능함

		//Taxi의 생성자로, 상위 클래스인 Car의 생성자 Car(String, String, String)를 overriding하여, 사용함
		Taxi t2 = new Taxi("k5", "감홍색", "기아");
		System.out.println("t2 >> " + t2.toString() + "    기본 요금 : " + t2.basicPrice);

		// 손님 1이 탔음
		t2.initPrice();

		// 도착함
		int km = 20;
		t2.calcPrice(km);
		System.out.println("\n" + t2 + "를 타고 구디에서 강남까지 " + km + "km이동!!!" + t2.price);
		System.out.println("요금 : " + t2.price + "원");

		// 손님이 내렸음
		t2.sumPrice();
		System.out.println("누적 수입 : " + t2.totalPrice);

		//손님 2가 탔음
		t2.initPrice();

		// 도착함
		km = 20;
		t2.calcPrice(km);
		System.out.println("\n" + t2 + "를 타고 강남에서 구디까지 " + km + "km이동!!!" + t2.price);
		System.out.println("요금 : " + t2.price + "원");
		
		// 손님이 내렸음
		t2.sumPrice();
		System.out.println("누적 수입 : " + t2.totalPrice);


		//다시 보기
		int upDown = 50;
		System.out.println("t2의 속도를 " + upDown + "만큼 가속!!!");
		int speed = t2.speedUp(upDown);

		System.out.println("t2의 속도 : " + speed + "    " + t2.speed);


		upDown = 250;
		System.out.println("t2의 속도를 " + upDown + "만큼 가속!!!");
		speed = t2.speedUp(upDown);

		System.out.println("t2의 속도 : " + speed + "    " + t2.speed);
		//

/*
		System.out.println(t1 + "       " + t2);
		System.out.println(t1.toString() + "       " + t2.toString()); //Object class의 toString() 메소드 : 문자열 리턴 함수
*/
		Taxi t3 = new Taxi("k5", "감홍색", "기아");
		System.out.println(t2 + "       " + t3);
		System.out.println(t2.hashCode() + "       " + t3.hashCode());
		if(t2==t3)  //비교연산자는 기본 DataType일 경우에 값을 비교, but 참조형 DataType일 경우는 주소값을 비교
			System.out.println("t2와 t3는 주소값이 같은 차이다.");
		else
			System.out.println("t2와 t3은 주소값이 다른 차이다.");

		if(t2.equals(t3))
			System.out.println("t2와 t3는 값이 같은 차이다.");
		else
			System.out.println("t2와 t3은 값이 다른 차이다.");


	}
}
