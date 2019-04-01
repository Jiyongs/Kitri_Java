package com.kitri.util.jcf;

import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("황선혜");
		set.add("박미래");
		set.add("이혜린");
		set.add("조윤영");
		set.add("박미래");
		System.out.println("set의 크기 : " + set.size());
		
		// Set의 값 뽑아내기 방법 3가지
		
		// 1) Set의 메소드 toArray() : Object 배열을 리턴하여, String으로 형변환해야 하는 불편함이 있음
//		Object[] str = set.toArray();
//		int len = str.length;
//		for (int i = 0; i < len; i++) {
//			System.out.println((String) str[i]);
//		}
		
		// 2) Set의 메소드 toArray(T t[]);  :  t[]는 크기를 0으로 만들어주면 됨 / 위의 방법에서 형변환 과정을 생략할 수 있음
		String str[] = set.toArray(new String[0]);
		int len = str.length;
		for (int i = 0; i < len; i++) {
			System.out.println(str[i]);
		}
		
		System.out.println("-------------------------------------------");
		
		// 3) Set의 메소드 iterator() : Iterator형을 리턴함
		// Iterator의 메소드 hasNext() & next() 사용하여 값을 뽑아냄
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}
