import java.awt.*;
import java.awt.event.*;

public class AbstractTest3 extends Frame {

	Button b1 = new Button("@������@");
	Button b2 = new Button("@������@");
	Button b3 = new Button("@������@");

	Checkbox ch = new Checkbox("����");

	public AbstractTest3(){
		// <Frame(���� Ŭ����)�� ������ ȣ��>
		super("Is A Test");

		// <Frame(���� Ŭ����)�� ��� �׳� ��� ����>
		// ��� this. �� �����Ǿ� ����
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

		// 4. �ڽ��� �����ڸ� �̿�
		// �ǹ̻��� �߻�޼ҵ��� ��ü ���� ��, �ش� Ŭ������ �޼ҵ� �� �ϳ� �̻��� override�ϸ� ��!
		// = ���� ��ü ����
		WindowAdapter w1 = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowIconified(WindowEvent e) {
				System.out.println("������ȭ!!!");
			}
		};
		addWindowListener(w1);
	}

	public static void main(String[] args) {
		AbstractTest3 iat = new AbstractTest3();
	}
}