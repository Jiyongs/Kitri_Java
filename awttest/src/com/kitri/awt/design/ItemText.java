package com.kitri.awt.design;

import java.awt.*;

public class ItemText extends Frame {

	Panel pN = new Panel();
	Panel pS = new Panel();
	
//	Checkbox mor = new Checkbox();
//	Checkbox aft = new Checkbox();
//	Checkbox eve = new Checkbox();
//	Checkbox app = new Checkbox();
//	Checkbox banana = new Checkbox();
//	Checkbox straw = new Checkbox();

	CheckboxGroup chg = new CheckboxGroup();
	
	TextArea ta = new TextArea();

	Choice ch = new Choice();
	Button exit = new Button("����");

	public ItemText() {
		// <���� �г�>
		pN.setLayout(new GridLayout(2, 3, 10, 10));
		pN.add(new Checkbox("���", null, true));
		pN.add(new Checkbox("�ٳ���", null, false));
		pN.add(new Checkbox("����", null, false));
		
		pN.add(new Checkbox("��ħ", chg, true));
		pN.add(new Checkbox("����", chg, false));
		pN.add(new Checkbox("����", chg, false));
		
		// <�Ʒ� �г�>
		pS.setLayout(new BorderLayout(10, 0)); // BorderLayout(int hgap, int vgap) ���
		ch.add("��ħ");
		ch.add("����");
		ch.add("����");
		pS.add(ch, "Center");
		pS.add(exit, "East");

		// <��ü>
		// Frame�� ����Ʈ ���̾ƿ��� Border�̹Ƿ�, ���� X
		setLayout(new BorderLayout(0, 10)); // Border�� �ٸ� ������ �̿��� ���� setLayout���� //setLayout(LayoutManager lm)
											         // //BorderLayout(int hgap, int vgap)
		add(pN, "North");
		add(ta, "Center");
		add(pS, "South");

		/////////////////////////////�޸𸮻��� Frame ��ġ �Ϸ�//////////////////////////

		setBounds(300, 200, 300, 500); // setBounds(int x, int y, int width, int height) : ��ġ, ũ�� �� �濡 ����
		setVisible(true); // ��ġ �Ϸ�� Frame�� ���̰� �ϱ� ***�׻� ��ġ���� ������
	}

	public static void main(String[] args) {
		new ItemText();
	}

}
