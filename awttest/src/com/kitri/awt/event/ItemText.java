package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

// 1) 체크박스 그룹의 값이 바뀔 때마다 밑의 초이스값도 똑같이 바뀜
// 2) 텍스트area에 있는 값도 체크박스, 체크박스 그룹 값이 바뀌면 똑같이 바뀜
//                                  체크되면, 먹었다 / 체크 해제되면 안 먹었다로 바뀜

// TextArea 입력 예시
//-- 저녁 --
//1. 사과 : 먹었다.
//2. 바나나 : 안 먹었다.
//3. 딸기 : 안 먹었다.


// 이벤트 소스 : 8개 (체크박스 6개 + 초이스 1개 + 버튼 1개) *textarea는 아님
// 버튼 - ActionEvent / ActionListener
// 체크박스, 초이스 - ItemEvent / 

// 리스너 구현 방법 - 1. 리스너들을 implement하여 디자인 클래스안에 같이 구현
//                         2. 리스너를 다른 클래스에 따로 구현(디자인, 기능을 분리 가능)

public class ItemText extends Frame {

	Panel pN = new Panel();
	Panel pS = new Panel();
	
	CheckboxGroup chg = new CheckboxGroup();

	Checkbox mor = new Checkbox("아침", chg, true);
	Checkbox aft = new Checkbox("점심", chg, false);
	Checkbox eve = new Checkbox("저녁", chg, false);
	Checkbox app = new Checkbox("사과", null, true);
	Checkbox banana = new Checkbox("바나나", null, false);
	Checkbox straw = new Checkbox("딸기", null, false);

	
	TextArea ta = new TextArea();

	Choice ch = new Choice();
	Button exit = new Button("종료");
	
	//
	ItemLogic itemLogic;
	

	public ItemText() {
		// <위쪽 패널>
		pN.setLayout(new GridLayout(2, 3, 10, 10));
		pN.add(app);
		pN.add(banana);
		pN.add(straw);
		
		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		
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
		
		//[컴포넌트를 ~Listener에 등록]
		// [종료 이벤트] - 종료 버튼
		//exit.addActionListener(new ItemTest());  //addActionListener()는 인자로 ActionListener 객체를 받지만 ActionListener는 인터페이스이므로, 
														   // ActionListener를 구현하는 클래스, 즉 클래스 자신(ItemTest)을 인자로 넣어야 함. but,
		                                                  // new ItemTest()하면 새 객체를 생성하는 것이므로 생성자가 자신을 생성하여 무한 생성..문제! 따라서,
														 // this를 이용하여 클래스 자신을 넣어준다.

		// ###로직 분리###
		itemLogic = new ItemLogic(this);
		exit.addActionListener(itemLogic);
		
		// [체크박스 이벤트]
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

	//[구현부] : 기능 메소드 구현
	// 우리가 호출할 수 없는 메소드 // 리스너에 등록해야 함
	// ###로직 분리###

	
}
