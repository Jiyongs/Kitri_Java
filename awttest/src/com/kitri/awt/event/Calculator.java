package com.kitri.awt.event;

import java.awt.*;

// [디자인 클래스]
// 과제 내용
// 1. 한 자리 숫자의 계산     - 백업
//화면 : 5 *
//입력 : 5
//      =누르면 화면 : 25

// 2. 여러 자리 숫자의 계산
//화면 : 25 *
//입력 : 4
//    =누르면 화면 : 100

//troment2@nate.com에 1, 2 java 파일을 압축해서 "Calculator_이름.zip" 첨부파일로 보내기  *일요일 6까지!
// 메일 제목 : Kitri_이름_한자리      (한자리만 완성 시)
//                            여러자리   (여러자리까지 완성 시) ... 여러자리만 보내두 됨!!
// 메일 내용 : Calculator.java
//                소스 복붙
//                CalculatorController.java
//                소스 복붙
//                CalculatorService.java
//                소스 복붙

public class Calculator extends Frame {

	Panel pN = new Panel();
	Panel pC = new Panel();

	Label numL = new Label();    //숫자만
	Label openL = new Label();   //연산자만

	Button btn[] = new Button[16];
	String str[] = { "7", "8", "9", "+",
						"4", "5", "6", "-",
						"1", "2", "3", "*",
						"0", "C", "=", "/" };

	Button exit = new Button("종  료");
	
	// ###컨테이너 클래스###
	CalculatorController calculatorController;
	
	public Calculator() {
		// <위쪽 패널>
		numL.setBackground(Color.LIGHT_GRAY);
		openL.setBackground(Color.LIGHT_GRAY);
		numL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		openL.setFont(new Font("맑은 고딕", Font.BOLD, 20));
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
	
		
		// <프레임>
		setLayout(new BorderLayout(20, 20));
		add(pN, "North");
		add(pC, "Center");
		add(exit, "South");		
		
		///////////////////////////// 메모리상의 Frame 배치 완료//////////////////////////

		setBounds(300, 200, 300, 500); // setBounds(int x, int y, int width, int height) : 위치, 크기 한 방에 지정
		setVisible(true); // 배치 완료된 Frame을 보이게 하기 ***항상 배치부의 마지막		
		
		// ***이벤트 리스너 등록***
		calculatorController = new CalculatorController(this);
		//계산기 버튼 16개
		for(int i = 0; i<16; i++) {
			btn[i].addActionListener(calculatorController);
		}
		//종료 버튼 1개
		exit.addActionListener(calculatorController);
	}

	public static void main(String[] args) {

		new Calculator();

	}

}
