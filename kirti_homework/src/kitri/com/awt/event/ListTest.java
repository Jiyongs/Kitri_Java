package kitri.com.awt.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// �̺�Ʈ �ҽ� : 6�� (��ư 4�� + �ؽ�Ʈ�ʵ� 2��)
// ��ư, �ؽ�Ʈ�ʵ� �׼��̺�Ʈ

// *���� : ����Ʈ ���� ���߼��� �����ϰ� �ؼ�, ������ �׸��� �ű�� �ϱ�!!! (�Ϸ�)

public class ListTest extends Frame implements ActionListener {
	
	Panel pL = new Panel();
	Panel pC = new Panel();
	Panel pR = new Panel();

	List listL = new List(20, true);             //List(int index, boolean mutipleMode) *��Ƽ�ø�� : ���� ���� ����
	TextField tfL = new TextField();
	
	Button btR = new Button("��");
	Button btRAll = new Button("��");
	Button btL = new Button("��");
	Button btLAll = new Button("��");

	List listR = new List(20, true);
	TextField tfR = new TextField();

	public ListTest() {
		super("����Ʈ �׽�Ʈ");
		// <pL �г�>
		listL.setBackground(Color.WHITE);
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
		listR.setBackground(Color.WHITE);
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

		// 000Listener�� ������Ʈ�� ���
		tfL.addActionListener(this);
		tfR.addActionListener(this);
		btL.addActionListener(this);
		btLAll.addActionListener(this);
		btR.addActionListener(this);
		btRAll.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new ListTest();
	}

	//[������] : ��� �޼ҵ� ����
	// �츮�� ȣ���� �� ���� �޼ҵ� // �����ʿ� ����ؾ� ��
	
	// <action �߻� �̺�Ʈ> : Button, TextField
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		// 1~6) **�̺�Ʈ �ҽ��� ������ ������Ʈ�� ��**
		if(ob == tfL) {
			//1. tfL�� ���� get (��ȿ�� �˻� = �� ���̸� �Է¾ȵǰ� �ϱ�)
			String temp = tfL.getText().trim();    //trim() : ��������
			tfL.setText("");        //TextField�� �Էµ� ���� ����� �뵵
			if(temp.isEmpty())                       //isEmpty() : ��ȿ�� �˻�
				return;            //�� �޼ҵ带 ȣ���� �����ʷ� ���ư� = �����ʿ��� �ٽ� �����ض�! (�޼ҵ� ����)
			//2. listL�� �߰�
			listL.add(temp);
		} else if (ob == tfR) {
			String temp = tfR.getText().trim(); 
			tfR.setText("");  
			if(temp.isEmpty()) 
				return;
			listR.add(temp);
		} else if (ob == btL ) {
			String temp[] = listR.getSelectedItems();
			if(temp==null) 
				return;
			int len = temp.length;
			for (int i = 0; i < len; i++) {
				listL.add(temp[i]);
				listR.remove(temp[i]);
			}
		} else if (ob == btLAll) {
			String temp[] = listR.getItems();
			int len = temp.length;
			for (int i = 0; i < len; i++) {
				listL.add(temp[i]);
			}	
			for (int i = len-1 ; i >= 0; i--) {   
				listR.remove(i);
			}
		} else if (ob == btR) {
			//1. listL���� ������ ���ڿ� get (��ȿ�� �˻� = ����Ʈ���� ���õ� ���� ���� �� ���� ����)
			String temp[] = listL.getSelectedItems();
			if(temp==null)      //��ȿ�� �˻�
				return;
			//2. 1�� ���� listR�� �߰�.
			//3. 1�� ���� listL���� ����.
			int len = temp.length;
			for (int i = 0; i < len; i++) {
				listR.add(temp[i]);
				listL.remove(temp[i]);	
			}
		} else if (ob == btRAll) {
			//1. listL�� ���� ��� get (��ȿ�� �˻�)
			String temp[] = listL.getItems();
			//2. 1�� ���� listR�� ��� �߰�
			int len = temp.length;
			for (int i = 0; i < len; i++) {
				listR.add(temp[i]);
			}
			//3. 1�� ���� listL���� ��� ����   //�迭�� index�� �̿��Ͽ� ��� ���� ���� ��, 0���� �����ϸ�,
			                                          //�迭�� ũ�Ⱑ ���ϱ� ������,
			                                          //���� listL �׸��� ����� for������ �迭�� ũ�⿡�� NullPointException �߻�! ...����
			                                          //����, idext�� �̿��� �迭�� �� ���Ŵ� �Ųٷ� ����			
			for (int i = len-1 ; i >= 0; i--) {   
				listL.remove(i);
			}
			// listL.removeAll();
			
		}
		
	}

}
