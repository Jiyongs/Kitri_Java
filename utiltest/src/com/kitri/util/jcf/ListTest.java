package com.kitri.util.jcf;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();  // List는 순서 상관 있음
		
		System.out.println("list size == " + list.size()); // 0
		
		list.add("허경민");
		list.add("정수빈");
		list.add("박건우");
		list.add("김재환");
		System.out.println("list size == " + list.size());  // 4
		System.out.println("두산의 타순 ==");
		

		int len = list.size();
		for(int i = 0 ; i < len; i++) {
			System.out.println(i+1 + "번째 " + list.get(i));
		}
				
		System.out.println("---------------------------------------------------");
		
		///////////////////////////////////////
		String name = "정수빈";
		int name_idx=0;
		for(int i = 0 ; i < len; i++) {
			if(list.get(i).equals(name)) {
				name_idx = i;
				System.out.println(name + "은 "+ i + "번 타자 입니다.");
				break;
				}
		}

		String name2 = "오재원";
		System.out.println(name + "을 " + name2 + "으로 교체");
		list.set(name_idx, name2); //set(idx, 새 값) : list의 idx번째를 새 값으로 세팅
		
		System.out.println("---------------------------------------------------");
		
		len = list.size();
		for(int i = 0 ; i < len; i++) {
			System.out.println(i+1 + "번째 " + list.get(i));
		}
		
	}
}
