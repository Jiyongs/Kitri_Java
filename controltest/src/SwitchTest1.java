public class SwitchTest1 {
	public static void main(String[] args) {
		int num = 4;
		switch(num){
			case 1 : System.out.println("1 입니다.");
						break;
			case 2 : System.out.println("2입니다.");
						break;
			case 3 : System.out.println("3입니다.");
						break;
			default : System.out.println("123 아닙니다.");
		}
		// 문자는 아스키코드로 비교 가능함.
		char c = 'a';
		switch(c){
			case 97 : System.out.println("a입니다.");
						break;
			case 98 : System.out.println("b입니다.");
						break;
			case 99 : System.out.println("c입니다.");
						break;
			default : System.out.println("a,b,c 아닙니다.");
		}

		//java jdk 7이상은 문자열 비교도 가능함.
		String str = "java";
		switch(str){
			case "oracle" : System.out.println("oracle입니다.");
						break;
			case "java" : System.out.println("java입니다.");
						break;
			case "jsp" : System.out.println("jsp입니다.");
						break;
			default : System.out.println("전부  아닙니다.");
		}

		System.out.println("프로그램종료!!!");
	}
}
