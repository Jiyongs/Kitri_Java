package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//클래스, 조건문, 반복문
// 3 : cat
// 4 : dog
// 5 : lion
// 8 : tiger

public class Test1 {

// [필드]
	// 입력 값 객체 선언
	BufferedReader in;

//[생성자]
	public Test1() {
		// 입력 값 객체 생성
		in = new BufferedReader(new InputStreamReader(System.in));
	}

//[메소드]
	// 1) 입력값 리턴 메소드
	public int getNumber() {
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

	// [실행 메소드]
	public static void main(String[] args) {

		Test1 ex = new Test1();
		
		int countCat, countDog, countLion, countTiger;
		
		countCat = 0;
		countDog = 0;
		countLion = 0;
		countTiger = 0;
		

		System.out.print("입력 : ");
		int getNum = ex.getNumber();

		String result = ""; // 초기화

		System.out.println("==<<" + getNum + "회 반복 합니다>==");

		for (int i = 1; i <= getNum; i++) {

			if (i % 3 == 0) {
				countCat++;
				result += "cat ";
			}
			if (i % 4 == 0) {
				countDog++;
				result += "dog ";
			}
			if (i % 5 == 0) {
				countLion++;
				result += "lion ";
			}
			if (i % 8 == 0) {
				countTiger++;
				result += "tiger ";
			}

			System.out.println(i + ". " + result);
			result = ""; // 초기화
		}
		
		System.out.println("\n==<<Fruit Count List>>==");

		System.out.println("cat " + countCat +"회\ndog " + countDog + "회\nlion " + countLion + "회\ntiger " + countTiger + "회");

	}

}
