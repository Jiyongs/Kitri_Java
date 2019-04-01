package day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	4번 문제 : 중첩된 제어문
*/

public class Test4 {

// [메소드]
	//결과 구하기 메소드
	public String result(int number) {
		String result;
		if(number < 0) {
			result = "0 미만";
		}
		else {
			if(number<=10) {
				result = "10 이하 0 초과";
			}
			else {
				result = "10 초과";
			}
		}
		return result;
	}
	
//////////////////////////////////////////////////////////////////////////////////////
//[실행 메소드]
	public static void main(String[] args) throws Exception {
		
		Test4 t4 = new Test4();
		int number;
		while (true) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("입력(종료 : -1) : ");
			number = Integer.parseInt(in.readLine());

			if (number == -1) {
				System.out.println("종료됩니다.");
				return;
			}
			
			System.out.println("-------------------------------");
			System.out.println("입력 : " + number + "\t최종요금 : " + t4.result(number));
		}


	}

}
