public class DohyungTest {
	public static void main(String[] args) {
		Rect r1 = new Rect(4,5);
		System.out.println("���ΰ� " + r1.width + "�̰� ���ΰ� " + r1.height +
			"�� �簢���� ���̴� " + r1.getArea() + "�̰� �ѷ��� " + r1.getRound() + "�Դϴ�.");

		Circle c1 = new Circle(4);
		System.out.println("�������� " + c1.radius + "�� ���� ���̴� " +
			c1.getArea() + "�̰� �ѷ��� " + c1.getRound() + "�Դϴ�.");

		//Dohyung d = new Dohyung();
		Dohyung d1 = new Rect(4, 3);  //d1�� ����Ŭ���� Rect()�� ����������, ��� ������ ���� Rect�� Dohyung�� override�� �޼ҵ� ����.
		System.out.println("�簢���� ���̴� " + d1.getArea() + "�̰� �ѷ��� " + d1.getRound() + "�Դϴ�.");

		Rect r2 = (Rect) d1;  //r2�� Rect(4, 3)�� �ּҸ� ����Ŵ. //r2�� �ڷ����� Rect�̱� ������, r2�� �����ϴ� Rect()�� �ʵ�, �޼ҵ带 ��� ������.

		Circle c2 = (Circle) d1; //d1 ���� ��, Circle()�� �������� ����. ���� ����ȯ ������(������ ����), Circle()�� �ʵ�, �޼ҵ带 ��� �Ұ�(���� �Ұ�) 

	}
}
