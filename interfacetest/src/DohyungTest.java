public class DohyungTest {
	public static void main(String[] args) {
		Rect r1 = new Rect(4,5);
		System.out.println("���ΰ� " + r1.width + "�̰� ���ΰ� " + r1.height +
			"�� �簢���� ���̴� " + r1.getArea() + "�̰� �ѷ��� " + r1.getRound() + "�Դϴ�.");

		Circle c1 = new Circle(4);
		System.out.println("�������� " + c1.radius + "�� ���� ���̴� " +
			c1.getArea() + "�Դϴ�.");
		
		//DohyungArea d1 = new Rect();
	}
}
