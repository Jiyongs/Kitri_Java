public class IfElseTest1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;

		// 방법 1
		/*
		if(x > y) {
			System.out.println(x + "는 " + y + "보다 크다.");
		} else {
			System.out.println(x + "는 " + y + "보다 작다.");
		}
		*/

		// 방법 2 
		String result;
		if(x > y) {
			result = "크다";
		} else {
			result = "작다";
		}
		System.out.println(x + "는 " + y + "와 비교하여 " + result);

		//방법 3 (if문 중첩)
		if(x < y){
			result = "작다";
		} else {
			if(x == y){
				result = "같다";
			} else {
				result = "크다";
			}
		}
		System.out.println(x + "는 " + y + "와 비교하여 " + result);

		// 남자, 여자 if else로 바꾸기


		System.out.println("프로그램 종료!!!!");
	}
}
