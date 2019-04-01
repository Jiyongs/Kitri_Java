import java.awt.*;
import java.awt.event.*;

public class InterfaceTest extends Frame implements WindowListener, ActionListener{
// 1. ���� implements �����ϴ�

	Button b1 = new Button("@������@");

	public InterfaceTest(){
		// <Frame(���� Ŭ����)�� ������ ȣ��>
		super("InterfaceTest");

		// <Frame(���� Ŭ����)�� ��� �׳� ��� ����>
		// ��� this. �� �����Ǿ� ����
		setLayout(new FlowLayout());  
		setSize(400, 300);
		setBackground(new Color(255, 210, 210));
		setLocation(300, 200);
		setVisible(true);  //â�� ��

		add(b1);
		b1.setBackground(new Color(210, 210, 210));

		
		//addWindowListener(w1);  // Listener(������)�� ����ؾ�, �� �ൿ�� �´� �޼ҵ� ȣ�� ���� /  w1 = windowListener ��ü

		//WindowListener w1 = new InterfaceTest();  //Interface() ��� ȣ��
		//addWindowListener(w1); // �� â ��� ȣ��
		addWindowListener(this);  //addWindowListener : ������ ������ / this = ������ ��ü�� �� Ŭ������ �������
		b1.addActionListener(this); //addWindowListener : ��ư ������

	}

// 2. implements�� interface�� ��� �߻�޼ҵ带 override�ؾ� �Ѵ�.

	//WindowListener�� implements�ϱ� ����, ��� �߻�޼ҵ带 override��.
	public void windowDeactivated(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent e) { System.exit(0);}


	//addActionListener�� implements�ϱ� ����, ��� �߻�޼ҵ带 override��.
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