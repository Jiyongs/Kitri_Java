public class BCTest {
	public static void main(String[] args) {
		int count = 0;
		while(count < 10) {
			count++;
			int number = (int) (Math.random() * 10);
			if(number == 0) {
				System.out.println("number�� 0�� ���Խ��ϴ�. \n ���α׷� �����մϴ�.");
				break;  //�ݺ���(while)�� ����
			}
			System.out.println(count + ". number = " + number);
		}

		System.out.println("-------------------------------------------");

		count = 0;
		while(count < 10) {
			count++;
			int number = (int) (Math.random() * 10);
			if(number == 0) {
				System.out.println("number�� 0�� ���Խ��ϴ�. \n �������� �����մϴ�.");
				continue; //���� �ݺ���(while)���� �ٷ� ��ȯ
			}
			System.out.println(count + ". number = " + number);
		}
		System.out.println("���α׷� ����!!!"); //��µ�

		System.out.println("-------------------------------------------");

		count = 0;
		while(count < 10) {
			count++;
			int number = (int) (Math.random() * 10);
			if(number == 0) {
				System.out.println("number�� 0�� ���Խ��ϴ�.");
				return; //�޼ҵ�(main)�� ����
			}
			System.out.println(count + ". number = " + number);
		}
		System.out.println("���α׷� ����!!!"); //��� �� ��


	}
}
