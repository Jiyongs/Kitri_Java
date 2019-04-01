package com.kitri.array;

// Dto : Data Transfer Object // 객체를 인자로 받아, 객체의 주소값을 이용하여 객체의 필드를 사용함
// 일반적으로 디폴트 생성자만 가진다, getter/setter만 있음
// Vo : Value Object // 필드의 값이 있는 객체 // 기능 메소드를 가진 객체
// Bean // 기능 메소드가 없는 객체

// Dto나 Vo나 상관없음..?

// 1. 하나의 팀 안의 선수를 정의하는 클래스
// 2. 지명타자, 투수, 포수, 1루수, 2루수, 3루수, 유격수, 좌익수, 중견수, 우익수
//         0        1      2      3       4       5        6        7        8         9
// 3. 성적 : 타자는 타율, 투수는 방어율
//             높으면 좋음, 낮으면 좋음
// 4. 9회까지 경기 진행

//방어율 : 9회까지 몇점을 내줬나

public class PlayerDto {
	// [필드]
	private int number; // 등 번호(PK)
	private String name; // 이름
	private int position; // 역할
	private double grade; // 성적
//
//	private String positionName[] = {"지명타자", "투수", "포수",
//											  "1루수", "2루수", "3루수",
//											  "유격수", "좌익수", "중견수", "우익수"};

	//필드 자리에서 객체 생성 가능
	String positionName[] = new String[10];

// 필드 자리에서 객체값 초기화 불가능
// -> 생성자나 메소드 안에서 이루어짐
	
// 	positionName[0] = "지명타자";
//	positionName[1] = "투수";
//	positionName[2] = "포수";
//	positionName[3] = "1루수";
//	positionName[4] = "2루수";
//	positionName[5] = "3루수";
//	positionName[6] = "유격수";
//	positionName[7] = "좌익수";
//	positionName[8] = "중견수";
//	positionName[9] = "우익수";

// [생성자]
	public PlayerDto(int number, String name, int position, double grade) {
		super();
		this.number = number;
		this.name = name;
		this.position = position;
		this.grade = grade;
	}

// [getter/setter]
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {

		return "PlayerDto [등 번호=" + number + "\t선수명=" + name + "\t포지션=" + positionName[position] + 
					(position==0 ? "\t타율=" : "\t방어율=") + grade + "]";

	}

}
