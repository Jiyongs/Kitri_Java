package kitri.com.awt.event;

import java.awt.Checkbox;
import java.awt.event.*;

// [[Item���� ���� ó�� Ŭ����]]

public class ItemLogic implements ItemListener, ActionListener {
	
		//ItemText it = new ItemText();
		//ItemText it;
	
		ItemText itemTest;
	
		// [������]
		public ItemLogic(ItemText itemTest) {
			//������ Ŭ������ ��ü�� �޾ƿ�
			this.itemTest = itemTest;
		}
	
		// <action �߻� �̺�Ʈ> : Button
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

		// <item ���� ��ȭ �̺�Ʈ> : Checkbox, Choice
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			//Ư�� �̺�Ʈ �ҽ��� ������ �̺�Ʈ ������ �ٸ� �� if ���!
			// �̺�Ʈ �ҽ��� �� ��ü�� �ּҰ� = e.getSource()      //Object - EventObject - AWTEvent - ItemEvent���� EventObject�� �޼ҵ���
			// if1 ) **�̺�Ʈ �ҽ��� Choice�� ��**
			Object ob = e.getSource();  //�̺�Ʈ �ҽ��� �� ��ü�� �ּҰ�
			if(ob == itemTest.ch ) {
				String str = itemTest.ch.getSelectedItem();
				if(str.equals("��ħ")) {
					itemTest.mor.setState(true);
				} else if(str.equals("����")) {
					itemTest.aft.setState(true);
				} else if(str.equals("����")) {
					itemTest.eve.setState(true);
				}
			}
			
			//**�̺�Ʈ �ҽ��� ��� ������Ʈ�� ��**
			Checkbox sel = itemTest.chg.getSelectedCheckbox(); //sel = ���õ� üũ�ڽ��� �ּҰ�
			String selstr = sel.getLabel(); //selstr = ���õ� üũ�ڽ��� �ּҰ��� ����Ű�� �󺧰�
			//System.out.println(selstr);
			
			itemTest.ta.setText("--- " + selstr + " ---" +"\n");                         //TextArea - setText(String str) : TextArea�� ��� �ؽ�Ʈ�� str�� ����
			itemTest.ta.append("1. ��� : " + eat(itemTest.app.getState()) + "\n");          //TextArea - append(String str) : TextArea�� ���� �ؽ�Ʈ���� str�� ����
			itemTest.ta.append("2. �ٳ��� : " + eat(itemTest.banana.getState()) +"\n");
			itemTest.ta.append("3. ���� : " + eat(itemTest.straw.getState()) +"\n");
			
			itemTest.ch.select(selstr); // 'Choice' - select(String str) : str�� �ش��ϴ� item�� ����
			
		}
		
		// <���� ���� ��� �޼ҵ�>
		private String eat(boolean flag) {
			return flag ? "�Ծ���." : "�� �Ծ���.";
		}
}
