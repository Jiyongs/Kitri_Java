import java.awt.*;
import java.awt.event.*;

public class AbstractTest3 extends Frame {

	Button b1 = new Button("@눌러봐@");
	Button b2 = new Button("@눌러봐@");
	Button b3 = new Button("@눌러봐@");

	Checkbox ch = new Checkbox("선택");

	public AbstractTest3(){
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

		// 4. 자신의 생성자를 이용
		// 의미상의 추상메소드의 객체 생성 시, 해당 클래스의 메소드 중 하나 이상을 override하면 됨!
		// = 동적 객체 생성
		WindowAdapter w1 = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowIconified(WindowEvent e) {
				System.out.println("아이콘화!!!");
			}
		};
		addWindowListener(w1);
	}

	public static void main(String[] args) {
		AbstractTest3 iat = new AbstractTest3();
	}
}