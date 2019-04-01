package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.sun.org.apache.bcel.internal.generic.ISTORE;

/*
 *** 숫자 야구 ***
0. com[], my[] 3자리 배열
1. com 세 자리 난수 발생 (게임 시작 하자마자, 다시 시작할 때) >> comRandon() 메소드
2. 1의 숫자는 중복 숫자 X
                  0 으로 시작 X
3. 내가 입력한 3자리 숫자를 my[] 배열에 넣기
4. com[]과 my[]의 숫자와 자릿수 비교 >> index 이용n  n 	xxx는 x번째만에 정답입니다.
			계속(1), 종료(0) : 
	6-2. strike가 3이 아니라면,
			1. xxx는 x스트라이크 x볼입니다. >> 3번으로
 */

public class NumberBaseBall {
//[필드]
	private int my[];
	private int com[];
	
	BufferedReader in;
	
	private int count;
	private int strike;
	private int ball;
	
	int gameLength;  //게임 숫자

//[생성자]
	public NumberBaseBall() {
		//게임 숫자 크기 초기화
		gameLength = 3;
		
		//배열 크기 초기화
		my = new int[gameLength];
		com = new int[gameLength];
		// 난수 발생
		comRandom();
		// 입력값 받기위함
		in = new BufferedReader(new InputStreamReader(System.in));
		
		count = 0;
		strike = 0;
		ball = 0;
	}
	
//[메소드]
	//1) 난수 발생 메소드
	private void comRandom() {
		//com 초기화
		for(int i = 0; i < gameLength; i++) {
			com[i] = 0;
		}
		
		//com의 첫 번째 자리는 0이 아닌 수
		com[0] = (int) ((Math.random() * 9) + 1);
		//com의 나머지 자리는 0~9의 수 (중복 X)
		do {
			com[1] = (int) (Math.random() * 10);
		}
		while (com[0] == com[1]);

		do {
			com[2] = (int) (Math.random() * 10);
		}
		while (com[0] == com[2] || com[1] == com[2]);
		

		//[임시] 답 뽑기 처리
		String result = "";
		for(int i = 0; i<gameLength; i++) {
			result += com[i];
		}
		System.out.println("답 : " + result);
	}
	
	//2) 게임 시작 메소드
	private void game() {	
		while(true) {
			strike = 0;
			ball = 0;

			//my[] 입력받음
			System.out.print("숫자입력 : ");
			int myNum = getNumber();

			my[0] = myNum / 100 ;
			my[1] = (myNum%100) / 10;
			my[2] = myNum % 10;
			
			for (int i = 0; i < gameLength-1; i++) {
					if(my[i]==my[i+1])
						System.out.println("같은 숫자는 입력할 수 없습니다.");
						continue; //while 다음으로 넘어감
				}

			// 숫자와 자릿수 비교
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
			
			//숫자와 자릿수 비교(게임 정상 구동) 후 count 증가!
			count++;
			
			// 결과 출력	
			// 정답!
			if(strike==3) {
			
				System.out.println(myNum + "은 " + count + "번째만에 정답입니다.");
				
				// 다시 시작 묻기
				System.out.print("계속(1), 종료(0) : ");
				myNum = getNumber();
				if(myNum==1) {
					//재 시작 전, 초기화
					count = 0;
					comRandom(); //com 숫자 초기화
					game(); //재시작
				}
				else {
					//게임 종료 시, 초기화
					System.out.println("게임을 종료합니다!");
					System.exit(0); //종료
				}
				
			// 오답!
			} else {		
				//xxx는 x스트라이크 x볼입니다. >> 3번으로
				System.out.println(count + ". " + myNum + "는 " + strike + "스트라이크 " + ball + "볼 입니다.");
				game(); 
			}
						
		}
	}

	//3) 입력값 리턴 메소드 (호출 시, 사용자가 입력한 숫자를 한 번씩 반환받음)
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
//[실행 메소드]
	public static void main(String[] args) {
		
		NumberBaseBall nbb = new NumberBaseBall();
		
		//게임 시작 메소드 호출
		nbb.game();
		
	}

}
