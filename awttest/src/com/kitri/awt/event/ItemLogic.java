package com.kitri.awt.event;

import java.awt.Checkbox;
import java.awt.event.*;

// [[Item예제 로직 처리 클래스]]

public class ItemLogic implements ItemListener, ActionListener {
	
		//ItemText it = new ItemText();
		//ItemText it;
	
		ItemText itemTest;
	
		// [생성자]
		public ItemLogic(ItemText itemTest) {
			//디자인 클래스의 객체를 받아옴
			this.itemTest = itemTest;
		}
	
		// <action 발생 이벤트> : Button
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

		// <item 상태 변화 이벤트> : Checkbox, Choice
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			//특정 이벤트 소스에 적용할 이벤트 내용이 다를 때 if 사용!
			// 이벤트 소스가 된 객체의 주소값 = e.getSource()      //Object - EventObject - AWTEvent - ItemEvent에서 EventObject의 메소드임
			// if1 ) **이벤트 소스가 Choice일 때**
			Object ob = e.getSource();  //이벤트 소스가 된 객체의 주소값
			if(ob == itemTest.ch ) {
				String str = itemTest.ch.getSelectedItem();
				if(str.equals("아침")) {
					itemTest.mor.setState(true);
				} else if(str.equals("점심")) {
					itemTest.aft.setState(true);
				} else if(str.equals("저녁")) {
					itemTest.eve.setState(true);
				}
			}
			
			//**이벤트 소스가 모든 컴포넌트일 때**
			Checkbox sel = itemTest.chg.getSelectedCheckbox(); //sel = 선택된 체크박스의 주소값
			String selstr = sel.getLabel(); //selstr = 선택된 체크박스의 주소값이 가리키는 라벨값
			//System.out.println(selstr);
			
			itemTest.ta.setText("--- " + selstr + " ---" +"\n");                         //TextArea - setText(String str) : TextArea의 모든 텍스트를 str로 설정
			itemTest.ta.append("1. 사과 : " + eat(itemTest.app.getState()) + "\n");          //TextArea - append(String str) : TextArea의 기존 텍스트에다 str을 더함
			itemTest.ta.append("2. 바나나 : " + eat(itemTest.banana.getState()) +"\n");
			itemTest.ta.append("3. 딸기 : " + eat(itemTest.straw.getState()) +"\n");
			
			itemTest.ch.select(selstr); // 'Choice' - select(String str) : str에 해당하는 item을 선택
			
		}
		
		// <먹음 여부 출력 메소드>
		private String eat(boolean flag) {
			return flag ? "먹었다." : "안 먹었다.";
		}
}
