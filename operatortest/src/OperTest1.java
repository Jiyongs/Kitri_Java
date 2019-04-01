public class OperTest1 
{
	public static void main(String[] args) 
	{
		int x = 10;                    //[출력 값]     [실제 값]
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
		System.out.println("(int)c == " + (int)c);  //문자->숫자 (강제 형 변환) //ascii 코드(a=97)

		int y = c;                                       //문자->숫자 (자동 형 변환)
		System.out.println("y == " + y);
	
		//c = y;
		//System.out.println("c == " + c);            //char = int (오류) //char(2byte) != int(4byte)

		c = (char)y;
		System.out.println("c == " + c);              //char = int (강제 형 변환)

		//boolean b = true;                              //boolean -> int (오류) //데이터 타입이 달라서(boolean은 true, false만 가짐)
		//int z = b;                                         //형 변환은 데이터 타입이 같은 것끼리 가능

		int z = 30;
		double d = z;

		//z = d; //(오류)
		z = (int) d;


	}
}
