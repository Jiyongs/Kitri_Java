package com.kitri.array;

public class ArrayTest2 {

	public static void main(String[] args) {
		Car car[] = new Car[6];
		
		car[0] = new Car("쏘나타", "검정색", "현대");
		car[1] = new Car("K5", "흰색", "기아");
		car[2] = new Car("SMS", "은색", "삼성");
		car[3] = new Car("아반떼", "흰색", "현대");
		car[4] = new Car("니어로", "비둘기색", "기아");
		car[5] = new Car("싼타페", "검정색", "현대");
		
		int len = car.length;
		for(int i = 0; i < len; i++) {
			System.out.println(i + 1 + "번째 구역 : " + car[i]);
		}

		// 비둘기색 니어로(기아)는 5번쨰에 있습니다.
		//String name = "니어로";
		
		//QM5는 없습니다.
//		String name = "QM5";
//		int temp =0;
//		for(int i = 0; i < len; i++) {
//			if(name.equals(car[i].getCarName())) {
//				temp = 1;
//				System.out.println(car[i].getColor() + " " + name + "(" + car[i].getMaker() + ")는 " + (i+1) + "번째에 있습니다.");
//				break; // 찾으면, for문 종료! (중요)
//			}
//		}
//		if(temp==0)
//			System.out.println(name + "는 없습니다.");
//		
		
		////////////////////////////////////////////////////////////
		
		//QM5는 없습니다.
		Car findCar = null;  //객체는 null로 초기화
		int count = 0;
		String name = "QM5";
		for(int i = 0; i < len; i++) {
				if(name.equals(car[i].getCarName())) {
					findCar = car[i];  //찾은 객체를 빈 객체에 넣음
					count = i + 1;
					break; // 찾으면, for문 종료! (중요)
				}
		}
		
		// 찾아낸 객체를 main 안으로 빼내야 나중에 사용하기 좋음!
		// 나중에 class의 메소드로 찾아낸 객체를 모든 클래스가 사용하기 위해서는,
		// 찾는 for문에서 찾아낸 객체를 따로 빼내는 것이 좋음!
		if(findCar != null) {
				System.out.println(findCar.getColor() + " " + name + "(" + findCar.getMaker() + ")는 " + count + "번째에 있습니다.");
			} else {
				System.out.println(name + "는 없습니다.");
			}
		
		// 6 4 3 병살타?
		// 
		
		// 개발자는 모든 분야에 관심을 두고, 알아둬야 한다. 다양한 분야의 프로그램을 만들어야 하기 때문.
		
		//System.out.println(car[0].getCarName()); 	//car[0] = null이라, nullpointException 에러
		
		// Car car[] = new Car[3];   //3개의 공간을 가진 객체를 만듦 (생성X)

		// 모든 객체는 생성자가 있어야 생성됨!
		//nullpointException 에러 : .앞의 객체가 가진 값이 null이다!
		
	}

}
