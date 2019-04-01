package com.kitri.awt.event;

import java.awt.event.*;

// [��Ʈ�ѷ� Ŭ����] : �޼ҵ带 ���� ����ض�. ��ȣ�� ����.
// BaseBall, FontColorChooser�� ������ ����

public class BaseBallController extends WindowAdapter implements ActionListener, AdjustmentListener {

	// ###�������� ȣ��###
	// ������->��Ʈ�ѷ�
	BaseBall baseBall;
	
	// ###������ ȣ��###
	// ��Ʈ�ѷ� -> ����
	BaseBallService baseballService;

	// ###�������� ȣ��###
	// ###������ ȣ��###
	public BaseBallController(BaseBall baseBall) {
		this.baseBall = baseBall;   						//������ ��ü->��Ʈ�ѷ� (����)
		baseballService = new BaseBallService(this); //��Ʈ�ѷ��� ������ ��ü -> ���� (����)
	}

	
	// ###������ �и��� �޼ҵ� ȣ��###
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == baseBall.newG) {
			baseballService.newGame();
		} else if(ob == baseBall.clear) {
			baseballService.clear();
		} else if(ob == baseBall.dap) {
			baseballService.showDap();
		}else if(ob==baseBall.fontC){
			baseballService.fontColorChange();
		}else if(ob==baseBall.exit){
			baseballService.exit();
		}else if(ob==baseBall.tf){
			baseballService.game();
		}else if(ob==baseBall.fontColorChooser.ok) {
			baseballService.selectColor();
		}
}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {	
		baseballService.changeColor();
	}

	// ��ӹ��� WindowAdapter�� �޼ҵ� �� �ϳ� �̻� override
	// <â �ݱ�> �޼ҵ�
	@Override
	public void windowClosing(WindowEvent e) {
		
		baseballService.exit();
	}

}
