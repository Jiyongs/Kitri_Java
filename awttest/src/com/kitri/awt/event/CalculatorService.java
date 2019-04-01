package com.kitri.awt.event;

import java.awt.Button;

//[로직 클래스]

public class CalculatorService {

	// [필드]
	
	private CalculatorController calcon;
	private Calculator cal;  // Calculator 객체 주소

	int pNum; //과거 입력값
	int inputNum; //최근 입력값
	int result;
	
	// [생성자]
	public CalculatorService(CalculatorController calculatorController) {
		calcon = calculatorController;
		cal = calculatorController.calculator;
		
		pNum = 0;
		inputNum = 0;
		result = 0;
	}
	
	// [메소드]

	// <프로그램 종료> 메소드
	public void exit() {
		System.exit(0);
	}

		public void clear() {
			cal.numL.setText("");
			cal.openL.setText("");
			pNum = 0;
		}

		public void calAdd() {
			cal.openL.setText("+");
		}

		public void calSub() {
			cal.openL.setText("-");
		}

		public void calMul() {
			cal.openL.setText("*");
		}

		public void calDiv() {
			cal.openL.setText("/");
		}

		public void calResult() {
			cal.openL.setText(""); //openL 비우기
			
			inputNum = Integer.parseInt(cal.numL.getText()); //마지막 입력값 저장
			System.out.println(inputNum);
			
			String oper = cal.openL.getText();
			switch (oper) {
			case "+":	result = pNum;
						result += inputNum;
						cal.numL.setText(result+""); break;
			case "-":	result = pNum;
						result -= inputNum;
						cal.numL.setText(result+""); break;
			case "*":	result = pNum;
						result *= inputNum;
						cal.numL.setText(result+""); break;
			default: result = pNum;
						result /= inputNum;
						cal.numL.setText(result+"");
			}
		}

		public void inputNum(String num) {
			pNum = Integer.parseInt(num);  // pNum에 입력값 저장
			cal.numL.setText(num);            // numL에 입력값 띄우기
		}
	
}




//	// <계산> 메소드
//	public void calResult(Button button) {
//		
//		String input = "";
//		
//		// 1. 입력값을 받기
//		for(int i=0; i<len; i++) {
//			if(inputStr[i]==null) {
//				// 2. 입력값의 유효성 검사하기 (첫번째는 무조건 숫자)  #######*1해도 알아서 1로 계산해줄거니까 안해도 되나..?
////				if(cal.numL.getText()==null) {
////					if(!isNumber(inputStr[i])) {
////						System.out.println("연산할 숫자가 없습니다.");
////						return;
////					}
////				}
//				if(inputStr[i].equals("=")) {
//					viewTotalResult();
//				} else {
//					inputStr[i] = button.getLabel().trim();
//					input = inputStr[i];
//					break;
//				}
//			}	
//		}
//		
//		// 2-1. c면,
//		// numL, openL에 띄운 값 모두 지우기
//		if(input.equals("C")) {
//			clear(cal.numL);
//			clear(cal.openL);
//		} 
//		// 2-2. 숫자 값이면,
//		// 입력값을 numL에 띄우기
//		else if(isNumber(input)) {
//			viewNumResult(input);
//		}
//		// 2-3. C, =를 제외한 연산자 값이면,
//		// 입력값을 openL에 띄우기
//		else {
//				viewOperResult(input);			
//		}
//			
//		// 3. numL값과 openL값 마지막입력값을 연산
//		
//		
//		// 4. 연산 결과를 numL에 띄우기
//	}
//
//	    // <numL라벨에 숫자 출력> 메소드
//		private void viewNumResult(String str) {
//			cal.numL.setText(str);
//		}
//		
//		// <openL라벨에 연산자 출력> 메소드
//		private void viewOperResult(String str) {
//			cal.openL.setText(str);
//		}
//		
//		// <연산 결과 출력> 메소드
//		private void viewTotalResult() {
//			String str = "";
//			String oper = "";
//			String result = "";
//
//			for(int i = 0; i<len; i++) {
//				if(!isNumber(inputStr[i]))
//					oper = inputStr[i];
//				str += inputStr[i];
//			}
//			// 입력값으로 계산한 값을 밑에 메소드에 넣어야 함!!!! #############################
//			
//			int l = str.length();
//			for(int i = 0; i<l; i++) {
//				result += str.charAt(i);
//			}
//			viewNumResult("");
//		}
//	
//		// <인자값의 숫자여부 출력> 메소드
//		private boolean isNumber(String str) {
//			boolean flag = true;
//			int len = str.length();
//			for(int i = 0; i <len ; i++) {
//				int x = str.charAt(i) - 48;  //x는 아스키 코드
//				if(x < 0 || x > 9) {
//					flag = false;
//					break;
//				}
//			}	
//			return flag;
//		}
//		
//	// <화면 지우기> 메소드
//		private void clear(Object o) {
//			if(o == cal.numL)
//				cal.numL.setText("");
//			else
//				cal.openL.setText("");
//		}
//}
