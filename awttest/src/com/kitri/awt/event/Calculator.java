package com.kitri.awt.event;

import java.awt.*;

// [������ Ŭ����]
// ���� ����
// 1. �� �ڸ� ������ ���     - ���
//ȭ�� : 5 *
//�Է� : 5
//      =������ ȭ�� : 25

// 2. ���� �ڸ� ������ ���
//ȭ�� : 25 *
//�Է� : 4
//    =������ ȭ�� : 100

//troment2@nate.com�� 1, 2 java ������ �����ؼ� "Calculator_�̸�.zip" ÷�����Ϸ� ������  *�Ͽ��� 6����!
// ���� ���� : Kitri_�̸�_���ڸ�      (���ڸ��� �ϼ� ��)
//                            �����ڸ�   (�����ڸ����� �ϼ� ��) ... �����ڸ��� ������ ��!!
// ���� ���� : Calculator.java
//                �ҽ� ����
//                CalculatorController.java
//                �ҽ� ����
//                CalculatorService.java
//                �ҽ� ����

public class Calculator extends Frame {

	Panel pN = new Panel();
	Panel pC = new Panel();

	Label numL = new Label();    //���ڸ�
	Label openL = new Label();   //�����ڸ�

	Button btn[] = new Button[16];
	String str[] = { "7", "8", "9", "+",
						"4", "5", "6", "-",
						"1", "2", "3", "*",
						"0", "C", "=", "/" };

	Button exit = new Button("��  ��");
	
	// ###�����̳� Ŭ����###
	CalculatorController calculatorController;
	
	public Calculator() {
		// <���� �г�>
		numL.setBackground(Color.LIGHT_GRAY);
		openL.setBackground(Color.LIGHT_GRAY);
		numL.setFont(new Font("���� ���", Font.BOLD, 20));
		openL.setFont(new Font("���� ���", Font.BOLD, 20));
		openL.setForeground(Color.WHITE);
		pN.setLayout(new BorderLayout(10, 10));
		pN.add(numL, "Center");
		pN.add(openL, "East");

		pC.setLayout(new GridLayout(4, 4));
		int len = btn.length;
		int j = 0;
		for (int i = 0; i < len; i++) {
			btn[i] = new Button(str[i]);
//			btn[i].setLabel(str[i]);
			btn[i].setBackground(new Color(j, 110, 110));
			pC.add(btn[i]);
			j+=10;
		}
	
		
		// <������>
		setLayout(new BorderLayout(20, 20));
		add(pN, "North");
		add(pC, "Center");
		add(exit, "South");		
		
		///////////////////////////// �޸𸮻��� Frame ��ġ �Ϸ�//////////////////////////

		setBounds(300, 200, 300, 500); // setBounds(int x, int y, int width, int height) : ��ġ, ũ�� �� �濡 ����
		setVisible(true); // ��ġ �Ϸ�� Frame�� ���̰� �ϱ� ***�׻� ��ġ���� ������		
		
		// ***�̺�Ʈ ������ ���***
		calculatorController = new CalculatorController(this);
		//���� ��ư 16��
		for(int i = 0; i<16; i++) {
			btn[i].addActionListener(calculatorController);
		}
		//���� ��ư 1��
		exit.addActionListener(calculatorController);
	}

	public static void main(String[] args) {

		new Calculator();

	}

}
