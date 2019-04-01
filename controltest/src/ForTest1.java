public class ForTest1 {
	public static void main(String[] args) {

		System.out.println("1~10까지 출력");
		for(int i = 1; i<11; i++){
			System.out.print(i + "  " );
		}

		System.out.println("\n\n1~10까지 출력(홀수만)");
		for(int i = 1; i<11; i+=2){
			System.out.print(i + "  ");
		}

		//위 방법보다 효율적인 방법은 아님.
		/*
		System.out.println("\n\n1~10까지 출력(홀수만)");
		for(int i = 1; i<11; i+=2){
			if(i%2!=0){
				System.out.print(i + "  ");
			}
		}
		*/

		System.out.println("\n\n1~100까지 출력(10개 단위로 줄 바꿈)");
		for(int i = 1; i<101; i++)
		{
			System.out.print(i + "  ");
			if(i%10 == 0){
				System.out.print("\n");
			}
		}

		System.out.println("\n프로그램 종료!!!");
	}
}
