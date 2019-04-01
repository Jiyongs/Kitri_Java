package com.kitri.awt.event;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//[��Ʈ�ѷ� Ŭ����]

public class CalculatorController implements ActionListener {

	Calculator calculator; // Calculator ��ü�� �ּ�
	CalculatorService calculatorService; // CalculatorService ��ü�� �ּ�

	public CalculatorController(Calculator calulator) {
		this.calculator = calulator;
		calculatorService = new CalculatorService(this);
	}

	// ###������ �и��� �޼ҵ� ȣ��###
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		Button obb = (Button) ob;
		String obbstr = obb.getLabel();

		if (ob == calculator.exit) { // ���� ��ư Ŭ��
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
