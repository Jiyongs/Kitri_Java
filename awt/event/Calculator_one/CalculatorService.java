package com.kitri.awt.event;

//[**로직 클래스**]

public class CalculatorService {

	// [필드/선언부]

	private CalculatorController calcon; // CalculatorController 객체 주소
	private Calculator cal; 			 // Calculator 객체 주소

	private double pNum; // 입력 전의 숫자 값
	private double cNum; // 입력한 현재 숫자 값

	// [생성자]
	public CalculatorService(CalculatorController calculatorController) {
		calcon = calculatorController;
		cal = calculatorController.calculator;

		pNum = 0;

	}

	// [메소드/구현부]

	// <프로그램 종료> 메소드
	public void exit() {
		System.exit(0);
	}

	// <숫자값 입력받을 때> 메소드
	public void insertNum(int obbstr) {
		if(pNum!=0) {        //두 번째 이상의 입력일 때
			cNum = obbstr;
			cal.numL.setText(cNum + "");
		} else {             //첫 번째 입력일 때
			pNum = obbstr;
			cal.numL.setText(pNum + "");
		}
	}

	// <문자값 입력받을 때> 메소드
	public void insertChar(String obbstr) {

		switch (obbstr) {
		case "+":                      // "+, -, *, /" 일 때는 operL에 연산자 set 
			cal.operL.setText(obbstr);
			break;
		case "-":
			cal.operL.setText(obbstr);
			break;
		case "*":
			cal.operL.setText(obbstr);
			break;
		case "/":
			cal.operL.setText(obbstr);
			break;
		case "C":                       // "C" 일 때는 numL과 operL을 글씨 지우기 & 입력 숫자값 초기화
			cal.numL.setText("");
			cal.operL.setText("");
			pNum = 0;
			cNum = 0;
			break;
		default: 						// "=" 일 때는 operL의 현재 라벨값에 따라, 입력된 숫자 2개를 연산
			String oper = cal.operL.getText();
			cal.operL.setText("");

			switch (oper) {
			case "+":
				pNum = add(pNum, cNum);
				cal.numL.setText(pNum + "");
				break;
			case "-":
				pNum = sub(pNum, cNum);
				cal.numL.setText(pNum + "");
				break;
			case "*":
				pNum = mul(pNum, cNum);
				cal.numL.setText(pNum + "");
				break;
			case "/":
				pNum = div(pNum, cNum);
				cal.numL.setText(pNum + "");
				break;
			default : cal.numL.setText(pNum + ""); //연산자가 입력되지 않은 상태면, 현재까지 계산된 최종값 pNum을 출력함
			}
		}

	}

	// <더하기> 메소드
	public double add(double n1, double n2) {
		return n1 + n2;
	}

	// <빼기> 메소드
	public double sub(double n1, double n2) {
		return n1 - n2;
	}

	// <곱하기> 메소드
	public double mul(double n1, double n2) {
		return n1 * n2;
	}

	// <나누기> 메소드
	public double div(double n1, double n2) {
		return n1 / n2;
	}

	// <문자열의 숫자여부 출력> 메소드
	public boolean isNumber(String str) {
		boolean flag = true;

		int len = str.length();
		for (int i = 0; i < len; i++) {
			int x = str.charAt(i) - 48; // x는 아스키 코드
			if (x < 0 || x > 9) {
				flag = false;
				break;
			}
		}
		return flag;
	}

}
