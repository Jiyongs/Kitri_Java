package com.kitri.awt.event;

import java.awt.Button;

//[���� Ŭ����]

public class CalculatorService {

	// [�ʵ�]
	
	private CalculatorController calcon;
	private Calculator cal;  // Calculator ��ü �ּ�

	int pNum; //���� �Է°�
	int inputNum; //�ֱ� �Է°�
	int result;
	
	// [������]
	public CalculatorService(CalculatorController calculatorController) {
		calcon = calculatorController;
		cal = calculatorController.calculator;
		
		pNum = 0;
		inputNum = 0;
		result = 0;
	}
	
	// [�޼ҵ�]

	// <���α׷� ����> �޼ҵ�
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
			cal.openL.setText(""); //openL ����
			
			inputNum = Integer.parseInt(cal.numL.getText()); //������ �Է°� ����
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
			pNum = Integer.parseInt(num);  // pNum�� �Է°� ����
			cal.numL.setText(num);            // numL�� �Է°� ����
		}
	
}




//	// <���> �޼ҵ�
//	public void calResult(Button button) {
//		
//		String input = "";
//		
//		// 1. �Է°��� �ޱ�
//		for(int i=0; i<len; i++) {
//			if(inputStr[i]==null) {
//				// 2. �Է°��� ��ȿ�� �˻��ϱ� (ù��°�� ������ ����)  #######*1�ص� �˾Ƽ� 1�� ������ٰŴϱ� ���ص� �ǳ�..?
////				if(cal.numL.getText()==null) {
////					if(!isNumber(inputStr[i])) {
////						System.out.println("������ ���ڰ� �����ϴ�.");
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
//		// 2-1. c��,
//		// numL, openL�� ��� �� ��� �����
//		if(input.equals("C")) {
//			clear(cal.numL);
//			clear(cal.openL);
//		} 
//		// 2-2. ���� ���̸�,
//		// �Է°��� numL�� ����
//		else if(isNumber(input)) {
//			viewNumResult(input);
//		}
//		// 2-3. C, =�� ������ ������ ���̸�,
//		// �Է°��� openL�� ����
//		else {
//				viewOperResult(input);			
//		}
//			
//		// 3. numL���� openL�� �������Է°��� ����
//		
//		
//		// 4. ���� ����� numL�� ����
//	}
//
//	    // <numL�󺧿� ���� ���> �޼ҵ�
//		private void viewNumResult(String str) {
//			cal.numL.setText(str);
//		}
//		
//		// <openL�󺧿� ������ ���> �޼ҵ�
//		private void viewOperResult(String str) {
//			cal.openL.setText(str);
//		}
//		
//		// <���� ��� ���> �޼ҵ�
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
//			// �Է°����� ����� ���� �ؿ� �޼ҵ忡 �־�� ��!!!! #############################
//			
//			int l = str.length();
//			for(int i = 0; i<l; i++) {
//				result += str.charAt(i);
//			}
//			viewNumResult("");
//		}
//	
//		// <���ڰ��� ���ڿ��� ���> �޼ҵ�
//		private boolean isNumber(String str) {
//			boolean flag = true;
//			int len = str.length();
//			for(int i = 0; i <len ; i++) {
//				int x = str.charAt(i) - 48;  //x�� �ƽ�Ű �ڵ�
//				if(x < 0 || x > 9) {
//					flag = false;
//					break;
//				}
//			}	
//			return flag;
//		}
//		
//	// <ȭ�� �����> �޼ҵ�
//		private void clear(Object o) {
//			if(o == cal.numL)
//				cal.numL.setText("");
//			else
//				cal.openL.setText("");
//		}
//}
