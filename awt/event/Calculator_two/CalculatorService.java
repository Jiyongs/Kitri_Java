package com.kitri.awt.event;

import java.awt.Label;

//[**로직 클래스**]

public class CalculatorService {

	// [필드/선언부]

	private CalculatorController calcon; // CalculatorController 객체 주소
	private Calculator cal; 			 // Calculator 객체 주소
	
	private String spNum = ""; //입력 전의 숫자 값들 누적할 String   (연속되는 수 저장용)
	private String scNum = ""; //입력한 현재 숫자 값들 누적할 String  (연속되는 수 저장용)
	
	private double pNum; // 입력 전의 숫자 값    (계산용)
	private double cNum; // 입력한 현재 숫자 값 (계산용)
	
	private boolean isOper; //연산자 입력 여부 flag

	// [생성자]
	public CalculatorService(CalculatorController calculatorController) {
		calcon = calculatorController;
		cal = calculatorController.calculator;

		pNum = 0;
		isOper = false;
	}

	// [메소드/구현부]

	// <프로그램 종료> 메소드
	public void exit() {
		System.exit(0);
	}

	// <숫자값 입력받을 때> 메소드
	public void insertNum(int obbstr) {
		
		if(!isOper) { //연산자 입력 전일 때
			if(pNum!=0) {        //두 번째 이상의 입력일 때
				spNum += obbstr;
				pNum = Integer.parseInt(spNum);
				cal.numL.setText(pNum + "");
			} else {             //첫 번째 입력일 때
				spNum += obbstr;
				pNum = Integer.parseInt(spNum);
				cal.numL.setText(pNum + "");
			}
		} else {     //연산자 입력 됐을 때
			if(pNum!=0) {        //두 번째 이상의 입력일 때
				scNum += obbstr;
				cNum = Integer.parseInt(scNum);
				cal.numL.setText(scNum);
			}
		}
		
	}

	// <문자값 입력받을 때> 메소드
	public void insertChar(String obbstr) {
		switch (obbstr) {
		case "+":                      // "+, -, *, /" 일 때는 operL에 연산자 set 
			getOper(obbstr);
			break;
		case "-":
			getOper(obbstr);
			break;
		case "*":
			getOper(obbstr);
			break;
		case "/":
			getOper(obbstr);
			break;
		case "C":                       // "C" 일 때는 numL과 operL을 글씨 지우기 & 입력 숫자값 초기화
			clear(cal.numL);
			clear(cal.operL);
			pNum = cNum = 0;
			spNum = scNum = "";
			isOper = false;
			break;
		default: 						// "=" 일 때는 operL의 현재 라벨값에 따라, 입력된 숫자 2개를 연산
			isOper = false;
			String oper = cal.operL.getText();
			clear(cal.operL);
		
			switch (oper) {
			case "+":
				pNum = pNum + cNum;
				cal.numL.setText(pNum + "");
				break;
			case "-":
				pNum = pNum - cNum;
				cal.numL.setText(pNum + "");
				break;
			case "*":
				pNum = pNum * cNum;
				cal.numL.setText(pNum + "");
				break;
			case "/":
				pNum = roundNum(pNum / cNum, 6);
				cal.numL.setText(pNum + "");
				break;
			default : cal.numL.setText(pNum + ""); //연산자가 입력되지 않은 상태면, 현재까지 계산된 최종값 pNum을 출력함
			}
		}

	}
	
	
	// <소수 i번째까지 반올림> 메소드
	public double roundNum(double d, int i) {
		String str = String.format("%."+i+"f", d);
		return Double.parseDouble(str);
	}
	
	// <연산자 입력 시 세팅> 메소드
	public void getOper(String obbstr) {
		cal.operL.setText(obbstr); //operL에 연산자 띄우기
		isOper = true;             //연산자 받았다고 표시
		spNum = "";                //전의 입력값 비우기
		scNum = "";                //현재 입력값 비우기
	}
	
	// <라벨에 띄운 값 지우기> 메소드
	public void clear(Label l) {
		l.setText("");
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
