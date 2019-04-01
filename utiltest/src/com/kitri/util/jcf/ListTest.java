package com.kitri.util.jcf;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();  // List�� ���� ��� ����
		
		System.out.println("list size == " + list.size()); // 0
		
		list.add("����");
		list.add("������");
		list.add("�ڰǿ�");
		list.add("����ȯ");
		System.out.println("list size == " + list.size());  // 4
		System.out.println("�λ��� Ÿ�� ==");
		

		int len = list.size();
		for(int i = 0 ; i < len; i++) {
			System.out.println(i+1 + "��° " + list.get(i));
		}
				
		System.out.println("---------------------------------------------------");
		
		///////////////////////////////////////
		String name = "������";
		int name_idx=0;
		for(int i = 0 ; i < len; i++) {
			if(list.get(i).equals(name)) {
				name_idx = i;
				System.out.println(name + "�� "+ i + "�� Ÿ�� �Դϴ�.");
				break;
				}
		}

		String name2 = "�����";
		System.out.println(name + "�� " + name2 + "���� ��ü");
		list.set(name_idx, name2); //set(idx, �� ��) : list�� idx��°�� �� ������ ����
		
		System.out.println("---------------------------------------------------");
		
		len = list.size();
		for(int i = 0 ; i < len; i++) {
			System.out.println(i+1 + "��° " + list.get(i));
		}
		
	}
}
