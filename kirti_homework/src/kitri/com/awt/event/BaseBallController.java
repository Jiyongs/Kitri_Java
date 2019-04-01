package kitri.com.awt.event;

import java.awt.event.*;

//[컨트롤러 클래스] : 메소드를 언제 사용해라. 신호등 역할.
//BaseBall, FontColorChooser의 리스너 정의

public class BaseBallController implements ActionListener, AdjustmentListener {

	// ###디자인의 호출###
	// 디자인->컨트롤러
	BaseBall baseBall;
	
	// ###로직을 호출###
	// 컨트롤러 -> 로직
	BaseBallService baseballService;

	// ###디자인의 호출###
	// ###로직을 호출###
	public BaseBallController(BaseBall baseBall) {
		this.baseBall = baseBall;   						//디자인 객체->컨트롤러 (저장)
		baseballService = new BaseBallService(this); //컨트롤러의 디자인 객체 -> 로직 (전달)
	}

	
	// ###로직에 분리된 메소드 호출###
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

}