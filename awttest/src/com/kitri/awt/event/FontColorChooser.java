package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

public class FontColorChooser extends Frame {

	Panel pL = new Panel();
	Panel pLL = new Panel();
	Panel pLR = new Panel();
	Panel pLC = new Panel();
	
	Panel pR = new Panel();
	Panel pRS = new Panel();
	
	Panel colorP = new Panel();

	Label l1 = new Label();
	Label l2 = new Label();
	
	Label lR = new Label("빨강");
	Label lG = new Label("초록");
	Label lB = new Label("파랑");
	Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL, 265/2-5, 10, 0, 265);
	Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL, 265/2-5, 10, 0, 265);
	Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL, 265/2-5, 10, 0, 265);

	Label colorL = new Label();
	Button ok = new Button("확인");
	
	public FontColorChooser() {

		// <색상 지정>
		colorP.setBackground(Color.ORANGE);
		colorL.setBackground(Color.GREEN);

		// <pLL 패널>
		pLL.setLayout(new GridLayout(3,1, 0, 10));
		lR.setBackground(Color.RED);
		lG.setBackground(Color.GREEN);
		lB.setBackground(Color.BLUE);
		pLL.add(lR);
		pLL.add(lG);
		pLL.add(lB);
		// <pLR 패널>
		pLR.setLayout(new GridLayout(3, 1, 0, 10));
		pLR.add(sbR);
		pLR.add(sbG);
		pLR.add(sbB);
		// <pLC 패널>
		pLC.setLayout(new BorderLayout());
		pLC.add(pLL, "West");
		pLC.add(pLR, "Center");
		// <pL 패널>
		pL.setLayout(new BorderLayout());
		pL.add(l1, "North");
		pL.add(l2, "South");
		pL.add(pLC, "Center");

		// <pRS 패널>
		pRS.setLayout(new BorderLayout());
		pRS.add(colorL, "Center");
		pRS.add(ok, "East");
		
		// <pR 패널>
		pR.setLayout(new BorderLayout(0, 10));
		pR.add(colorP);
		pR.add(pRS, "South");
		

		// <프레임>
		setLayout(new GridLayout(1, 2));
		add(pL);
		add(pR);
		
		///////////////////////////// 메모리상의 Frame 배치 완료//////////////////////////

		setBounds(300, 200, 500, 250); // setBounds(int x, int y, int width, int height) : 위치, 크기 한 방에 지정
		// ###setVisible() 없애야 함!###
		
		// FontColorChooser 클래스에서만 사용하는 메소드
		// : 색상 창의 윈도우 창 닫기 버튼은, 창 안보이게만 하는 것
		//   BaseBall창의 윈도우 창 닫기 버튼은, 프로그램을 종료하는 것
		//    => 따라서, BaseBallController의 windowAdapter의 메소드 정의는 BaseBall창 닫기 기능만 해두고
		//         FontColorChooser의 windowAdapter의 메소드 정의는 색상 창 안보이게하는 기능으로 해둔다.
		//         => 가능한 이유는, WindowApater 클래스가 '의미상의 추상클래스'라서
		//              WindowAdapter클래스의 메소드 사용을 위해, WindowAdapter() 생성자를 이용해서 메소드 중 하나 이상만 override하면 되니까!
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		
		// 000Listener에 컴포넌트를 등록
		// ###이걸 디자인메소드로 옮김###

	}

}

