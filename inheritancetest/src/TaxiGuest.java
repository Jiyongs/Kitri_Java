public class TaxiGuest {
	public static void main(String[] args) {
		//Taxi�� �����ڷ�, ���� Ŭ������ Car�� ����Ʈ ������ Car()�� ȣ����
		Taxi t1 = new Taxi();
		System.out.println("t1 >> " + t1.toString() + "    �⺻ ��� : " + t1.basicPrice);  //Car Ŭ���� �� Taxi Ŭ���� (���)�̶� info() ��� ������

		//Taxi�� �����ڷ�, ���� Ŭ������ Car�� ������ Car(String, String, String)�� overriding�Ͽ�, �����
		Taxi t2 = new Taxi("k5", "��ȫ��", "���");
		System.out.println("t2 >> " + t2.toString() + "    �⺻ ��� : " + t2.basicPrice);

		// �մ� 1�� ����
		t2.initPrice();

		// ������
		int km = 20;
		t2.calcPrice(km);
		System.out.println("\n" + t2 + "�� Ÿ�� ���𿡼� �������� " + km + "km�̵�!!!" + t2.price);
		System.out.println("��� : " + t2.price + "��");

		// �մ��� ������
		t2.sumPrice();
		System.out.println("���� ���� : " + t2.totalPrice);

		//�մ� 2�� ����
		t2.initPrice();

		// ������
		km = 20;
		t2.calcPrice(km);
		System.out.println("\n" + t2 + "�� Ÿ�� �������� ������� " + km + "km�̵�!!!" + t2.price);
		System.out.println("��� : " + t2.price + "��");
		
		// �մ��� ������
		t2.sumPrice();
		System.out.println("���� ���� : " + t2.totalPrice);


		//�ٽ� ����
		int upDown = 50;
		System.out.println("t2�� �ӵ��� " + upDown + "��ŭ ����!!!");
		int speed = t2.speedUp(upDown);

		System.out.println("t2�� �ӵ� : " + speed + "    " + t2.speed);


		upDown = 250;
		System.out.println("t2�� �ӵ��� " + upDown + "��ŭ ����!!!");
		speed = t2.speedUp(upDown);

		System.out.println("t2�� �ӵ� : " + speed + "    " + t2.speed);
		//

/*
		System.out.println(t1 + "       " + t2);
		System.out.println(t1.toString() + "       " + t2.toString()); //Object class�� toString() �޼ҵ� : ���ڿ� ���� �Լ�
*/
		Taxi t3 = new Taxi("k5", "��ȫ��", "���");
		System.out.println(t2 + "       " + t3);
		System.out.println(t2.hashCode() + "       " + t3.hashCode());
		if(t2==t3)  //�񱳿����ڴ� �⺻ DataType�� ��쿡 ���� ��, but ������ DataType�� ���� �ּҰ��� ��
			System.out.println("t2�� t3�� �ּҰ��� ���� ���̴�.");
		else
			System.out.println("t2�� t3�� �ּҰ��� �ٸ� ���̴�.");

		if(t2.equals(t3))
			System.out.println("t2�� t3�� ���� ���� ���̴�.");
		else
			System.out.println("t2�� t3�� ���� �ٸ� ���̴�.");


	}
}
