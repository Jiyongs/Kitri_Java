package com.kitri.array;

public class ArrayTest2 {

	public static void main(String[] args) {
		Car car[] = new Car[6];
		
		car[0] = new Car("�Ÿ", "������", "����");
		car[1] = new Car("K5", "���", "���");
		car[2] = new Car("SMS", "����", "�Ｚ");
		car[3] = new Car("�ƹݶ�", "���", "����");
		car[4] = new Car("�Ͼ��", "��ѱ��", "���");
		car[5] = new Car("��Ÿ��", "������", "����");
		
		int len = car.length;
		for(int i = 0; i < len; i++) {
			System.out.println(i + 1 + "��° ���� : " + car[i]);
		}

		// ��ѱ�� �Ͼ��(���)�� 5������ �ֽ��ϴ�.
		//String name = "�Ͼ��";
		
		//QM5�� �����ϴ�.
//		String name = "QM5";
//		int temp =0;
//		for(int i = 0; i < len; i++) {
//			if(name.equals(car[i].getCarName())) {
//				temp = 1;
//				System.out.println(car[i].getColor() + " " + name + "(" + car[i].getMaker() + ")�� " + (i+1) + "��°�� �ֽ��ϴ�.");
//				break; // ã����, for�� ����! (�߿�)
//			}
//		}
//		if(temp==0)
//			System.out.println(name + "�� �����ϴ�.");
//		
		
		////////////////////////////////////////////////////////////
		
		//QM5�� �����ϴ�.
		Car findCar = null;  //��ü�� null�� �ʱ�ȭ
		int count = 0;
		String name = "QM5";
		for(int i = 0; i < len; i++) {
				if(name.equals(car[i].getCarName())) {
					findCar = car[i];  //ã�� ��ü�� �� ��ü�� ����
					count = i + 1;
					break; // ã����, for�� ����! (�߿�)
				}
		}
		
		// ã�Ƴ� ��ü�� main ������ ������ ���߿� ����ϱ� ����!
		// ���߿� class�� �޼ҵ�� ã�Ƴ� ��ü�� ��� Ŭ������ ����ϱ� ���ؼ���,
		// ã�� for������ ã�Ƴ� ��ü�� ���� ������ ���� ����!
		if(findCar != null) {
				System.out.println(findCar.getColor() + " " + name + "(" + findCar.getMaker() + ")�� " + count + "��°�� �ֽ��ϴ�.");
			} else {
				System.out.println(name + "�� �����ϴ�.");
			}
		
		// 6 4 3 ����Ÿ?
		// 
		
		// �����ڴ� ��� �о߿� ������ �ΰ�, �˾Ƶ־� �Ѵ�. �پ��� �о��� ���α׷��� ������ �ϱ� ����.
		
		//System.out.println(car[0].getCarName()); 	//car[0] = null�̶�, nullpointException ����
		
		// Car car[] = new Car[3];   //3���� ������ ���� ��ü�� ���� (����X)

		// ��� ��ü�� �����ڰ� �־�� ������!
		//nullpointException ���� : .���� ��ü�� ���� ���� null�̴�!
		
	}

}
