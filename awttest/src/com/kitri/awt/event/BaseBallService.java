package com.kitri.awt.event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// [���� Ŭ����]

// �̺�Ʈ �ҽ� : 6�� (��ư 5�� + �ؽ�Ʈ�ʵ� 1��)
// ��� �׼��̺�Ʈ

public class BaseBallService {

	// [�ʵ�]
	BaseBallController baseBallController;
	
	private FontColorChooser fcc;  //FontColorChooser�� �ּҰ��� ������ ����
	private BaseBall bb;               //BaseBall�� �ּҰ��� ������ ����

	private int my[];
	private int com[];
	int gameLength; // ���� ����
	int count; // ���� Ƚ�� ���������� ����
	Random random = new Random();
	
	int r, g, b;

	// [������]
	public BaseBallService(BaseBallController baseBallController) {
		this.baseBallController = baseBallController;
		
		fcc = baseBallController.baseBall.fontColorChooser;
		bb = baseBallController.baseBall;

		// ���� ���� ũ�� �ʱ�ȭ
		gameLength = 3;

		// �迭 ũ�� �ʱ�ȭ
		my = new int[gameLength];
		com = new int[gameLength];

		// �� ���� ���� �޼ҵ� ȣ��
		newGame();
	}
	
	// [�޼ҵ�]
	// **BaseBallâ ���
	// <�� ���� ����> �޼ҵ�
	public void newGame() {

		// *com[] ���� �߻�
		// com[]�� �� �ڸ� ���� ����
		com[0] = random.nextInt(9) + 1; // com�� ù ��° �ڸ��� 0�� �ƴ� ��

		do { // com�� ������ �ڸ��� 0~9�� �� (�ߺ� X)
			com[1] = random.nextInt(10);
		} while (com[0] == com[1]);

		do {
			com[2] = random.nextInt(10);
		} while (com[0] == com[2] || com[1] == com[2]);

		// *�� ���� ȭ�� ����
		//TextField ��� ���� Ǯ��
		bb.tf.setEnabled(true);
		//ȭ�� �����, �� ���� �˸�
		clear();  
		viewResult("���ο� ������ �����մϴ�.");

		// *count �ʱ�ȭ
		count = 0;

		// [�ӽ�] �� �̱� ó��
		System.out.println("�� : " + com[0] + com[1] + com[2]);

	}

	// <ȭ�� �����> �޼ҵ�
	public void clear() {
		bb.ta.setText(" ");
	}

	// <�� ���> �޼ҵ�
	public void showDap() {
		viewResult("������ " + com[0] + com[1] + com[2] + "�Դϴ�.");

		// *�� ��� ��, ��� ����
		viewResult("������ �Ǵ� ���Ḧ �����ּ���!");
		bb.tf.setEnabled(false);
	}

	// <���� ���� ���� â ȣ��> �޼ҵ�
	public void fontColorChange() {
		// *FontColorChooserâ ��ü�� setVisible�� ����
		fcc.setVisible(true);
		changeColor();
	}

	// <���α׷� ����> �޼ҵ�
	public void exit() {
		System.exit(0);
	}

	// <���� ����> �޼ҵ�
	public void game() {
		int strike = 0;
		int ball = 0;

		// *�Է°� �ޱ�
		String myNumStr = bb.tf.getText().trim();
		bb.tf.setText("");  //�Է°� ������ �ٷ� �����

		for (int i = 0; i < gameLength; i++) {
			my[i] = myNumStr.charAt(i) - 48; // myNumStr.charAt(i)�� char�̹Ƿ�, asciicode�� 0(48)���� ����
		}
		
		// *�Է°��� ��ȿ�� �˻�
		// ���� �Է½� ��� �˸�
		//�ƹ��͵� �Է� �� �� != null �̹Ƿ�, null�� �ʿ� ����
		if(myNumStr.length() != gameLength) {
			viewResult("3�ڸ� ���ڸ� �Է��ϼ���!!!!");
		}
		
		// ���ڰ� �ƴ� �� �Է½� ��� �˸�
		if(!isNumber(myNumStr)) {
			viewResult("���ڸ� �Է��ϼ���!!!!");
			return;
		}
		
		// *�Է°��� ������ ��
		// ���ڿ� �ڸ��� ��
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
		//*���ڿ� �ڸ��� ��(���� ���� ����) �� count ����!
		count++;
		
		//��Ʈ����ũ�� �ƴ� ���
		if(strike != gameLength) {
			viewResult(count + ". " + myNumStr + "�� " + strike + "��Ʈ����ũ " + ball + "�� �Դϴ�.");
		} else {
			viewResult(myNumStr + "�� " + count + "��°���� �����Դϴ�.");
			viewResult("������ �Ǵ� ���Ḧ �����ּ���!");
			bb.tf.setEnabled(false);
			
		}

	}
	
	// <TextArea�� �޼��� ���> �޼ҵ�
	private void viewResult(String msg) {
		bb.ta.append(msg + "\n");
	}
	
	// <���ڰ��� ���ڿ��� ���> �޼ҵ�
	private boolean isNumber(String str) {
		boolean flag = true;
		
		for(int i = 0; i < gameLength; i++) {
			int x = str.charAt(i) - 48;  //x�� �ƽ�Ű �ڵ�
			if(x < 0 || x > 9) {
				flag = false;
				break;
			}
		}	
		return flag;
	}
	
	// <����â���� ������ ������ �۾� �� ����> �޼ҵ�
	public void selectColor() {
		// BaseBallâ�� TextArea�� ���� ���� ����
		bb.ta.setForeground(new Color(r, g, b));
		// FontColorChooserâ �ݱ�
		fcc.setVisible(false);
	}
	
	// **FontColorChooserâ ���
	// <����â�� ���� ����> �޼ҵ�
	public void changeColor() {
		r = fcc.sbR.getValue();
		g = fcc.sbG.getValue();
		b = fcc.sbB.getValue();
				
		fcc.colorP.setBackground(new Color(r, g, b));
		fcc.colorL.setText("r = " + r + "g = " + g + "b = " + b);
	}
	
}
