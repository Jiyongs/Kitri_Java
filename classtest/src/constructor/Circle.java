package constructor;

/*
1. 반지름 radius
2. 넓이 : calcArea()     - 반지름^2 * 3.14
   둘레 : calcRound()   - 2 * 반지름 * 3.14
*/
public class Circle {

	int radius;

// [생성자]
	// 디폴트 생성자
	public Circle(){
		this(4);
	}
	//사용자 정의 생성자
	public Circle(int radius){
		this.radius = radius;
	}

// [메소드]
	//넓이 구하기
	public double calcArea(){
		return Math.PI * Math.pow(radius,2);
	}
	//둘레 구하기
	public double calcRound(){
		return 2 * radius * Math.PI;
	}
	//정보 출력하기
	public void info(){
		System.out.println("반지름이 " + radius + "인 원의 넓이는 " + calcArea() + "이고 둘레는 " + calcRound() +"입니다.");
	}
}
