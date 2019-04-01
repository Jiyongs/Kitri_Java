package com.kitri.util.jcf;

import java.util.ArrayList;
import java.util.List;

public class DramaListTest {

	public static void main(String[] args) {
		
		TVProgram tv1 = new Drama("그 겨울, 바람이 분다", "SBS", "김규태", "조인성", "송혜교");
		TVProgram tv2 = new Drama("백년의 유산", "MBC", "주성우", "", "");
		TVProgram tv3 = new Drama("아이리스2", "KBS", "표민수", "장혁", "이다해");
		TVProgram tv4 = new Drama("최고다 이순신", "KBS", "윤성식", "", "아이유");
		
		List<TVProgram> tvList = new ArrayList<TVProgram>();
		tvList.add(tv1);
		tvList.add(tv2);
		tvList.add(tv3);
		tvList.add(tv4);
		
		System.out.println("<< ArrayList를 이용한 드라마정보 >>");
		int len = tvList.size();
		for(int i = 0; i < len; i++) {
			System.out.println(tvList.get(i));
		}
		
	}

}
