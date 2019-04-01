import java.awt.*;
import java.awt.event.*;

public class InterfaceTest extends Frame implements WindowListener, ActionListener{
// 1. 다중 implements 가능하다

	Button b1 = new Button("@눌러봐@");

	public InterfaceTest(){
		// <Frame(상위 클래스)의 생성자 호출>
		super("InterfaceTest");

		// <Frame(상위 클래스)의 요소 그냥 사용 가능>
		// 모두 this. 가 생략되어 있음
		setLayout(new FlowLayout());  
		setSize(400, 300);
		setBackground(new Color(255, 210, 210));
		setLocation(300, 200);
		setVisible(true);  //창이 뜸

		add(b1);
		b1.setBackground(new Color(210, 210, 210));

		
		//addWindowListener(w1);  // Listener(감시자)를 등록해야, 각 행동에 맞는 메소드 호출 가능 /  w1 = windowListener 객체

		//WindowListener w1 = new InterfaceTest();  //Interface() 계속 호출
		//addWindowListener(w1); // 새 창 계속 호출
		addWindowListener(this);  //addWindowListener : 프레임 감시자 / this = 감시할 객체를 이 클래스에 만들었다
		b1.addActionListener(this); //addWindowListener : 버튼 감시자

	}

// 2. implements한 interface의 모든 추상메소드를 override해야 한다.

	//WindowListener를 implements하기 위해, 모든 추상메소드를 override함.
	public void windowDeactivated(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) { System.exit(0);}


	//addActionListener를 implements하기 위해, 모든 추상메소드를 override함.
	public void actionPerformed(ActionEvent e) {
		int r = (int) (Math.random() * 256);   //0~255
		int g = (int) (Math.random() * 256);
		int v = (int) (Math.random() * 256);
		setBackground(new Color(r, g, v));
	}

	public static void main(String[] args) throws Exception {
		InterfaceTest it = new InterfaceTest();
	}

}