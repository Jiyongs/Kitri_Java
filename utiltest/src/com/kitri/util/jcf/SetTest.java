package com.kitri.util.jcf;

import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Ȳ����");
		set.add("�ڹ̷�");
		set.add("������");
		set.add("������");
		set.add("�ڹ̷�");
		System.out.println("set�� ũ�� : " + set.size());
		
		// Set�� �� �̾Ƴ��� ��� 3����
		
		// 1) Set�� �޼ҵ� toArray() : Object �迭�� �����Ͽ�, String���� ����ȯ�ؾ� �ϴ� �������� ����
//		Object[] str = set.toArray();
//		int len = str.length;
//		for (int i = 0; i < len; i++) {
//			System.out.println((String) str[i]);
//		}
		
		// 2) Set�� �޼ҵ� toArray(T t[]);  :  t[]�� ũ�⸦ 0���� ������ָ� �� / ���� ������� ����ȯ ������ ������ �� ����
		String str[] = set.toArray(new String[0]);
		int len = str.length;
		for (int i = 0; i < len; i++) {
			System.out.println(str[i]);
		}
		
		System.out.println("-------------------------------------------");
		
		// 3) Set�� �޼ҵ� iterator() : Iterator���� ������
		// Iterator�� �޼ҵ� hasNext() & next() ����Ͽ� ���� �̾Ƴ�
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}
