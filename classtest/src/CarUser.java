public class CarUser {
	public static void main(String[] args) {
		Car car1;   // JAVA�� NULL = ���� �޸𸮿� �ø��� ���� ��(=�ּҰ��� ����) //car1 = null�� ����?
		car1 = new Car();

		Car car2;
		car2 = new Car();

		//Car�� carName, color, maker�� ����������, �ڵ����� null�� �ʱ�ȭ�Ǿ� �ִ�
		System.out.println("1. ���̸� : " + car1 .carName + " ���� : " + car1.color + " ������ : " + car1.maker);

		car1.carName = "�Ÿ";
		car1.color = "������";
		car1.maker = "����";

		System.out.println("1. ���̸� : " + car1.carName + " ���� : " + car1.color + " ������ : " + car1.maker);

		car2.carName = "k5";
		car2.color = "���";
		car2.maker = "���";
		System.out.println("2. ���̸� : " + car2.carName + " ���� : " + car2.color + " ������ : " + car2.maker);

		//car1�� car2�� �ּҰ� ���
		System.out.println("car1 : " + car1);
		System.out.println("car2 : " + car2);

		// �޼ҵ� ȣ��
		System.out.println("���� " + car1.carName + "�� �ӵ� : " + car1.speed);
		System.out.println("car1�� �ӵ��� 2ȸ ����!!!");
		car1.speedUp();
		car1.speedUp();
		System.out.println("2ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);

		// �޼ҵ� ȣ�� (for�� �̿�)
		System.out.println("car1�� �ӵ��� 8ȸ ����!!!");
		for(int i = 0; i<8; i++){
			car1.speedUp();
		}
		System.out.println("8ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);

		System.out.println("car1�� �ӵ��� 4ȸ ����!!!");
		for(int i =0; i<4; i++){
			car1.speedDown();
		}
		System.out.println("4ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);

		System.out.println("car1�� �ӵ��� 10ȸ ����!!!");
		for(int i =0; i<10; i++){
			car1.speedDown();
		}
		System.out.println("10ȸ ���� �� " + car1.carName + "�� �ӵ� : " + car1.speed);


		//java Ư¡ . �÷��� �����̴� (wora / write ones runs anywhere)
		//              = java �ڵ�� ��� OS���� �����
		//              -> jvm (java virtual machine)�� ��� os���� ���డ���ϰ� ���� (�츮�� window�� jvm�� ��Ҵ�)

		// jvm (�ڹ� ���� �ӽ�)
		// jvm�� �޸� ������ ����
		// 1) static 
		// 2) heep : ���� �޸� �Ҵ� ���� / new�� �̿��Ͽ� ��ü �����Ǵ� ����
		// 3) stack : ������, ��ü���� �Ҵ�Ǵ� ����

		//**����**
		//java������ ������ ����� jvm�� �˾Ƽ� ����
		//java������ �Ҹ��� ��ɵ� jvm�� ���� (garbage �����Ұ� �־ �Ҹ��� ���� ���� ���ص��� / c�� �޸�)
	}
}
