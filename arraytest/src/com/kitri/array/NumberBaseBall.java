package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.ISTORE;

/*
 *** ���� �߱� ***
0. com[], my[] 3�ڸ� �迭
1. com �� �ڸ� ���� �߻� (���� ���� ���ڸ���, �ٽ� ������ ��) >> comRandon() �޼ҵ�
2. 1�� ���ڴ� �ߺ� ���� X
                  0 ���� ���� X
3. ���� �Է��� 3�ڸ� ���ڸ� my[] �迭�� �ֱ�
4. com[]�� my[]�� ���ڿ� �ڸ��� �� >> index �̿�n  n 	xxx�� x��°���� �����Դϴ�.
			���(1), ����(0) : 
	6-2. strike�� 3�� �ƴ϶��,
			1. xxx�� x��Ʈ����ũ x���Դϴ�. >> 3������
 */

public class NumberBaseBall {
//[�ʵ�]
	private int my[];
	private int com[];
	
	BufferedReader in;
	
	private int count;
	private int strike;
	private int ball;
	
	int gameLength;  //���� ����

//[������]
	public NumberBaseBall() {
		//���� ���� ũ�� �ʱ�ȭ
		gameLength = 3;
		
		//�迭 ũ�� �ʱ�ȭ
		my = new int[gameLength];
		com = new int[gameLength];
		// ���� �߻�
		comRandom();
		// �Է°� �ޱ�����
		in = new BufferedReader(new InputStreamReader(System.in));
		
		count = 0;
		strike = 0;
		ball = 0;
	}
	
//[�޼ҵ�]
	//1) ���� �߻� �޼ҵ�
	private void comRandom() {
		//com �ʱ�ȭ
		for(int i = 0; i < gameLength; i++) {
			com[i] = 0;
		}
		
		//com�� ù ��° �ڸ��� 0�� �ƴ� ��
		com[0] = (int) ((Math.random() * 9) + 1);
		//com�� ������ �ڸ��� 0~9�� �� (�ߺ� X)
		do {
			com[1] = (int) (Math.random() * 10);
		}
		while (com[0] == com[1]);

		do {
			com[2] = (int) (Math.random() * 10);
		}
		while (com[0] == com[2] || com[1] == com[2]);
		

		//[�ӽ�] �� �̱� ó��
		String result = "";
		for(int i = 0; i<gameLength; i++) {
			result += com[i];
		}
		System.out.println("�� : " + result);
	}
	
	//2) ���� ���� �޼ҵ�
	private void game() {	
		while(true) {
			strike = 0;
			ball = 0;

			//my[] �Է¹���
			System.out.print("�����Է� : ");
			int myNum = getNumber();

			my[0] = myNum / 100 ;
			my[1] = (myNum%100) / 10;
			my[2] = myNum % 10;
			
			for (int i = 0; i < gameLength-1; i++) {
					if(my[i]==my[i+1])
						System.out.println("���� ���ڴ� �Է��� �� �����ϴ�.");
						continue; //while �������� �Ѿ
				}

			// ���ڿ� �ڸ��� ��
			for(int i = 0; i < gameLength; i++) {
				for(int j = 0; j < gameLength; j++) {
					//       i          j
					//my0, 1, 2 = com0
					//             = com1
					//             = com2
					if(my[i]==com[j]) {
						if(i == j)
							strike++;
						else
							ball++;
					} 
				}
			}
			
			//���ڿ� �ڸ��� ��(���� ���� ����) �� count ����!
			count++;
			
			// ��� ���	
			// ����!
			if(strike==3) {
			
				System.out.println(myNum + "�� " + count + "��°���� �����Դϴ�.");
				
				// �ٽ� ���� ����
				System.out.print("���(1), ����(0) : ");
				myNum = getNumber();
				if(myNum==1) {
					//�� ���� ��, �ʱ�ȭ
					count = 0;
					comRandom(); //com ���� �ʱ�ȭ
					game(); //�����
				}
				else {
					//���� ���� ��, �ʱ�ȭ
					System.out.println("������ �����մϴ�!");
					System.exit(0); //����
				}
				
			// ����!
			} else {		
				//xxx�� x��Ʈ����ũ x���Դϴ�. >> 3������
				System.out.println(count + ". " + myNum + "�� " + strike + "��Ʈ����ũ " + ball + "�� �Դϴ�.");
				game(); 
			}
						
		}
	}

	//3) �Է°� ���� �޼ҵ� (ȣ�� ��, ����ڰ� �Է��� ���ڸ� �� ���� ��ȯ����)
	private int getNumber() {
		int num = 0;
		try {
			num = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//[���� �޼ҵ�]
	public static void main(String[] args) {
		
		NumberBaseBall nbb = new NumberBaseBall();
		
		//���� ���� �޼ҵ� ȣ��
		nbb.game();
		
	}

}
