package com.kitri.awt.event;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//[**컨트롤러 클래스**]

public class CalculatorController implements ActionListener {

	// [필드/선언부]
	
	Calculator calculator; // Calculator 객체의 주소
	CalculatorService calculatorService; // CalculatorService 객체의 주소

	// [생성자]
	public CalculatorController(Calculator calulator) {
		this.calculator = calulator;
		calculatorService = new CalculatorService(this);
	}

	// [메소드/구현부]
	
	// <리스너의 메소드>를 override
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();       // ob     : 눌린 버튼의 주소를 가진 Object 객체

		Button obb = (Button) ob;        // obb    : 눌린 버튼의 주소를 가진 Button 객체 ('ob'를 Button형으로 형변환한 것)
		String obbstr = obb.getLabel();  // obbstr : 눌린 버튼의 라벨값 String 객체       ('obb'의 주소에 있는 라벨값을 가져온 것)

		if (ob == calculator.exit) { // 종료 버튼일 때
			calculatorService.exit();
		} else {
			if(calculatorService.isNumber(obbstr)) { //숫자 버튼일 때
				calculatorService.insertNum(Integer.parseInt(obbstr)); //입력된 숫자값(int) 담아서, 입력함수 호출
			} else { 								 //문자 버튼일 때
				calculatorService.insertChar(obbstr); 				   //입력된 문자값(String) 담아서, 입력함수 호출
			}
		}
		
		
	}
}
