/*
* Lotto
1 - 3������ ���� �ٸ� ���� 3�� �߻�.
*/
public class ForLotto {
	public static void main(String[] args) {

		//������ ���
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
		System.out.println("���� ��÷ ��ȣ : " + num1 + " " + num2 + " " + num3);

		/*
		// �� ���
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

		System.out.println("���� ��÷ ��ȣ : " + num1 + " " + num2 + " " + num3);

		*/
	}
}
