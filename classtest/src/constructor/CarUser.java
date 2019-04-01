package constructor;

public class CarUser {
	public static void main(String[] args) {
		
		Car car1 = new Car();
		System.out.println(car1.info());

		Car car2 = new Car("흰색");
		System.out.println(car2.info());

		Car car3 = new Car("아반떼", "회색");
		System.out.println(car3.info());

		Car car4 = new Car("k5", "은색", "기아");
		System.out.println(car4.info());

		System.out.println("car4의 속도를 3회 증가!!!");
		for(int i = 0; i<3; i++){
			car4.speedUp();
		}
		System.out.println("car4 속도 : " + car4.speed);

		System.out.println("car4의 속도를 85 증가!!!");
		int speed = car4.speedUp(85);
		System.out.println("car4 속도 : " + speed);
	}
}

//클래스 : 마린
//속성 : 체력
//특징 : 스팀팩(각성제, 핫식스) - 총알 속도 증가 ... 패널티 : 스팀팩 적용할 때 체력이 한 번 깎임
                                                            // 스팀팩 사용에 필요한 체력 이하면, 사용 못 함!
//메소드 : 공격(), 모드변경()