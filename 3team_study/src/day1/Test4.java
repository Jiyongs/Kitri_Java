package day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	4�� ���� : ��ø�� ���
*/

public class Test4 {

// [�޼ҵ�]
	//��� ���ϱ� �޼ҵ�
	public String result(int number) {
		String result;
		if(number < 0) {
			result = "0 �̸�";
		}
		else {
			if(number<=10) {
				result = "10 ���� 0 �ʰ�";
			}
			else {
				result = "10 �ʰ�";
			}
		}
		return result;
	}
	
//////////////////////////////////////////////////////////////////////////////////////
//[���� �޼ҵ�]
	public static void main(String[] args) throws Exception {
		
		Test4 t4 = new Test4();
		int number;
		while (true) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("�Է�(���� : -1) : ");
			number = Integer.parseInt(in.readLine());

			if (number == -1) {
				System.out.println("����˴ϴ�.");
				return;
			}
			
			System.out.println("-------------------------------");
			System.out.println("�Է� : " + number + "\t������� : " + t4.result(number));
		}


	}

}
