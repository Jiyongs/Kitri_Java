public class WhileLotto {
	public static void main(String[] args) {

		int num1 = (int) (Math.random() * 3 + 1);
		int num2 = 0;
		int num3 = 0;

		boolean flag = true;

		while(flag){
			num2 = (int) (Math.random() * 3 + 1);
			if(num1 != num2){
				flag = false;
			}
		}

		flag = true;
		while(flag){
			num3 = (int) (Math.random() * 3 + 1);
			if(num1 != num3 && num2 != num3){
				flag = false;
			}
		}

		System.out.println("금주 당첨 번호 : " + num1 + " " + num2 + " " + num3);
	
	}
}
