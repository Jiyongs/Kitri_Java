public class OperTest2 
{
	public static void main(String[] args) 
	{
		int num1 = 13;
		int num2 = 5;
		int num3 = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + num3);
		System.out.println(num1 + " + " + num2 + " = " + num1 + num2);   //num1 + "���ڿ�" ������ ���� ����Ǿ� num 1 + num2�� ���ڿ��� ������ �ǹ���
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2)); //num1 + num2�� ( )�� ������ ���� ����Ǿ� ��� ������ ��  
		//System.out.println(num1 + " + " + num2 + " = " + num1 - num2);   //-�� �������ۿ� �ȵǹǷ�, ���ڿ� + ���ڰ� �Ǿ� ������ ��

		num3 = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + num3);
		System.out.println(num1 + " + " + num2 + " = " + num1 * num2);   //num1 + "���ڿ�" ������ ���� ����Ǿ� num 1 + num2�� ���ڿ��� ������ �ǹ���

		num3 = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + num3);
		System.out.println(num1 + " + " + num2 + " = " + num1 / num2);   //num1 + "���ڿ�" ������ ���� ����Ǿ� num 1 + num2�� ���ڿ��� ������ �ǹ���

		num3 = num1 % num2;
		System.out.println(num1 + " % " + num2 + " = " + num3);
		System.out.println(num1 + " + " + num2 + " = " + num1 % num2);   //num1 + "���ڿ�" ������ ���� ����Ǿ� num 1 + num2�� ���ڿ��� ������ �ǹ���

	}
}
