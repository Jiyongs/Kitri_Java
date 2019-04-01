package com.kitri.util.jcf;

import java.util.*;

public class CollectionTest {
	
	public static void main(String[] args) {
//		Collection coll = new ArrayList(); //순서o + 중복값x
		Collection coll = new HashSet(); //순서x + 중복값x
		
		System.out.println("초기 크기 : "+ coll.size()); //0
		coll.add("홍길동");
		coll.add("이순신");
		coll.add("강감찬");
		coll.add("윤봉길");
		coll.add("홍길동");
		System.out.println("마지막 크기 : "+ coll.size()); //4
		
		Object ob[] = coll.toArray();
		int len = ob.length;
		for (int i = 0; i < len; i++) {
			System.out.println((String)ob[i]);  //String으로 형 변환!			
		}
		
	}
	
}
