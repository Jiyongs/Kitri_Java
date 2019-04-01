package kitri.com.awt.event;

import java.awt.*;
import java.awt.event.*;

// 1) üũ�ڽ� �׷��� ���� �ٲ� ������ ���� ���̽����� �Ȱ��� �ٲ�
// 2) �ؽ�Ʈarea�� �ִ� ���� üũ�ڽ�, üũ�ڽ� �׷� ���� �ٲ�� �Ȱ��� �ٲ�
//                                  üũ�Ǹ�, �Ծ��� / üũ �����Ǹ� �� �Ծ��ٷ� �ٲ�

// TextArea �Է� ����
//-- ���� --
//1. ��� : �Ծ���.
//2. �ٳ��� : �� �Ծ���.
//3. ���� : �� �Ծ���.


// �̺�Ʈ �ҽ� : 8�� (üũ�ڽ� 6�� + ���̽� 1�� + ��ư 1��) *textarea�� �ƴ�
// ��ư - ActionEvent / ActionListener
// üũ�ڽ�, ���̽� - ItemEvent / 

// ������ ���� ��� - 1. �����ʵ��� implement�Ͽ� ������ Ŭ�����ȿ� ���� ����
//                         2. �����ʸ� �ٸ� Ŭ������ ���� ����(������, ����� �и� ����)

public class ItemText extends Frame {

	Panel pN = new Panel();
	Panel pS = new Panel();
	
	CheckboxGroup chg = new CheckboxGroup();

	Checkbox mor = new Checkbox("��ħ", chg, true);
	Checkbox aft = new Checkbox("����", chg, false);
	Checkbox eve = new Checkbox("����", chg, false);
	Checkbox app = new Checkbox("���", null, true);
	Checkbox banana = new Checkbox("�ٳ���", null, false);
	Checkbox straw = new Checkbox("����", null, false);

	
	TextArea ta = new TextArea();

	Choice ch = new Choice();
	Button exit = new Button("����");
	
	//
	ItemLogic itemLogic;
	

	public ItemText() {
		// <���� �г�>
		pN.setLayout(new GridLayout(2, 3, 10, 10));
		pN.add(app);
		pN.add(banana);
		pN.add(straw);
		
		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		
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
		
		//[������Ʈ�� ~Listener�� ���]
		// [���� �̺�Ʈ] - ���� ��ư
		//exit.addActionListener(new ItemTest());  //addActionListener()�� ���ڷ� ActionListener ��ü�� ������ ActionListener�� �������̽��̹Ƿ�, 
														   // ActionListener�� �����ϴ� Ŭ����, �� Ŭ���� �ڽ�(ItemTest)�� ���ڷ� �־�� ��. but,
		                                                  // new ItemTest()�ϸ� �� ��ü�� �����ϴ� ���̹Ƿ� �����ڰ� �ڽ��� �����Ͽ� ���� ����..����! ����,
														 // this�� �̿��Ͽ� Ŭ���� �ڽ��� �־��ش�.

		// ###���� �и�###
		itemLogic = new ItemLogic(this);
		exit.addActionListener(itemLogic);
		
		// [üũ�ڽ� �̺�Ʈ]
		mor.addItemListener(itemLogic);
		aft.addItemListener(itemLogic);
		eve.addItemListener(itemLogic);
		app.addItemListener(itemLogic);
		banana.addItemListener(itemLogic);
		straw.addItemListener(itemLogic);
		ch.addItemListener(itemLogic);
		
	}

	public static void main(String[] args) {
		new ItemText();
	}

	//[������] : ��� �޼ҵ� ����
	// �츮�� ȣ���� �� ���� �޼ҵ� // �����ʿ� ����ؾ� ��
	// ###���� �и�###

	
}
