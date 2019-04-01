package com.kitri.awt.design;

import java.awt.*;

import javafx.scene.layout.Border;

public class ColorSelector extends Frame {

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
	
	public ColorSelector() {

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
		setVisible(true); // 배치 완료된 Frame을 보이게 하기 ***항상 배치부의 마지막
		
		int r = sbR.getValue();
		int g = sbG.getValue();
		int b = sbB.getValue();
				
		colorP.setBackground(new Color(r, g, b));
		colorL.setText("r = " + r + "g = " + g + "b = " + b);
	}

	public static void main(String[] args) {
		new ColorSelector();
	}
	

}




/*
public class ColorSelector extends Frame {

	Panel pC = new Panel();
	Panel pCG = new Panel();

	Panel pE = new Panel();
	
	Panel pEP = new Panel();
	Panel pS = new Panel();

	Label lR = new Label("빨강");
	Label lG = new Label("초록");
	Label lB = new Label("파랑");
	Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL, 0, 60, 0, 255);
	Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL, 0, 60, 0, 255);
	Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL, 0, 60, 0, 255);

	Label colorL = new Label();
	Button ok = new Button("확인");
	
	public ColorSelector() {
		// <Center 패널>
		pCG.setLayout(new GridLayout(3, 3, 10, 10));
		pCG.add(lR);
		pCG.add(sbR);
		pCG.add(lG);
		pCG.add(sbG);
		pCG.add(lB);
		pCG.add(sbB);
		
		pC.add(pCG);

		// <아래 패널>
		pS.setLayout(new BorderLayout(10, 10));
		pS.add(colorL, "Center");
		pS.add(ok, "East");
		
		// <오른쪽 패널>
		pEP.setBackground(Color.black);    //
		colorL.setBackground(Color.black); //
		pE.setLayout(new BorderLayout(10, 10));
	
		pE.add(pEP, "Center");
		pE.add(pS, "South");

		// <프레임>
		setLayout(new BorderLayout(10, 10));
		add(pC, "Center");
		add(pE, "East");
		
		///////////////////////////// 메모리상의 Frame 배치 완료//////////////////////////

		setBounds(300, 200, 300, 500); // setBounds(int x, int y, int width, int height) : 위치, 크기 한 방에 지정
		setVisible(true); // 배치 완료된 Frame을 보이게 하기 ***항상 배치부의 마지막
	}

	public static void main(String[] args) {
		new ColorSelector();
	}
*/