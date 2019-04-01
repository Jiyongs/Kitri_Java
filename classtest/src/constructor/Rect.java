package constructor;

/*
1. 가로 width, 세로 height
2. 넓이 : calcArea()
   둘레 : calcRound()
*/

public class Rect {
	int width;
	int height;

// [생성자]
	// 디폴트 생성자
	public Rect(){
		this(4,3);
	}
	//사용자 정의 생성자
	public Rect(int width, int height){
		this.width = width;
		this.height = height;
	}

// [메소드]
	//넓이 구하기
	public int calcArea(){
		return width * height;
	}
	//둘레 구하기
	public int calcRound() {
		return width*2 + height*2;
	}

	//정보 출력하기
	public void info(){
		System.out.println("가로가 " + width + "이고 세로가 " + height + "인 사각형의 넓이는 " + calcArea() + "이고 둘레는 " + calcRound() + "입니다.");
	}
}
