package constructor;

public class DohyungTest {
	public static void main(String[] args) {
		Rect r1;
		//���ΰ� 4�̰� ���ΰ� 3�� �簢���� ���̴� 12�̰� �ѷ��� 14�Դϴ�.
		r1 = new Rect();
		r1.info();

		Rect r2;
		//���ΰ� ?�̰� ���ΰ� ?�� �簢���� ���̴� ?�̰� �ѷ��� ?�Դϴ�.
		r2 = new Rect(5,7);
		r2.info();
		
		Circle c1;
		//�������� 4�� ���� ���̴� 50.***�̰� �ѷ��� 24.***�Դϴ�.
		c1 = new Circle();
		c1.info();

		Circle c2;
		//�������� ?�� ���� ���̴� ?.***�̰� �ѷ��� ?.***�Դϴ�.
		c2 = new Circle(7);
		c2.info();

	}
}
