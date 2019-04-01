package com.kitri.awt.event;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//[컨트롤러 클래스]

public class CalculatorController implements ActionListener {

	Calculator calculator; // Calculator 객체의 주소
	CalculatorService calculatorService; // CalculatorService 객체의 주소

	public CalculatorController(Calculator calulator) {
		this.calculator = calulator;
		calculatorService = new CalculatorService(this);
	}

	// ###로직에 분리된 메소드 호출###
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		Button obb = (Button) ob;
		String obbstr = obb.getLabel();

		if (ob == calculator.exit) { // 종료 버튼 클릭
			calculatorService.exit();
		} else {
			switch (obbstr) {
			case "+":
				calculatorService.calAdd();
				break;
			case "-":
				calculatorService.calSub();
				break;
			case "*":
				calculatorService.calMul();
				break;
			case "/":
				calculatorService.calDiv();
				break;
			case "=":
				calculatorService.calResult();
				break;
			case "C":
				calculatorService.clear();
				break;
			default:
				calculatorService.inputNum(obbstr);
			}
		}
	}
}
