package com.kitri.lang;

public class StringBufferTest1 {

	public static void main(String[] args) {
		
		//[capacity()] : ���ڿ����� ũ��
		StringBuffer sb1 = new StringBuffer("hello ");
		System.out.println("1. sb1 = " + sb1);
		int cap = sb1.capacity();
		System.out.println("�ʱ� ũ�� : " + cap); //�ʱ� ũ�� : 22 (16+6)
		
		//[length()] : ���ۿ� ��� ���ڿ� ũ��
		System.out.println("���ڿ� �� : " + sb1.length()); //���ڿ� �� : 6
		
		//CharSequence �� interface
		//-> ��ü ���� �Ұ�
		//->String
		
		//[append()] : ���ڿ����� + ���ڿ�
		// *String���� �ٸ���, StringBuffer�� ���� ���ڿ� ��ü�� ������ų �� ����
		// *String�� concat()�� �ӽ� ����, StringBuffer�� append()�� ���� ����
		sb1.append("java");
		cap = sb1.capacity();
		System.out.println("2. sb1 = " + sb1);  //sb1 = "hello java"
		System.out.println("ũ�� : " + cap + "\t���ڿ� �� : " + sb1.length()); //ũ�� : 22, ���ڿ� �� : 10

		sb1.append(" !!!!!!!!!!!!");
		cap = sb1.capacity();
		System.out.println("3. sb1 = " + sb1);  //sb1 = "hello java !!!!!!!!!!!!"
		System.out.println("ũ�� : " + cap + "\t���ڿ� �� : " + sb1.length()); //ũ�� : 46, ���ڿ� �� : 23
																							 // ���� ũ��<���ڿ� ���� �Ǹ�, �ڵ����� ũ�⸦ �� �� �ø�
		//[insert()] : Ư�� ��ġ�� ���ڿ��� ����
		sb1.insert(10, "@@@");
		System.out.println("4. sb1 = " + sb1);  //sb1 = "hello java@@@ !!!!!!!!!!!!"

		//[delete()] : Ư�� ������ ���ڿ��� ����
		sb1.delete(10, 12);  //10��°���� 12��° �������� ���ڿ��� ����
		System.out.println("5. sb1 = " + sb1);  //sb1 = "hello java@ !!!!!!!!!!!!"
		
		//[deleteCharAt()] : Ư�� ��ġ�� ���ڸ� ����
		sb1.deleteCharAt(10); //10��° ���� �ϳ��� ����
		System.out.println("6. sb1 = " + sb1);  //sb1 = "hello java !!!!!!!!!!!!"
		
		//[replace()] : Ư�� ������ ���ڿ��� �� ���ڿ��� ��ü
		sb1.replace(6, 10, "�ڹ�");
		System.out.println("7. sb1 = " + sb1);  //sb1 = "hello �ڹ� !!!!!!!!!!!!"
		
		//[reverse()] : ���� ���� ���ڿ� ������ �Ųٷ� ��������
		// *String�� reverse()�� �ٸ��� ����, �ѱ� ��� ����
		sb1.reverse()	;
		System.out.println("8. sb1 = " + sb1);  //sb1 = "!!!!!!!!!!!! ���� olleh"
		sb1.reverse();
		
		//[setCharAt()] : Ư�� ��ġ�� ���ڸ� ���� ���ڷ� ����
		sb1.setCharAt(9, '@');
		System.out.println("9. sb1 = " + sb1);  //sb1 = "hello �ڹ� @!!!!!!!!!!!"
		
		// <String ��ü �ȿ�, StringBuffer���� ���ڿ��� �����ϴ� ��
		// 1) ���ڷ� StringBuffer ��ü�� ���� String �����ڸ� ����
		String s1 = new String(sb1);
		// 2) StringBuffer ��ü�� toString()�� �̿��Ͽ� String���� �����Ͽ� ����
		String s2 = sb1.toString();
		
		System.out.println();
		
		///////////////////////////////////////// ���� ////////////////////////////////////////
		//str�� findStr�� �ִ����� ���ο� ����, �ٸ��� ����϶�.
		
		String str = "hello �ڹ� !!!";
		String findStr = "�ڹ�";
//		String findStr = "����Ŭ";
		String replaceStr = "java";
		
		//findStr�� �ִ� ��쿡�� StringBuffer�� ����� ��! (�޸� ����)
		int start = str.indexOf(findStr); // ������ //-1�̸� findStr�� ���� ��, -1 �̻��̸� findStr�� �ִ� ��
		if(start != -1) { //findStr�� �ִٸ�
			StringBuffer sb = new StringBuffer(str);
			int end = start + findStr.length(); //������ ��
			sb.replace(start, end, replaceStr);
			System.out.println(sb);
		} else
			System.out.println(findStr + "�� �����ϴ�.");
			
	}
}
