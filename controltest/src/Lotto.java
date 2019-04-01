public class Lotto {
	public static void main(String[] args) {

		int cnt = 0;
		
		for(int i = 0; i<5; i++){

		int num1 = (int) (Math.random() * 45) + 1;
		int num2, num3, num4, num5, num6 = 0;

		do {
			num2 = (int) (Math.random() * 45) + 1;
		}
		while (num2 == num1);

		do {
			num3 = (int) (Math.random() * 45) + 1;
		}
		while (num3 == num1 || num3 == num2);

		do {
			num4 = (int) (Math.random() * 45) + 1;
		}
		while (num4 == num1 || num4 == num2 || num4 == num3);

		do {
			num5 = (int) (Math.random() * 45) + 1;
		}
		while (num5 == num1 || num5 == num2 || num5 == num3 || num5 == num4);

		do {
			num6 = (int) (Math.random() * 45) + 1;
		}
		while (num6 == num1 || num6 == num2 || num6 == num3 || num6 == num4 || num6 == num5);
                                                                                                            
		cnt++;

		System.out.println("금주 당첨 번호 : " + cnt + ". " + num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " + num6
								+ "\n");
		
}
	}
}
