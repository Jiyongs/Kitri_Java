package day1;
import java.io.*;

/*
	1번 문제 : 최댓값 구하기 (if문)
*/

public class Test1 {

// [실행 메소드]
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int input1, input2, input3;
		int max = 0;

		// 3개의 값을 입력받음
		System.out.print("1번째 값 : ");
		input1 = Integer.parseInt(in.readLine());
		System.out.print("2번째 값 : ");

		input2 = Integer.parseInt(in.readLine());
		System.out.print("3번째 값 : ");
		input3 = Integer.parseInt(in.readLine());

		// 최댓값 비교
		if (input1 > input2) {
			if(input1>input3) {
				max = input1;
			}
			else
				max = input3;
		} else {
			max = input2;
		}

		// 최댓값 출력
		System.out.println("max : " + max);

	}

}
