public class OperTest5 {
	public static void main(String[] args) {
		int x = 0;
		System.out.println("1. x =" + x);

		x = 10;	//�Ϲ� ���� ����
		System.out.println("2. x =" + x);

		x += 5;   // x = x + 5  //���� �� ���� ���� (�� ���� ������ �� ������ �ٿ���)
		System.out.println("3. x =" + x);

		x -= 5;
		System.out.println("4. x =" + x);

		x *= 5;
		System.out.println("5. x =" + x);

		x /= 5;
		System.out.println("6. x =" + x);

		x %= 5;
		System.out.println("7. x =" + x);


		// int y = 10;
		// y�� ���� 1 ������Ű�� ����� 3���� �̻� �����ϼ���. (kt����)

		int y = 10;
		y++;
		System.out.println(" y = " + y);
		++y;
		System.out.println(" y = " + y);
		y +=1;
		System.out.println(" y = " + y);
		y = y +1;
		System.out.println(" y = " + y);
	}
}
