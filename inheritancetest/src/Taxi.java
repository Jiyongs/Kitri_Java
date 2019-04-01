/*
1. 요금
   - 기본요금(basicPrice)
	    일반 : 3800
	    심야 : 5000
   - 요금합(totalPrice)
   - 요금(price)
   	    일반 : 100/km
	    심야 : 150/km
2. 요금 계산(calcPrice())
3. 심야할증 : 0시 ~ 6시
*/
import java.util.*;

public class Taxi extends Car{
// [ field ]
	int basicPrice;
	int totalPrice;
	int price;

	int pricePerTime;


// [ 생성자 ]
	public Taxi(){
		//super(); 생략되어있음 --> 상위 클래스의 디폴트 생성자 호출
	}

	//상속받는 Car 클래스의 사용자정의 생성자를 overriding (재구성)
	public Taxi(String carName, String color, String maker) {
			super(carName, color, maker);
	}

// [ method ]
	//손님 탔을 때
	void initPrice() {
		//현재 시간 얻기
		Calendar calender = Calendar.getInstance();
		int hour = calender.get(Calendar.HOUR_OF_DAY);

		if(hour <6){
			//심야 요금일 때,
			basicPrice = 5000;
			pricePerTime = 150;
		} else {
			//일반 요금일 때,
			basicPrice = 3800;
			pricePerTime = 100;
		}
	}

	//요금 계산
	int calcPrice(int km){
			price = basicPrice + (km * pricePerTime);
			return price;
		}

	//손님 내릴 때
	void sumPrice() {
		totalPrice += price;
		price = 0;
		basicPrice = 0; // 안 해도 되긴 하지만, 다른 메소드가 생기고, 그 안에서 basicPrice를 사용했을 때를 대비하는 것.
	}

	//오버라이딩
	@Override
	public int speedUp(int speed){
		speed += super.speedUp(speed);
		if(speed > 150)
			this.speed = 150;
		return this.speed;
	}

	@Override
	public String toString() {
		return super.toString() + "택시";
	}

//오버라이딩시 public 해야하는 이유?

}

//버스 탑승인원 관리 // 1번 정거장에서 3명 탑승 // 2번 정거장에서 2명 탑승 후, 1명 하차
//max = 50명 // 정원 초과 시, 몇명은 타고 몇명은 못 탔다를 뽑아내기