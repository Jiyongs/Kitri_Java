import java.awt.*;

// Frame Ŭ������ ��ӹ��� ���� (IsATest = Frame)
// Frame�� ��Ҹ� �׳� ��� ����
public class IsATest extends Frame {

	Button b1 = new Button("@������@");
	Button b2 = new Button("@������@");
	Button b3 = new Button("@������@");

	Checkbox ch = new Checkbox("����");

	public IsATest(){
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
	}

	public static void main(String[] args) {
		IsATest iat = new IsATest();
	}
}

// [java���� ��ü ���� ���]
// 1. new ������ ���
// 2.
// 3.
// 4.


// [�߻� Ŭ����]
// - ��ü ���� �Ұ��� Ŭ����
//   -> Ŭ������ ���� static�� �ִ� �޼ҵ�� ���� ����
//   -> static�� ���ٸ�, 

// ***��Ÿ ũ����Ʈ
//level1 ) Unit Ŭ���� - ü��, ����
//level2 ) Unit Ŭ���� ��� �޴� Ŭ���� : ���� Unit / ���� Unit
//level3 ) ���� Unit Ŭ���� ��� �޴� Ŭ���� : �����佺(�ܰ���), ����(����), ...
//          ���� Unit Ŭ���� ��� �޴� Ŭ���� : �׶�(���), ����(����), ...
