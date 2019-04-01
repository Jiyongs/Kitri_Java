package com.kitri.lang;

// WrapperClassTest : �⺻ ������ Ÿ���� Ŭ����ȭ
//�⺻ DT     WrapperClass
//boolean     Boolean
//char           Character
//byte           Byte
//short          Short
//int              Integer
//long           Long
//float           Float
//double       Double

public class WrapperClassTest {

	public static void main(String[] args) {
		 Boolean b1 = new Boolean(true);        //b1=true
		 Boolean b2 = new Boolean("true");      //b2=true
		 Boolean b3 = new Boolean("anything"); //b3=false
		 
		 Boolean b4 = Boolean.parseBoolean("true"); //b4 = true
		 
		 Boolean b = b1.booleanValue();
		 System.out.print(b1);
		 b = Boolean.getBoolean("true");
		 
		 String s = "123";
		 System.out.println(s + 4);   //"123" + 4 = "1234"
		 
		 Integer i = new Integer(s);
		 int x = i.intValue();
		 System.out.println(x + 4); //123 + 4 = 127
		 
		 x = Integer.parseInt(s);
		 System.out.println(x + 4); //123 + 4 = 127
		 
		 s = "123.45";
		 double d = Double.parseDouble(s);
		 System.out.println(d + 4); //123.45 + 4 = 127.45
		 
		 //[AutoBoxing ����]
		 //unboxing (��ڽ�)
		 //Wrapper Ŭ����������, Integer i(������)�� int y(�⺻��)�� ���� �� ����
		 //��, ���� ���ĸ� (ex: Integer-int / Double-double ��)
		 Integer i2 = new Integer(3);
		 int y = i2;
		 System.out.println(y);
		 
		 //boxing (�ڽ�)
		 //Wrapper Ŭ����������, int y(�⺻��)�� Integer i(������)�� ���� �� ����
		 Integer i3 = y;		 
		 System.out.println(i3);

	}

}
