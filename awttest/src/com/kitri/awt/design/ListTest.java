package com.kitri.awt.design;

import java.awt.*;

public class ListTest extends Frame {
	
	Panel pL = new Panel();
	Panel pC = new Panel();
	Panel pR = new Panel();

	List listL = new List();
	TextField tfL = new TextField();
	
	Button btR = new Button("▷");
	Button btRAll = new Button("▶");
	Button btL = new Button("◁");
	Button btLAll = new Button("◀");

	List listR = new List();
	TextField tfR = new TextField();

	public ListTest() {
		super("리스트 테스트");
		// <pL 패널>
		listL.setBackground(Color.BLACK);
		tfL.setBackground(Color.GREEN);
		pL.setLayout(new BorderLayout(0, 10));
		pL.add(listL, "Center");
		pL.add(tfL, "South");
	
		// <pC 패널>
		pC.setLayout(new GridLayout(6, 1, 0, 20));
		pC.add(new Label());
		pC.add(btR);
		pC.add(btRAll);
		pC.add(btL);
		pC.add(btLAll);
//		pC.add(new Label());  //GridLayout은 만들어진 칸에 컴포넌트가 없어도 자리를 차지한 후 그 곳을 비워둠
	
		// <pR 패널>
		listR.setBackground(Color.BLACK);
		tfR.setBackground(Color.GREEN);
		pR.setLayout(new BorderLayout(0, 10));
		pR.add(listR, "Center");
		pR.add(tfR, "South");
		
		// <전체>
		// Frame의 디폴트 레이아웃이 Border이므로, 지정 X
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(1, 3, 10, 0));
		add(pL);
		add(pC);
		add(pR);

		///////////////////////////// 메모리상의 Frame 배치 완료//////////////////////////
		
		setBounds(300, 200, 300, 500); // setBounds(int x, int y, int width, int height) : 위치, 크기 한 방에 지정
		setVisible(true); // 배치 완료된 Frame을 보이게 하기 ***항상 배치부의 마지막
	}

	public static void main(String[] args) {
		new ListTest();
	}

}
