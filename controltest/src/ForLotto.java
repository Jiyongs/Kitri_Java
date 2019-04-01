/*
* Lotto
1 - 3까지의 서로 다른 난수 3개 발생.
*/
public class ForLotto {
	public static void main(String[] args) {

		//선생님 방법
		int num1 = (int) (Math.random() * 3 + 1);
		int num2 = 0;
		int num3 = 0;
		for(;;){
			num2 = (int) (Math.random() * 3 + 1);
			if(num1 != num2){
				break;
			}
		}
		for(;;){
			num3 = (int) (Math.random() * 3 + 1);
			if(num1 != num3 && num2 != num3){
				break;
			}
		}
		System.out.println("금주 당첨 번호 : " + num1 + " " + num2 + " " + num3);

		/*
		// 내 방법
		int num1 = (int) (Math.random() * 3 + 1);
		int num2 = (int) (Math.random() * 3 + 1);
		int num3 = (int) (Math.random() * 3 + 1);

		for(;;){
			if(num1==num2 || num1==num3){
				num1 = (int) (Math.random() * 3 + 1);
			} else if(num2==num3){
				num2 = (int) (Math.random() * 3 + 1);
			} else break;
		}

		System.out.println("금주 당첨 번호 : " + num1 + " " + num2 + " " + num3);

		*/
	}
}
