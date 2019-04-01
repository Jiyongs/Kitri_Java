package com.kitri.awt.design;

import java.awt.*;

public class BaseBall extends Frame {

	Panel pE = new Panel();
	Panel pS = new Panel();

	TextArea ta = new TextArea();

	Button newG = new Button("새게임");
	Button clear = new Button("지우기");
	Button dop = new Button("정 답");
	Button fontC = new Button("글자색");
	Button exit = new Button("종료");

	Label l = new Label("숫자",  Label.CENTER);
	TextField tf = new TextField();
	
	Label ls = new Label();

	public BaseBall() {
		// <오른쪽 패널>
		pE.setLayout(new GridLayout(5, 1, 10, 10));
		pE.add(newG);
		pE.add(clear);
		pE.add(dop);
		pE.add(fontC);
		pE.add(exit);

		// <아래 패널>
		pS.setLayout(new BorderLayout(10, 10));
		pS.add(l, "West");
		pS.add(tf, "Center");
		pS.add(ls, "East");

		// <프레임>
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(10, 10));
		add(ta, "Center");
		add(pE, "East");
		add(pS, "South");

		///////////////////////////// 메모리상의 Frame 배치 완료//////////////////////////

		setBounds(300, 200, 500, 400); // setBounds(int x, int y, int width, int height) : 위치, 크기 한 방에 지정
		setVisible(true); // 배치 완료된 Frame을 보이게 하기 ***항상 배치부의 마지막

	}

	public static void main(String[] args) {
		new BaseBall();
	}

}
