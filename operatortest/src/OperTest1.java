public class OperTest1 
{
	public static void main(String[] args) 
	{
		int x = 10;                    //[��� ��]     [���� ��]
		System.out.println(x);         // x = 10        x = 10
		System.out.println(x++);     // x = 10        x = 11
		System.out.println(--x);      // x = 10        x = 10
		System.out.println(x++);     // x = 10        x = 11
		System.out.println(++x);     // x = 12        x = 12
		System.out.println(x--);      // x = 12        x = 11
		System.out.println(--x);      // x = 10        x = 10
		System.out.println(x++);     // x = 10        x = 11
		System.out.println(x);        // x = 11        x = 11

		char c = 'a';
		System.out.println("c == " + c);
		System.out.println("(int)c == " + (int)c);  //����->���� (���� �� ��ȯ) //ascii �ڵ�(a=97)

		int y = c;                                       //����->���� (�ڵ� �� ��ȯ)
		System.out.println("y == " + y);
	
		//c = y;
		//System.out.println("c == " + c);            //char = int (����) //char(2byte) != int(4byte)

		c = (char)y;
		System.out.println("c == " + c);              //char = int (���� �� ��ȯ)

		//boolean b = true;                              //boolean -> int (����) //������ Ÿ���� �޶�(boolean�� true, false�� ����)
		//int z = b;                                         //�� ��ȯ�� ������ Ÿ���� ���� �ͳ��� ����

		int z = 30;
		double d = z;

		//z = d; //(����)
		z = (int) d;


	}
}
