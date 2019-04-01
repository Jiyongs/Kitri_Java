package com.kitri.array;

// Dto : Data Transfer Object // ��ü�� ���ڷ� �޾�, ��ü�� �ּҰ��� �̿��Ͽ� ��ü�� �ʵ带 �����
// �Ϲ������� ����Ʈ �����ڸ� ������, getter/setter�� ����
// Vo : Value Object // �ʵ��� ���� �ִ� ��ü // ��� �޼ҵ带 ���� ��ü
// Bean // ��� �޼ҵ尡 ���� ��ü

// Dto�� Vo�� �������..?

// 1. �ϳ��� �� ���� ������ �����ϴ� Ŭ����
// 2. ����Ÿ��, ����, ����, 1���, 2���, 3���, ���ݼ�, ���ͼ�, �߰߼�, ���ͼ�
//         0        1      2      3       4       5        6        7        8         9
// 3. ���� : Ÿ�ڴ� Ÿ��, ������ �����
//             ������ ����, ������ ����
// 4. 9ȸ���� ��� ����

//����� : 9ȸ���� ������ ���ᳪ

public class PlayerDto {
	// [�ʵ�]
	private int number; // �� ��ȣ(PK)
	private String name; // �̸�
	private int position; // ����
	private double grade; // ����
//
//	private String positionName[] = {"����Ÿ��", "����", "����",
//											  "1���", "2���", "3���",
//											  "���ݼ�", "���ͼ�", "�߰߼�", "���ͼ�"};

	//�ʵ� �ڸ����� ��ü ���� ����
	String positionName[] = new String[10];

// �ʵ� �ڸ����� ��ü�� �ʱ�ȭ �Ұ���
// -> �����ڳ� �޼ҵ� �ȿ��� �̷����
	
// 	positionName[0] = "����Ÿ��";
//	positionName[1] = "����";
//	positionName[2] = "����";
//	positionName[3] = "1���";
//	positionName[4] = "2���";
//	positionName[5] = "3���";
//	positionName[6] = "���ݼ�";
//	positionName[7] = "���ͼ�";
//	positionName[8] = "�߰߼�";
//	positionName[9] = "���ͼ�";

// [������]
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

		return "PlayerDto [�� ��ȣ=" + number + "\t������=" + name + "\t������=" + positionName[position] + 
					(position==0 ? "\tŸ��=" : "\t�����=") + grade + "]";

	}

}
