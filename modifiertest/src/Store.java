public class Store extends String {

	public static void main(String[] args) {
		PointCard p1 = new PointCard("박미래");
		PointCard p2 = new PointCard("황선혜");

		//1. 포인트 체크 (각자의 객체가 가진 필드값)
		System.out.println(p1.name + "님 물건 구매");
		int point = p1.visit();
		System.out.println(p1.name + "님의 포인트는 " + point + "입니다.");

		System.out.println(p2.name + "님 물건 구매");
		point = p2.visit();
		System.out.println(p2.name + "님의 포인트는 " + point + "입니다.");

		System.out.println(p2.name + "님 물건 구매");
		point = p2.visit();
		System.out.println(p2.name + "님의 포인트는 " + point + "입니다.");

		System.out.println("--------------------------------");

		//2. 방문자 수 체크 (클래스의 static 필드값)
		Guest g1 = new Guest("박미래");
		Guest g2 = new Guest("황선혜");

		System.out.println(g1.name + "님 방문");
		Guest.visit();
		System.out.println(g1.name + "님은 " + Guest.cnt + "번째 방문자입니다.");

		System.out.println(g2.name + "님 방문");
		Guest.visit();
		System.out.println(g2.name + "님은 " + Guest.cnt + "번째 방문자입니다.");

		System.out.println(g2.name + "님 방문");
		Guest.visit();
		System.out.println(g2.name + "님은 " + Guest.cnt + "번째 방문자입니다.");
		
	}

}
