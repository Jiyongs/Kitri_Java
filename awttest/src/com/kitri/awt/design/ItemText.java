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
	Button exit = new Button("종료");

	public ItemText() {
		// <위쪽 패널>
		pN.setLayout(new GridLayout(2, 3, 10, 10));
		pN.add(new Checkbox("사과", null, true));
		pN.add(new Checkbox("바나나", null, false));
		pN.add(new Checkbox("딸기", null, false));
		
		pN.add(new Checkbox("아침", chg, true));
		pN.add(new Checkbox("점심", chg, false));
		pN.add(new Checkbox("저녁", chg, false));
		
		// <아래 패널>
		pS.setLayout(new BorderLayout(10, 0)); // BorderLayout(int hgap, int vgap) 사용
		ch.add("아침");
		ch.add("점심");
		ch.add("저녁");
		pS.add(ch, "Center");
		pS.add(exit, "East");

		// <전체>
		// Frame의 디폴트 레이아웃이 Border이므로, 지정 X
		setLayout(new BorderLayout(0, 10)); // Border의 다른 생성자 이용을 위해 setLayout해줌 //setLayout(LayoutManager lm)
											         // //BorderLayout(int hgap, int vgap)
		add(pN, "North");
		add(ta, "Center");
		add(pS, "South");

		/////////////////////////////메모리상의 Frame 배치 완료//////////////////////////

		setBounds(300, 200, 300, 500); // setBounds(int x, int y, int width, int height) : 위치, 크기 한 방에 지정
		setVisible(true); // 배치 완료된 Frame을 보이게 하기 ***항상 배치부의 마지막
	}

	public static void main(String[] args) {
		new ItemText();
	}

}
