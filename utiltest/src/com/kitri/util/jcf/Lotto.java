package com.kitri.util.jcf;

import java.util.*;

public class Lotto {

	public static void main(String[] args) {
		Random random = new Random();
		
		// 제네릭 타입에 들어갈 수 있는 것은 Object만 가능하므로, int가 아니라 Integer를 넣어야 함!
		Set<Integer> numSet = new HashSet<Integer>();  //Set은 중복값 불가능 -> 렌덤값의 같은 값 여부 비교 필요 x
		
		while(true) {
			numSet.add(random.nextInt(45)+1);  //random.nextInt(45) : 1~44
			if(numSet.size()==6) //중복값 없이 6개가 들어갔다면,
				break;
		}
		
		Integer[] result = numSet.toArray(new Integer[0]);
		
		System.out.print("로또 번호 : ");
		int len = result.length;
		for (int i = 0; i < len; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
