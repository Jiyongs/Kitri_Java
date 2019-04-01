public class IfTest1 {
	public static void main(String[] args) {

		//if문
		int x = 10;
		int y = 7;
		
		if(x>y){
			System.out.println("크다.");
		}

		//if문 2번 -> if문 1번
		/*
		int jumin = 2;
			if(jumin % 2 == 0){
			System.out.println("여자");
			}
			if(jumin % 2 != 0){
			System.out.println("남자");         //같은 실행문을 가진 if문을 두 번 쓰는 것은 비효율적
			}
		*/
		int jumin = 2;
		String gender = "여자";
		if(jumin%2!=0){
			gender = "남자";
		}
		System.out.println(gender);

		System.out.println("프로그램 종료!!!");
	}
}
