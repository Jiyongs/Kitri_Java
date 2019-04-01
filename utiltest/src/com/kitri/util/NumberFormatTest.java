package com.kitri.util;

import java.text.DecimalFormat;
import java.text.Format;

public class NumberFormatTest {

	public static void main(String[] args) {
// 34,563,242,365,453.13 형식으로 뽑기
		
		//[Format] - [NumberFormat] - [DecimalFormat]
		
		double number = 3563242365453.126;
		// *double 안의 소수점 앞자리가 16자리까지만 가능
		
		Format numf = new DecimalFormat("##,###,###,###,###.##");
		String result = numf.format(number);
		
		System.out.println(result);
		
		
	}

}
