package com.kitri.awt.event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// [로직 클래스]

// 이벤트 소스 : 6개 (버튼 5개 + 텍스트필드 1개)
// 모두 액션이벤트

public class BaseBallService {

	// [필드]
	BaseBallController baseBallController;
	
	private FontColorChooser fcc;  //FontColorChooser의 주소값을 저장할 변수
	private BaseBall bb;               //BaseBall의 주소값을 저장할 변수

	private int my[];
	private int com[];
	int gameLength; // 게임 숫자
	int count; // 게임 횟수 전역변수로 지정
	Random random = new Random();
	
	int r, g, b;

	// [생성자]
	public BaseBallService(BaseBallController baseBallController) {
		this.baseBallController = baseBallController;
		
		fcc = baseBallController.baseBall.fontColorChooser;
		bb = baseBallController.baseBall;

		// 게임 숫자 크기 초기화
		gameLength = 3;

		// 배열 크기 초기화
		my = new int[gameLength];
		com = new int[gameLength];

		// 새 게임 시작 메소드 호출
		newGame();
	}
	
	// [메소드]
	// **BaseBall창 기능
	// <새 게임 시작> 메소드
	public void newGame() {

		// *com[] 정답 발생
		// com[]에 세 자리 난수 저장
		com[0] = random.nextInt(9) + 1; // com의 첫 번째 자리는 0이 아닌 수

		do { // com의 나머지 자리는 0~9의 수 (중복 X)
			com[1] = random.nextInt(10);
		} while (com[0] == com[1]);

		do {
			com[2] = random.nextInt(10);
		} while (com[0] == com[2] || com[1] == com[2]);

		// *새 게임 화면 조정
		//TextField 사용 제한 풀기
		bb.tf.setEnabled(true);
		//화면 지우고, 새 게임 알림
		clear();  
		viewResult("새로운 게임을 시작합니다.");

		// *count 초기화
		count = 0;

		// [임시] 답 뽑기 처리
		System.out.println("답 : " + com[0] + com[1] + com[2]);

	}

	// <화면 지우기> 메소드
	public void clear() {
		bb.ta.setText(" ");
	}

	// <답 출력> 메소드
	public void showDap() {
		viewResult("정답은 " + com[0] + com[1] + com[2] + "입니다.");

		// *답 출력 후, 기능 막기
		viewResult("새게임 또는 종료를 눌러주세요!");
		bb.tf.setEnabled(false);
	}

	// <글자 색상 변경 창 호출> 메소드
	public void fontColorChange() {
		// *FontColorChooser창 객체의 setVisible을 조절
		fcc.setVisible(true);
		changeColor();
	}

	// <프로그램 종료> 메소드
	public void exit() {
		System.exit(0);
	}

	// <게임 진행> 메소드
	public void game() {
		int strike = 0;
		int ball = 0;

		// *입력값 받기
		String myNumStr = bb.tf.getText().trim();
		bb.tf.setText("");  //입력값 얻어오고 바로 지우기

		for (int i = 0; i < gameLength; i++) {
			my[i] = myNumStr.charAt(i) - 48; // myNumStr.charAt(i)은 char이므로, asciicode의 0(48)값을 빼줌
		}
		
		// *입력값의 유효성 검사
		// 공백 입력시 경고 알림
		//아무것도 입력 안 함 != null 이므로, null비교 필요 없음
		if(myNumStr.length() != gameLength) {
			viewResult("3자리 숫자를 입력하세요!!!!");
		}
		
		// 숫자가 아닌 값 입력시 경고 알림
		if(!isNumber(myNumStr)) {
			viewResult("숫자만 입력하세요!!!!");
			return;
		}
		
		// *입력값과 정답의 비교
		// 숫자와 자릿수 비교
		for (int i = 0; i < gameLength; i++) {
			for (int j = 0; j < gameLength; j++) {
				if (my[i] == com[j]) {
					if (i == j)
						strike++;
					else
						ball++;
				}
			}
		}
		//*숫자와 자릿수 비교(게임 정상 구동) 후 count 증가!
		count++;
		
		//스트라이크가 아닌 경우
		if(strike != gameLength) {
			viewResult(count + ". " + myNumStr + "는 " + strike + "스트라이크 " + ball + "볼 입니다.");
		} else {
			viewResult(myNumStr + "은 " + count + "번째만에 정답입니다.");
			viewResult("새게임 또는 종료를 눌러주세요!");
			bb.tf.setEnabled(false);
			
		}

	}
	
	// <TextArea에 메세지 출력> 메소드
	private void viewResult(String msg) {
		bb.ta.append(msg + "\n");
	}
	
	// <인자값의 숫자여부 출력> 메소드
	private boolean isNumber(String str) {
		boolean flag = true;
		
		for(int i = 0; i < gameLength; i++) {
			int x = str.charAt(i) - 48;  //x는 아스키 코드
			if(x < 0 || x > 9) {
				flag = false;
				break;
			}
		}	
		return flag;
	}
	
	// <색상창에서 설정한 색으로 글씨 색 변경> 메소드
	public void selectColor() {
		// BaseBall창의 TextArea의 글자 색상 변경
		bb.ta.setForeground(new Color(r, g, b));
		// FontColorChooser창 닫기
		fcc.setVisible(false);
	}
	
	// **FontColorChooser창 기능
	// <색상창의 색상 변경> 메소드
	public void changeColor() {
		r = fcc.sbR.getValue();
		g = fcc.sbG.getValue();
		b = fcc.sbB.getValue();
				
		fcc.colorP.setBackground(new Color(r, g, b));
		fcc.colorL.setText("r = " + r + "g = " + g + "b = " + b);
	}
	
}
