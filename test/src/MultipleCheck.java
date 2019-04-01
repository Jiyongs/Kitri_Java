public class MultipleCheck {
	public static void main(String[] args) {
		int number = 20;

		int countTwo = 0;
		int countThree = 0;
		int countFive = 0;

		String result = "";

		for(int i = 1; i<=number; i++) {
			for(int j = 2; j<=5; j++){
				if(i%j==0&&j!=4){
					result += j + "의배수 ";
					switch(j){
						case 2 : countTwo++; break;
						case 3 : countThree++; break; 
						default : countFive++;
					}
				}
			}
			System.out.println(i + ". " + result);
			result ="";
		}

		System.out.println("===== 출력 횟수 =====");
		System.out.println("2의 배수 : " + countTwo);
		System.out.println("3의 배수 : " + countThree);
		System.out.println("5의 배수 : " + countFive);

	}
}
