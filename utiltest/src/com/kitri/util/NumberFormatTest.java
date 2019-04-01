package com.kitri.util;

import java.text.DecimalFormat;
import java.text.Format;

public class NumberFormatTest {

	public static void main(String[] args) {
// 34,563,242,365,453.13 �������� �̱�
		
		//[Format] - [NumberFormat] - [DecimalFormat]
		
		double number = 3563242365453.126;
		// *double ���� �Ҽ��� ���ڸ��� 16�ڸ������� ����
		
		Format numf = new DecimalFormat("##,###,###,###,###.##");
		String result = numf.format(number);
		
		System.out.println(result);
		
		
	}

}
