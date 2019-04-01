package com.kitri.awt.design;

import java.awt.*;

public class ListTest extends Frame {
	
	Panel pL = new Panel();
	Panel pC = new Panel();
	Panel pR = new Panel();

	List listL = new List();
	TextField tfL = new TextField();
	
	Button btR = new Button("��");
	Button btRAll = new Button("��");
	Button btL = new Button("��");
	Button btLAll = new Button("��");

	List listR = new List();
	TextField tfR = new TextField();

	public ListTest() {
		super("����Ʈ �׽�Ʈ");
		// <pL �г�>
		listL.setBackground(Color.BLACK);
		tfL.setBackground(Color.GREEN);
		pL.setLayout(new BorderLayout(0, 10));
		pL.add(listL, "Center");
		pL.add(tfL, "South");
	
		// <pC �г�>
		pC.setLayout(new GridLayout(6, 1, 0, 20));
		pC.add(new Label());
		pC.add(btR);
		pC.add(btRAll);
		pC.add(btL);
		pC.add(btLAll);
//		pC.add(new Label());  //GridLayout�� ������� ĭ�� ������Ʈ�� ��� �ڸ��� ������ �� �� ���� �����
	
		// <pR �г�>
		listR.setBackground(Color.BLACK);
		tfR.setBackground(Color.GREEN);
		pR.setLayout(new BorderLayout(0, 10));
		pR.add(listR, "Center");
		pR.add(tfR, "South");
		
		// <��ü>
		// Frame�� ����Ʈ ���̾ƿ��� Border�̹Ƿ�, ���� X
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(1, 3, 10, 0));
		add(pL);
		add(pC);
		add(pR);

		///////////////////////////// �޸𸮻��� Frame ��ġ �Ϸ�//////////////////////////
		
		setBounds(300, 200, 300, 500); // setBounds(int x, int y, int width, int height) : ��ġ, ũ�� �� �濡 ����
		setVisible(true); // ��ġ �Ϸ�� Frame�� ���̰� �ϱ� ***�׻� ��ġ���� ������
	}

	public static void main(String[] args) {
		new ListTest();
	}

}
