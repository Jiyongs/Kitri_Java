package com.kitri.awt.design;

import java.awt.*;

// 1. Frame ���
// 2. ����ο� �ʿ��� ��ü ����.
// 3. ��ġ��(������)���� design (=component ��ġ)

// *** �׻� �۾��� �� >> �� ������ ��������

public class DesignTest extends Frame {
	
//[�����] : �ʿ��� ��ü ����
	Panel pN = new Panel();  				// Panel : �Ϲ������� ����ο���, Panel() �����! (��ġ�ο��� Layout ����)
	Panel pS = new Panel();
	
	Label l = new Label("�Է�", Label.CENTER); 	 // Label : Label("���ڿ�"); ����� ����!
	TextField tf = new TextField();
	Button send = new Button("����"); 	//Button : Button("���ڿ�");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice(); 				//Choice : Choice() �ۿ� ����. ���� �׸��� �޼ҵ� �̿��ؾ� ��!
	Button exit = new Button("����");
 	
	
	public DesignTest() {
	//[��ġ��] : ��ü�� ��ġ
		
		// <������>
		super("Design Test !!!");              //Frame("â����") : ���� Ŭ������ Frame �����ڸ� ȣ���Ͽ�, �������� ���� ����
		
		// <���� �г�>
		//pN.setLayout(new FlowLayout());  // Panel�� ����Ʈ ���̾ƿ��� Flow�̹Ƿ�, ���� X
		
		//LayoutManager lm = new BorderLayout(); // Border���̾ƿ� ��ü�� ���� ������ �ʰ�,
		pN.setLayout(new BorderLayout(10, 0));     // �͸� ��ü�� ���� ����!  //BorderLayout(int hgap, int vgqp)
		l.setBackground(new Color(210, 230, 150)); // setBackground(Color c) : ������Ʈ�� ����� Color(double r, double g, double v)�� ����
//		l.setForeground(new Color(255, 255, 255)); // setForeground(Color c) : ������Ʈ�� ����� �պκ��� Color ��ü�� ����
		l.setForeground(Color.ORANGE); // setForeground(Color c) : ������Ʈ�� ����� �պκ��� Color ��ü�� ����
		Font f = new Font("����", Font.BOLD, 20); // Font(String name, int style, int size)
		l.setFont(f);    // setFont(Font f);
		pN.add(l, "West");
		pN.add(tf, "Center");
		pN.add(send, "East");
		
		// <�Ʒ��� �г�>
		pS.setLayout(new GridLayout(1, 2, 10, 0));   //GridLayout(int rows, int cols, int hgap, int vgap)���
		ch.add("����"); //add() : Choice�� �׸� �ֱ�
		ch.add("���");
		ch.add("��õ");
		ch.add("����");
		ch.add("��õ");
		pS.add(ch);
		pS.add(exit);
		
		// <��ü>
		//Frame�� ����Ʈ ���̾ƿ��� Border�̹Ƿ�, ���� X
		setLayout(new BorderLayout(0, 10));  //Border�� �ٸ� ������ �̿��� ���� setLayout���� //setLayout(LayoutManager lm)   //BorderLayout(int hgap, int vgap)
		add(pN, "North");
		add(ta, "Center");
		add(pS, "South");
		
		/////////////////////////////�޸𸮻��� Frame ��ġ �Ϸ�//////////////////////////
		
		setSize(300, 400); //Frame�� ũ�� ����
		setLocation(300, 200); //Frame�� ù ��ġ ����
		
		setBounds(300, 200, 300, 500); //setBounds(int x, int y, int width, int height) : ��ġ, ũ�� �� �濡 ����
		setResizable(false);  //setResizable(boolean b) : Frame�� ũ�� ���� �㰡 ���� ����
		setVisible(true);    //��ġ �Ϸ�� Frame�� ���̰� �ϱ�  ***�׻� ��ġ���� ������

	}
	
	public static void main(String[] args) {
		new DesignTest();  // ��ü ����� ���� �����Ƿ�, �͸� �����ڸ� ȣ��!
	}
	
}
