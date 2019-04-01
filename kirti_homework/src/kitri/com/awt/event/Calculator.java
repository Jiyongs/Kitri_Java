package kitri.com.awt.event;

import java.awt.*;

//[**디자인 클래스**]

//과제 내용
//1. 한 자리 숫자의 계산     - 백업
//화면 : 5 *
//입력 : 5
//   =누르면 화면 : 25

//2. 여러 자리 숫자의 계산
//화면 : 25 *
//입력 : 4
// =누르면 화면 : 100

public class Calculator extends Frame {

	// [필드/선언부]
	
	Panel pN = new Panel();
	Panel pC = new Panel();

	Label numL = new Label("0");                      //숫자만
	Label operL = new Label("     ", Label.CENTER);   //연산자만

	Button btn[] = new Button[16];
	String str[] = { "7", "8", "9", "+",
						"4", "5", "6", "-",
						"1", "2", "3", "*",
						"0", "C", "=", "/" };

	Button exit = new Button("종  료");
	
	Color labelColor = Color.BLACK;
	Color textColor = Color.WHITE;

	Font textfont = new Font("맑은 고딕", Font.BOLD, 50);
	
	CalculatorController calculatorController; // CalculatorController 객체 주소
	
	// [생성자/배치부]
	public Calculator() {
		// <pN : 위쪽 패널>
		numL.setBackground(labelColor);
		numL.setForeground(textColor);
		numL.setFont(textfont);
		operL.setBackground(labelColor);
		operL.setForeground(textColor);
		operL.setFont(textfont);

		pN.setLayout(new BorderLayout(10, 10));
		pN.add(numL, "Center");
		pN.add(operL, "East");

		// <pC : 가운데 패널>
		pC.setLayout(new GridLayout(4, 4));
		int len = btn.length;
		int j = 50;
		for (int i = 0; i < len; i++) {
			btn[i] = new Button(str[i]);
			btn[i].setBackground(new Color(j, 127, 127));
			btn[i].setForeground(textColor);
			btn[i].setFont(textfont);
			pC.add(btn[i]);
			j+=10;
		}
	
		
		// <프레임>
		setLayout(new BorderLayout(20, 20));
		add(pN, "North");
		add(pC, "Center");
		add(exit, "South");		
		
		///////////////////////////// 메모리상의 Frame 배치 완료//////////////////////////

		setBounds(300, 200, 400, 600);
		setVisible(true);
		
		// ***이벤트 리스너 등록***
		calculatorController = new CalculatorController(this);
		//계산기 버튼 16개
		for(int i = 0; i<16; i++) {
			btn[i].addActionListener(calculatorController);
		}
		//종료 버튼 1개
		exit.addActionListener(calculatorController);
	}

	// [메소드/구현부]
	
	// [실행 메소드/main]
	public static void main(String[] args) {

		new Calculator();

	}

}
