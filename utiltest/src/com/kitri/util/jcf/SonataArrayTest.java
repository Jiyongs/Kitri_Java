package com.kitri.util.jcf;

public class SonataArrayTest {
	public static void main(String[] args) {
		System.out.println("========================= Sonata ���� ���� =========================");
		Car car1 = new Sonata("���", 5000, "NF", "�¿�");
		Car car2 = new Sonata("����", 7000, "Brilliant", "����");
		Car car3 = new Sonata("��ȫ��", 4000, "EF", "�ý�");
		Car car4 = new Sonata("������", 6000, "Hybrid", "�¿�");
	
		Car[] carArray = new Car[4];
		carArray[0] = car1;
		carArray[1] = car2;
		carArray[2] = car3;
		carArray[3] = car4;
		
		int len = carArray.length;
		for (int i = 0; i < len; i++) {
			System.out.println(carArray[i]);
		}
		
	}
}
