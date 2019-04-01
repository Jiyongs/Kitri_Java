package day1;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
	3번 문제 : 버스요금 계산2 (if else 2번 중첩 / 2분할 방식)
*/

public class Test3 {

// [필드]
	int basicPrice = 1000;

// [메소드]
	//요금 계산 메소드
		public int calPrice(int age) {
			int price = 0;
			
			if (age < 14) {
				if(age < 4 ){ //영유아
					price = (int) calDiscount(100);
				}
				else { //어린이
					price = (int) calDiscount(50);
				}
			}
			else {
				if(age < 20) { //청소년
					price = (int) calDiscount(25);
				}
				else {
					price = basicPrice;
				}
			}
			
			return price;
		}

	//할인 요금 계산 메소드
		public double calDiscount(int discount) {
			return basicPrice - (basicPrice * discount * 0.01);
		}

//////////////////////////////////////////////////////////////////////////////////////
//[실행 메소드]
		public static void main(String[] args) throws Exception {

			Test3 t2 = new Test3();

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
				System.out.println("나이 : " + age + "\t최종요금 : " + t2.calPrice(age));
			}
		}
}
