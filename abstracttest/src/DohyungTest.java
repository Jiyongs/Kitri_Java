public class DohyungTest {
	public static void main(String[] args) {
		Rect r1 = new Rect(4,5);
		System.out.println("가로가 " + r1.width + "이고 세로가 " + r1.height +
			"인 사각형의 넓이는 " + r1.getArea() + "이고 둘레는 " + r1.getRound() + "입니다.");

		Circle c1 = new Circle(4);
		System.out.println("반지름이 " + c1.radius + "인 원의 넓이는 " +
			c1.getArea() + "이고 둘레는 " + c1.getRound() + "입니다.");

		//Dohyung d = new Dohyung();
		Dohyung d1 = new Rect(4, 3);  //d1은 하위클래스 Rect()를 참조했지만, 사용 가능한 것은 Rect가 Dohyung을 override한 메소드 뿐임.
		System.out.println("사각형의 넓이는 " + d1.getArea() + "이고 둘레는 " + d1.getRound() + "입니다.");

		Rect r2 = (Rect) d1;  //r2는 Rect(4, 3)의 주소를 가리킴. //r2의 자료형은 Rect이기 때문에, r2가 참조하는 Rect()의 필드, 메소드를 사용 가능함.

		Circle c2 = (Circle) d1; //d1 생성 시, Circle()은 생성하지 않음. 따라서 형변환 되지만(컴파일 가능), Circle()의 필드, 메소드를 사용 불가(실행 불가) 

	}
}
