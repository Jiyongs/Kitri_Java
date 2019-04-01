package day1;
import java.io.*;

/*
	2�� ���� : ������� ���1 (���� if��)
*/

public class Test2 {

// [�ʵ�]
	int basicPrice = 1000;
	
// [�޼ҵ�]
	//��� ��� �޼ҵ�
	public int calPrice(int age) {
		int price = 0;
		if (age >= 0 && age < 4)
			price = (int) calDiscount(100);

		if (age > 3 && age < 14)
			price = (int) calDiscount(50);
 
		if (age > 13 && age < 20)
			price = (int) calDiscount(25);

		if (age > 19 && age < 65)
			price = basicPrice;

		if (age >= 65)
			price = 0;

		return price;
	}

	//���� ��� ��� �޼ҵ�
	public double calDiscount(int discount) {
		return basicPrice - (basicPrice * discount * 0.01);
	}

//////////////////////////////////////////////////////////////////////////////////////
// [���� �޼ҵ�]
	public static void main(String[] args) throws Exception {

		Test2 t2 = new Test2();

		int age = 0;

		while (true) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("����(���� : -1) : ");
			age = Integer.parseInt(in.readLine());

			if (age < 0) {
				System.out.println("����˴ϴ�.");
				return;
			}
			
			System.out.println("-------------------------------");
			System.out.println("���� : " + age + "\t������� : " + t2.calPrice(age));
		}
	}

}
