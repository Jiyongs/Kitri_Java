package com.kitri.util.jcf;

import java.util.*;

public class CollectionTest {
	
	public static void main(String[] args) {
//		Collection coll = new ArrayList(); //����o + �ߺ���x
		Collection coll = new HashSet(); //����x + �ߺ���x
		
		System.out.println("�ʱ� ũ�� : "+ coll.size()); //0
		coll.add("ȫ�浿");
		coll.add("�̼���");
		coll.add("������");
		coll.add("������");
		coll.add("ȫ�浿");
		System.out.println("������ ũ�� : "+ coll.size()); //4
		
		Object ob[] = coll.toArray();
		int len = ob.length;
		for (int i = 0; i < len; i++) {
			System.out.println((String)ob[i]);  //String���� �� ��ȯ!			
		}
		
	}
	
}
