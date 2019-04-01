package day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	5번 문제 : 버스요금 계산3
*/

public class Test5 {

	// [필드]	
		int basicPrice = 1000;
		
	// [메소드]
		//요금 계산 메소드
		public int calPrice(int age) {
			int price = basicPrice;
			if(age<20)
				price = (int) basicPrice - ((int) (basicPrice * 0.25));
			
			return price;
		}
		
		//할인 요금 계산 메소드
		public double calDiscount(int discount) {
			return basicPrice - (basicPrice * discount * 0.01);
		}

	//////////////////////////////////////////////////////////////////////////////////////
	//[실행 메소드]
		public static void main(String[] args) throws Exception {
			
			Test5 t5 = new Test5();
			int age = 0;
			
			while (true) {
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("나이(종료 : -1) : ");
				age = Integer.parseInt(in.readLine());

				if (age == -1) {
					System.out.println("종료됩니다.");
					return;
				}
				
				System.out.println("-------------------------------");
				System.out.println("나이 : " + age + "\t최종요금 : " + t5.calPrice(age));
			}

		}

}
