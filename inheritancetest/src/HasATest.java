import java.awt.*;

// Frame 클래스의 객체를 가진 클래스 (HasATest ⊃ Frame 객체)
// Frame 객체를 통해 요소에 접근하여 사용
public class HasATest {

	Frame f = new Frame("Has A Test!!!");
	Button b = new Button("@눌러봐@");

	public HasATest(){
		//f.setTitle("Has A Test!!!");
		f.setLayout(new FlowLayout());
		//b.setLabel("눌러봐!!!");
		f.add(b);
		f.setSize(400, 300);
		f.setLocation(300, 200);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		HasATest hat = new HasATest();
	}
}
