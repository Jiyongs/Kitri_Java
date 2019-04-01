package kitri.com.awt.event;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class FontColorChooser extends Frame {

	Panel pL = new Panel();
	Panel pLL = new Panel();
	Panel pLR = new Panel();
	Panel pLC = new Panel();
	
	Panel pR = new Panel();
	Panel pRS = new Panel();
	
	Panel colorP = new Panel();

	Label l1 = new Label();
	Label l2 = new Label();
	
	Label lR = new Label("����");
	Label lG = new Label("�ʷ�");
	Label lB = new Label("�Ķ�");
	Scrollbar sbR = new Scrollbar(Scrollbar.HORIZONTAL, 265/2-5, 10, 0, 265);
	Scrollbar sbG = new Scrollbar(Scrollbar.HORIZONTAL, 265/2-5, 10, 0, 265);
	Scrollbar sbB = new Scrollbar(Scrollbar.HORIZONTAL, 265/2-5, 10, 0, 265);

	Label colorL = new Label();
	Button ok = new Button("Ȯ��");
	
	public FontColorChooser() {

		// <���� ����>
		colorP.setBackground(Color.ORANGE);
		colorL.setBackground(Color.GREEN);

		// <pLL �г�>
		pLL.setLayout(new GridLayout(3,1, 0, 10));
		lR.setBackground(Color.RED);
		lG.setBackground(Color.GREEN);
		lB.setBackground(Color.BLUE);
		pLL.add(lR);
		pLL.add(lG);
		pLL.add(lB);
		// <pLR �г�>
		pLR.setLayout(new GridLayout(3, 1, 0, 10));
		pLR.add(sbR);
		pLR.add(sbG);
		pLR.add(sbB);
		// <pLC �г�>
		pLC.setLayout(new BorderLayout());
		pLC.add(pLL, "West");
		pLC.add(pLR, "Center");
		// <pL �г�>
		pL.setLayout(new BorderLayout());
		pL.add(l1, "North");
		pL.add(l2, "South");
		pL.add(pLC, "Center");

		// <pRS �г�>
		pRS.setLayout(new BorderLayout());
		pRS.add(colorL, "Center");
		pRS.add(ok, "East");
		
		// <pR �г�>
		pR.setLayout(new BorderLayout(0, 10));
		pR.add(colorP);
		pR.add(pRS, "South");
		

		// <������>
		setLayout(new GridLayout(1, 2));
		add(pL);
		add(pR);
		
		///////////////////////////// �޸𸮻��� Frame ��ġ �Ϸ�//////////////////////////

		setBounds(300, 200, 500, 250); // setBounds(int x, int y, int width, int height) : ��ġ, ũ�� �� �濡 ����
		// ###setVisible() ���־� ��!###
		
		// 000Listener�� ������Ʈ�� ���
		// ###�̰� �����θ޼ҵ�� �ű�###

	}

}

