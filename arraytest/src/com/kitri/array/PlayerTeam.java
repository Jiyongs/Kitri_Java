package com.kitri.array;

public class PlayerTeam {

	public static void main(String[] args) {
		PlayerDto player[] = new PlayerDto[5];
		
		PlayerDto p1 = new PlayerDto(24, "오재원", 4, 0.321);
		PlayerDto p2 = new PlayerDto(13, "허경민", 5, 0.351);
		PlayerDto p3 = new PlayerDto(14, "린드블럼", 1, 0.001);
		PlayerDto p4 = new PlayerDto(9, "페르난데스", 3, 0.421);
		PlayerDto p5 = new PlayerDto(38, "김대한", 7, 0.384);
		
		player[0] = p1;
		player[1] = p2;
		player[2] = p3;
		player[3] = p4;
		player[4] = p5;
		
		
		// player.length가 for문안에 있기때문에 여러번 메모리 참조(.)를 함
		// 안 좋은 코드
//		for(int i = 0; i < player.length; i++) {
//		}
	
		int len = player.length;
		for (int i = 0; i < len; i++) {
			System.out.println(player[i]);
		}
		

		
	}
	
	
	
}
