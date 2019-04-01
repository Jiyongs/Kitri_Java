package constructor;

public class DohyungTest {
	public static void main(String[] args) {
		Rect r1;
		//가로가 4이고 세로가 3인 사각형의 넓이는 12이고 둘레는 14입니다.
		r1 = new Rect();
		r1.info();

		Rect r2;
		//가로가 ?이고 세로가 ?인 사각형의 넓이는 ?이고 둘레는 ?입니다.
		r2 = new Rect(5,7);
		r2.info();
		
		Circle c1;
		//반지름이 4인 원의 넓이는 50.***이고 둘레는 24.***입니다.
		c1 = new Circle();
		c1.info();

		Circle c2;
		//반지름이 ?인 원의 넓이는 ?.***이고 둘레는 ?.***입니다.
		c2 = new Circle(7);
		c2.info();

	}
}
