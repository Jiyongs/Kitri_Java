package com.kitri.lang;

public class StringVSBuffer {

	public static void main(String[] args) {
		// *��κ��� ���ڿ� ������, ���ڿ� + ���ڿ�
		// *���ڿ��� ���տ���, String�� StringBuffer�� ����!
		
		long st = System.nanoTime();  //���� �ð�
//		String str = "hello ";
//		for (int i = 0; i < 5000; i++) {
//			str += i;
//		}
		// 500�� �ݺ� ��, String ���� �ð�   : 1010966 ...
		// 5000�� �ݺ� ��, String ���� �ð�  : 46120485 ...
		
		StringBuffer sb = new StringBuffer("hello ");
		for (int i = 0; i < 5000; i++) {
			sb.append(i);
		}		
		// 500�� �ݺ� ��, StringBuffer ���� �ð�  : 256269 ...
		// 5000�� �ݺ� ��, StringBuffer ���� �ð� : 1035342 ...
		System.out.println(System.nanoTime() - st); //���� �ð�
		
		
		// *��� : ���ڿ� ���� ��, StringBuffer�� �� ������
		//          ������ ���ڿ��� ������ String, �� ���ڿ��� ������ StringBuffer�� ����!
		
	}

}
