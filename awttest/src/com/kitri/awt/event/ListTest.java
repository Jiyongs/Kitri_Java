package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 이벤트 소스 : 6개 (버튼 4개 + 텍스트필드 2개)
// 버튼, 텍스트필드 액션이벤트

// *과제 : 리스트 값을 다중선택 가능하게 해서, 선택한 항목을 옮기게 하기!!! (완료)

public class ListTest extends Frame implements ActionListener {
	
	Panel pL = new Panel();
	Panel pC = new Panel();
	Panel pR = new Panel();

	List listL = new List(20, true);             //List(int index, boolean mutipleMode) *멀티플모드 : 다중 선택 가능
	TextField tfL = new TextField();
	
	Button btR = new Button("▷");
	Button btRAll = new Button("▶");
	Button btL = new Button("◁");
	Button btLAll = new Button("◀");

	List listR = new List(20, true);
	TextField tfR = new TextField();

	public ListTest() {
		super("리스트 테스트");
		// <pL 패널>
		listL.setBackground(Color.WHITE);
		tfL.setBackground(Color.GREEN);
		pL.setLayout(new BorderLayout(0, 10));
		pL.add(listL, "Center");
		pL.add(tfL, "South");
	
		// <pC 패널>
		pC.setLayout(new GridLayout(6, 1, 0, 20));
		pC.add(new Label());
		pC.add(btR);
		pC.add(btRAll);
		pC.add(btL);
		pC.add(btLAll);
//		pC.add(new Label());  //GridLayout은 만들어진 칸에 컴포넌트가 없어도 자리를 차지한 후 그 곳을 비워둠
	
		// <pR 패널>
		listR.setBackground(Color.WHITE);
		tfR.setBackground(Color.GREEN);
		pR.setLayout(new BorderLayout(0, 10));
		pR.add(listR, "Center");
		pR.add(tfR, "South");
		
		// <전체>
		// Frame의 디폴트 레이아웃이 Border이므로, 지정 X
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(1, 3, 10, 0));
		add(pL);
		add(pC);
		add(pR);

		///////////////////////////// 메모리상의 Frame 배치 완료//////////////////////////
		
		setBounds(300, 200, 300, 500); // setBounds(int x, int y, int width, int height) : 위치, 크기 한 방에 지정
		setVisible(true); // 배치 완료된 Frame을 보이게 하기 ***항상 배치부의 마지막

		// 000Listener에 컴포넌트를 등록
		tfL.addActionListener(this);
		tfR.addActionListener(this);
		btL.addActionListener(this);
		btLAll.addActionListener(this);
		btR.addActionListener(this);
		btRAll.addActionListener(this);
		
	}

	public static void main(String[] args) {
		new ListTest();
	}

	//[구현부] : 기능 메소드 구현
	// 우리가 호출할 수 없는 메소드 // 리스너에 등록해야 함
	
	// <action 발생 이벤트> : Button, TextField
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();
		// 1~6) **이벤트 소스가 각각의 컴포넌트일 때**
		if(ob == tfL) {
			//1. tfL의 값을 get (유효성 검사 = 빈 값이면 입력안되게 하기)
			String temp = tfL.getText().trim();    //trim() : 공백제거
			tfL.setText("");        //TextField에 입력된 값을 지우는 용도
			if(temp.isEmpty())                       //isEmpty() : 유효성 검사
				return;            //이 메소드를 호출한 리스너로 돌아감 = 리스너에게 다시 감시해라! (메소드 중지)
			//2. listL에 추가
			listL.add(temp);
		} else if (ob == tfR) {
			String temp = tfR.getText().trim(); 
			tfR.setText("");  
			if(temp.isEmpty()) 
				return;
			listR.add(temp);
		} else if (ob == btL ) {
			String temp[] = listR.getSelectedItems();
			if(temp==null) 
				return;
			int len = temp.length;
			for (int i = 0; i < len; i++) {
				listL.add(temp[i]);
				listR.remove(temp[i]);
			}
		} else if (ob == btLAll) {
			String temp[] = listR.getItems();
			int len = temp.length;
			for (int i = 0; i < len; i++) {
				listL.add(temp[i]);
			}	
			for (int i = len-1 ; i >= 0; i--) {   
				listR.remove(i);
			}
		} else if (ob == btR) {
			//1. listL에서 선택한 문자열 get (유효성 검사 = 리스트에서 선택된 것이 없을 때 에러 방지)
			String temp[] = listL.getSelectedItems();
			if(temp==null)      //유효성 검사
				return;
			//2. 1의 값을 listR에 추가.
			//3. 1의 값을 listL에서 제거.
			int len = temp.length;
			for (int i = 0; i < len; i++) {
				listR.add(temp[i]);
				listL.remove(temp[i]);	
			}
		} else if (ob == btRAll) {
			//1. listL의 값을 모두 get (유효성 검사)
			String temp[] = listL.getItems();
			//2. 1의 값을 listR에 모두 추가
			int len = temp.length;
			for (int i = 0; i < len; i++) {
				listR.add(temp[i]);
			}
			//3. 1의 값을 listL에서 모두 제거   //배열의 index를 이용하여 모든 값을 지울 때, 0부터 시작하면,
			                                          //배열의 크기가 변하기 때문에,
			                                          //위의 listL 항목을 지우는 for문에서 배열의 크기에서 NullPointException 발생! ...문제
			                                          //따라서, idext를 이용한 배열의 값 제거는 거꾸로 하자			
			for (int i = len-1 ; i >= 0; i--) {   
				listL.remove(i);
			}
			// listL.removeAll();
			
		}
		
	}

}
