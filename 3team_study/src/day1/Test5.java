package day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	5�� ���� : ������� ���3
*/

public class Test5 {

	// [�ʵ�]	
		int basicPrice = 1000;
		
	// [�޼ҵ�]
		//��� ��� �޼ҵ�
		public int calPrice(int age) {
			int price = basicPrice;
			if(age<20)
				price = (int) basicPrice - ((int) (basicPrice * 0.25));
			
			return price;
		}
		
		//���� ��� ��� �޼ҵ�
		public double calDiscount(int discount) {
			return basicPrice - (basicPrice * discount * 0.01);
		}

	//////////////////////////////////////////////////////////////////////////////////////
	//[���� �޼ҵ�]
		public static void main(String[] args) throws Exception {
			
			Test5 t5 = new Test5();
			int age = 0;
			
			while (true) {
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("����(���� : -1) : ");
				age = Integer.parseInt(in.readLine());

				if (age == -1) {
					System.out.println("����˴ϴ�.");
					return;
				}
				
				System.out.println("-------------------------------");
				System.out.println("���� : " + age + "\t������� : " + t5.calPrice(age));
			}

		}

}
