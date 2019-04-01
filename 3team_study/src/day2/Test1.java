package day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Ŭ����, ���ǹ�, �ݺ���
// 3 : cat
// 4 : dog
// 5 : lion
// 8 : tiger

public class Test1 {

// [�ʵ�]
	// �Է� �� ��ü ����
	BufferedReader in;

//[������]
	public Test1() {
		// �Է� �� ��ü ����
		in = new BufferedReader(new InputStreamReader(System.in));
	}

//[�޼ҵ�]
	// 1) �Է°� ���� �޼ҵ�
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

	// [���� �޼ҵ�]
	public static void main(String[] args) {

		Test1 ex = new Test1();
		
		int countCat, countDog, countLion, countTiger;
		
		countCat = 0;
		countDog = 0;
		countLion = 0;
		countTiger = 0;
		

		System.out.print("�Է� : ");
		int getNum = ex.getNumber();

		String result = ""; // �ʱ�ȭ

		System.out.println("==<<" + getNum + "ȸ �ݺ� �մϴ�>==");

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
			result = ""; // �ʱ�ȭ
		}
		
		System.out.println("\n==<<Fruit Count List>>==");

		System.out.println("cat " + countCat +"ȸ\ndog " + countDog + "ȸ\nlion " + countLion + "ȸ\ntiger " + countTiger + "ȸ");

	}

}
