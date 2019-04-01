public class BCTest {
	public static void main(String[] args) {
		int count = 0;
		while(count < 10) {
			count++;
			int number = (int) (Math.random() * 10);
			if(number == 0) {
				System.out.println("number가 0이 나왔습니다. \n 프로그램 종료합니다.");
				break;  //반복문(while)을 종료
			}
			System.out.println(count + ". number = " + number);
		}

		System.out.println("-------------------------------------------");

		count = 0;
		while(count < 10) {
			count++;
			int number = (int) (Math.random() * 10);
			if(number == 0) {
				System.out.println("number가 0이 나왔습니다. \n 다음으로 진행합니다.");
				continue; //다음 반복문(while)으로 바로 전환
			}
			System.out.println(count + ". number = " + number);
		}
		System.out.println("프로그램 종료!!!"); //출력됨

		System.out.println("-------------------------------------------");

		count = 0;
		while(count < 10) {
			count++;
			int number = (int) (Math.random() * 10);
			if(number == 0) {
				System.out.println("number가 0이 나왔습니다.");
				return; //메소드(main)를 종료
			}
			System.out.println(count + ". number = " + number);
		}
		System.out.println("프로그램 종료!!!"); //출력 안 됨


	}
}
