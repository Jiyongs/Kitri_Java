package com.kitri.util.jcf;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {
		Random random = new Random();
		
		// ���׸� Ÿ�Կ� �� �� �ִ� ���� Object�� �����ϹǷ�, int�� �ƴ϶� Integer�� �־�� ��!
		Set<Integer> numSet = new HashSet<Integer>();  //Set�� �ߺ��� �Ұ��� -> �������� ���� �� ���� �� �ʿ� x
		
		while(true) {
			numSet.add(random.nextInt(45)+1);  //random.nextInt(45) : 1~44
			if(numSet.size()==6) //�ߺ��� ���� 6���� ���ٸ�,
				break;
		}
		
		Integer[] result = numSet.toArray(new Integer[0]);
		
		System.out.print("�ζ� ��ȣ : ");
		int len = result.length;
		for (int i = 0; i < len; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
