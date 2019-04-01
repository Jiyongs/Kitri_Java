public class OperTest2 
{
	public static void main(String[] args) 
	{
		int num1 = 13;
		int num2 = 5;
		int num3 = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + num3);
		System.out.println(num1 + " + " + num2 + " = " + num1 + num2);   //num1 + "문자열" 연산이 먼저 수행되어 num 1 + num2도 문자열로 결합이 되버림
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2)); //num1 + num2에 ( )를 씌워서 먼저 수행되어 산술 연산이 됨  
		//System.out.println(num1 + " + " + num2 + " = " + num1 - num2);   //-는 산술연산밖에 안되므로, 문자열 + 숫자가 되어 에러가 남

		num3 = num1 * num2;
		System.out.println(num1 + " * " + num2 + " = " + num3);
		System.out.println(num1 + " + " + num2 + " = " + num1 * num2);   //num1 + "문자열" 연산이 먼저 수행되어 num 1 + num2도 문자열로 결합이 되버림

		num3 = num1 / num2;
		System.out.println(num1 + " / " + num2 + " = " + num3);
		System.out.println(num1 + " + " + num2 + " = " + num1 / num2);   //num1 + "문자열" 연산이 먼저 수행되어 num 1 + num2도 문자열로 결합이 되버림

		num3 = num1 % num2;
		System.out.println(num1 + " % " + num2 + " = " + num3);
		System.out.println(num1 + " + " + num2 + " = " + num1 % num2);   //num1 + "문자열" 연산이 먼저 수행되어 num 1 + num2도 문자열로 결합이 되버림

	}
}
