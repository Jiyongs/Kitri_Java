import java.awt.*;

// Frame 클래스를 상속받은 관계 (IsATest = Frame)
// Frame의 요소를 그냥 사용 가능
public class IsATest extends Frame {

	Button b1 = new Button("@눌러봐@");
	Button b2 = new Button("@눌러봐@");
	Button b3 = new Button("@눌러봐@");

	Checkbox ch = new Checkbox("선택");

	public IsATest(){
		// <Frame(상위 클래스)의 생성자 호출>
		super("Is A Test");

		// <Frame(상위 클래스)의 요소 그냥 사용 가능>
		// 모두 this. 가 생략되어 있음
		setLayout(new FlowLayout());  
		setSize(400, 300);
		setBackground(new Color(255, 210, 210));
		setLocation(300, 200);
		setVisible(true);

		add(b1);
		add(b2);
		add(b3);
		b1.setBackground(new Color(210, 210, 210));

		add(ch);
		ch.setBackground(new Color(111, 123, 211));
	}

	public static void main(String[] args) {
		IsATest iat = new IsATest();
	}
}

// [java에서 객체 생성 방법]
// 1. new 연산자 사용
// 2.
// 3.
// 4.


// [추상 클래스]
// - 객체 생성 불가한 클래스
//   -> 클래스가 가진 static이 있는 메소드로 접근 가능
//   -> static이 없다면, 

// ***스타 크래프트
//level1 ) Unit 클래스 - 체력, 공격
//level2 ) Unit 클래스 상속 받는 클래스 : 지상 Unit / 공중 Unit
//level3 ) 지상 Unit 클래스 상속 받는 클래스 : 프로토스(외계인), 저그(괴물), ...
//          공중 Unit 클래스 상속 받는 클래스 : 테란(사람), 마린(군인), ...
