package day1;
import java.io.*;

/*
	1�� ���� : �ִ� ���ϱ� (if��)
*/

public class Test1 {

// [���� �޼ҵ�]
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int input1, input2, input3;
		int max = 0;

		// 3���� ���� �Է¹���
		System.out.print("1��° �� : ");
		input1 = Integer.parseInt(in.readLine());
		System.out.print("2��° �� : ");

		input2 = Integer.parseInt(in.readLine());
		System.out.print("3��° �� : ");
		input3 = Integer.parseInt(in.readLine());

		// �ִ� ��
		if (input1 > input2) {
			if(input1>input3) {
				max = input1;
			}
			else
				max = input3;
		} else {
			max = input2;
		}

		// �ִ� ���
		System.out.println("max : " + max);

	}

}
