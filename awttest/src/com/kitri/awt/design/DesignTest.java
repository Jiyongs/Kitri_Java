package com.kitri.awt.design;

import java.awt.*;

// 1. Frame 상속
// 2. 선언부에 필요한 객체 생성.
// 3. 배치부(생성자)에서 design (=component 배치)

// *** 항상 작업은 소 >> 대 순서로 진행하자

public class DesignTest extends Frame {
	
//[선언부] : 필요한 객체 선언
	Panel pN = new Panel();  				// Panel : 일반적으로 선언부에는, Panel() 사용함! (배치부에서 Layout 설정)
	Panel pS = new Panel();
	
	Label l = new Label("입력", Label.CENTER); 	 // Label : Label("문자열"); 사용이 편함!
	TextField tf = new TextField();
	Button send = new Button("전송"); 	//Button : Button("문자열");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice(); 				//Choice : Choice() 밖에 없음. 안의 항목은 메소드 이용해야 함!
	Button exit = new Button("종료");
 	
	
	public DesignTest() {
	//[배치부] : 객체의 배치
		
		// <프레임>
		super("Design Test !!!");              //Frame("창제목") : 상위 클래스인 Frame 생성자를 호출하여, 프레임의 제목 지정
		
		// <위쪽 패널>
		//pN.setLayout(new FlowLayout());  // Panel의 디폴트 레이아웃이 Flow이므로, 지정 X
		
		//LayoutManager lm = new BorderLayout(); // Border레이아웃 객체를 굳이 만들지 않고,
		pN.setLayout(new BorderLayout(10, 0));     // 익명 객체로 지정 가능!  //BorderLayout(int hgap, int vgqp)
		l.setBackground(new Color(210, 230, 150)); // setBackground(Color c) : 컴포넌트의 배경을 Color(double r, double g, double v)로 지정
//		l.setForeground(new Color(255, 255, 255)); // setForeground(Color c) : 컴포넌트의 배경의 앞부분을 Color 객체로 지정
		l.setForeground(Color.ORANGE); // setForeground(Color c) : 컴포넌트의 배경의 앞부분을 Color 객체로 지정
		Font f = new Font("굴림", Font.BOLD, 20); // Font(String name, int style, int size)
		l.setFont(f);    // setFont(Font f);
		pN.add(l, "West");
		pN.add(tf, "Center");
		pN.add(send, "East");
		
		// <아래쪽 패널>
		pS.setLayout(new GridLayout(1, 2, 10, 0));   //GridLayout(int rows, int cols, int hgap, int vgap)사용
		ch.add("서울"); //add() : Choice에 항목 넣기
		ch.add("경기");
		ch.add("인천");
		ch.add("강원");
		ch.add("춘천");
		pS.add(ch);
		pS.add(exit);
		
		// <전체>
		//Frame의 디폴트 레이아웃이 Border이므로, 지정 X
		setLayout(new BorderLayout(0, 10));  //Border의 다른 생성자 이용을 위해 setLayout해줌 //setLayout(LayoutManager lm)   //BorderLayout(int hgap, int vgap)
		add(pN, "North");
		add(ta, "Center");
		add(pS, "South");
		
		/////////////////////////////메모리상의 Frame 배치 완료//////////////////////////
		
		setSize(300, 400); //Frame의 크기 지정
		setLocation(300, 200); //Frame의 첫 위치 지정
		
		setBounds(300, 200, 300, 500); //setBounds(int x, int y, int width, int height) : 위치, 크기 한 방에 지정
		setResizable(false);  //setResizable(boolean b) : Frame의 크기 조정 허가 여부 지정
		setVisible(true);    //배치 완료된 Frame을 보이게 하기  ***항상 배치부의 마지막

	}
	
	public static void main(String[] args) {
		new DesignTest();  // 객체 사용할 일이 없으므로, 익명 생성자를 호출!
	}
	
}
