package com.kitri.util.jcf;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {

	public static void main(String[] args) {
		
		TVProgram tv1 = new Drama("�� �ܿ�, �ٶ��� �д�", "SBS", "�����", "���μ�", "������");
		TVProgram tv2 = new Drama("����� ����", "MBC", "�ּ���", "", "");
		TVProgram tv3 = new Drama("���̸���2", "KBS", "ǥ�μ�", "����", "�̴���");
		TVProgram tv4 = new Drama("�ְ�� �̼���", "KBS", "������", "", "������");
		
		List<TVProgram> tvList = new ArrayList<TVProgram>();
		tvList.add(tv1);
		tvList.add(tv2);
		tvList.add(tv3);
		tvList.add(tv4);
		
		System.out.println("<< ArrayList�� �̿��� ������� >>");
		int len = tvList.size();
		for(int i = 0; i < len; i++) {
			System.out.println(tvList.get(i));
		}
		
	}

}
