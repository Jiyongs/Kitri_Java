package com.kitri.awt.design;

import java.awt.*;

public class Calculator extends Frame {

	Panel pN = new Panel();
	Panel pC = new Panel();

	Label numL = new Label();
	Label openL = new Label();

	Button btn[] = new Button[16];
	String str[] = { "7", "8", "9", "+",
						"4", "5", "6", "-",
						"1", "2", "3", "*",
						"0", "C", "=", "/" };

	Button exit = new Button("종  료");
	
	public Calculator() {
		// <위쪽 패널>
		numL.setBackground(Color.LIGHT_GRAY);
		openL.setBackground(Color.DARK_GRAY);
		pN.setLayout(new BorderLayout(10, 10));
		pN.add(numL, "Center");
		pN.add(openL, "East");

		pC.setLayout(new GridLayout(4, 4));
		int len = btn.length;
		int j = 0;
		for (int i = 0; i < len; i++) {
			btn[i] = new Button(str[i]);
//			btn[i].setLabel(str[i]);
			btn[i].setBackground(new Color(j, j, j));
			pC.add(btn[i]);
			j+=10;
		}
		
		for (int i =0; i<len; i++) {

		}
		
		// <프레임>
		setLayout(new BorderLayout(20, 20));
		add(pN, "North");
		add(pC, "Center");
		add(exit, "South");		
		
		///////////////////////////// 메모리상의 Frame 배치 완료//////////////////////////

		setBounds(300, 200, 300, 500); // setBounds(int x, int y, int width, int height) : 위치, 크기 한 방에 지정
		setVisible(true); // 배치 완료된 Frame을 보이게 하기 ***항상 배치부의 마지막
	}

	public static void main(String[] args) {

		new Calculator();

	}

}
