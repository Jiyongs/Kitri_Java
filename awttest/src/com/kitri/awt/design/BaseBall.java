package com.kitri.awt.design;

import java.awt.*;

public class BaseBall extends Frame {

	Panel pE = new Panel();
	Panel pS = new Panel();

	TextArea ta = new TextArea();

	Button newG = new Button("������");
	Button clear = new Button("�����");
	Button dop = new Button("�� ��");
	Button fontC = new Button("���ڻ�");
	Button exit = new Button("����");

	Label l = new Label("����",  Label.CENTER);
	TextField tf = new TextField();
	
	Label ls = new Label();

	public BaseBall() {
		// <������ �г�>
		pE.setLayout(new GridLayout(5, 1, 10, 10));
		pE.add(newG);
		pE.add(clear);
		pE.add(dop);
		pE.add(fontC);
		pE.add(exit);

		// <�Ʒ� �г�>
		pS.setLayout(new BorderLayout(10, 10));
		pS.add(l, "West");
		pS.add(tf, "Center");
		pS.add(ls, "East");

		// <������>
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(10, 10));
		add(ta, "Center");
		add(pE, "East");
		add(pS, "South");

		///////////////////////////// �޸𸮻��� Frame ��ġ �Ϸ�//////////////////////////

		setBounds(300, 200, 500, 400); // setBounds(int x, int y, int width, int height) : ��ġ, ũ�� �� �濡 ����
		setVisible(true); // ��ġ �Ϸ�� Frame�� ���̰� �ϱ� ***�׻� ��ġ���� ������

	}

	public static void main(String[] args) {
		new BaseBall();
	}

}
