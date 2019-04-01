package day1;
import java.io.*;

/*
	2번 문제 : 버스요금 계산1 (다중 if문)
*/

public class Test2 {

// [필드]
	int basicPrice = 1000;
	
// [메소드]
	//요금 계산 메소드
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

	//할인 요금 계산 메소드
	public double calDiscount(int discount) {
		return basicPrice - (basicPrice * discount * 0.01);
	}

//////////////////////////////////////////////////////////////////////////////////////
// [실행 메소드]
	public static void main(String[] args) throws Exception {

		Test2 t2 = new Test2();

		int age = 0;

		while (true) {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("나이(종료 : -1) : ");
			age = Integer.parseInt(in.readLine());

			if (age < 0) {
				System.out.println("종료됩니다.");
				return;
			}
			
			System.out.println("-------------------------------");
			System.out.println("나이 : " + age + "\t최종요금 : " + t2.calPrice(age));
		}
	}

}
