/*
1. ���
   - �⺻���(basicPrice)
	    �Ϲ� : 3800
	    �ɾ� : 5000
   - �����(totalPrice)
   - ���(price)
   	    �Ϲ� : 100/km
	    �ɾ� : 150/km
2. ��� ���(calcPrice())
3. �ɾ����� : 0�� ~ 6��
*/
import java.util.*;

public class Taxi extends Car{
// [ field ]
	int basicPrice;
	int totalPrice;
	int price;

	int pricePerTime;


// [ ������ ]
	public Taxi(){
		//super(); �����Ǿ����� --> ���� Ŭ������ ����Ʈ ������ ȣ��
	}

	//��ӹ޴� Car Ŭ������ ��������� �����ڸ� overriding (�籸��)
	public Taxi(String carName, String color, String maker) {
			super(carName, color, maker);
	}

// [ method ]
	//�մ� ���� ��
	void initPrice() {
		//���� �ð� ���
		Calendar calender = Calendar.getInstance();
		int hour = calender.get(Calendar.HOUR_OF_DAY);

		if(hour <6){
			//�ɾ� ����� ��,
			basicPrice = 5000;
			pricePerTime = 150;
		} else {
			//�Ϲ� ����� ��,
			basicPrice = 3800;
			pricePerTime = 100;
		}
	}

	//��� ���
	int calcPrice(int km){
			price = basicPrice + (km * pricePerTime);
			return price;
		}

	//�մ� ���� ��
	void sumPrice() {
		totalPrice += price;
		price = 0;
		basicPrice = 0; // �� �ص� �Ǳ� ������, �ٸ� �޼ҵ尡 �����, �� �ȿ��� basicPrice�� ������� ���� ����ϴ� ��.
	}

	//�������̵�
	@Override
	public int speedUp(int speed){
		speed += super.speedUp(speed);
		if(speed > 150)
			this.speed = 150;
		return this.speed;
	}

	@Override
	public String toString() {
		return super.toString() + "�ý�";
	}

//�������̵��� public �ؾ��ϴ� ����?

}

//���� ž���ο� ���� // 1�� �����忡�� 3�� ž�� // 2�� �����忡�� 2�� ž�� ��, 1�� ����
//max = 50�� // ���� �ʰ� ��, ����� Ÿ�� ����� �� ���ٸ� �̾Ƴ���