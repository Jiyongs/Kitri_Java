package day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	3�� ���� : ������� ���2 (if else 2�� ��ø / 2���� ���)
*/

public class Test3 {

// [�ʵ�]
	int basicPrice = 1000;

// [�޼ҵ�]
	//��� ��� �޼ҵ�
		public int calPrice(int age) {
			int price = 0;
			
			if (age < 14) {
				if(age < 4 ){ //������
					price = (int) calDiscount(100);
				}
				else { //���
					price = (int) calDiscount(50);
				}
			}
			else {
				if(age < 20) { //û�ҳ�
					price = (int) calDiscount(25);
				}
				else {
					price = basicPrice;
				}
			}
			
			return price;
		}

	//���� ��� ��� �޼ҵ�
		public double calDiscount(int discount) {
			return basicPrice - (basicPrice * discount * 0.01);
		}

//////////////////////////////////////////////////////////////////////////////////////
//[���� �޼ҵ�]
		public static void main(String[] args) throws Exception {

			Test3 t2 = new Test3();

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
				System.out.println("���� : " + age + "\t������� : " + t2.calPrice(age));
			}
		}
}
