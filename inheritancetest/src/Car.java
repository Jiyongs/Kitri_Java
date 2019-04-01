public class Car {
		// [ 필드 ]
		String carName;
		String color;
		String maker;
		int speed;

		// [ 생성자 ]
		public Car() {
			this("쏘나타", "검정색", "현대");  //this() : 자기 클래스 생성자 호출 함수
		}

		public Car(String color) {
			this("쏘나타", color, "현대");
		}

		public Car(String carName, String color) {
			this(carName, color, "현대");
		}

		public Car(String carName, String color, String maker) {
			//super();가 생략되어 있음 --> Object 클래스의 생성자를 호출하기 위함(Object가 메모리에 올라가야 사용 가능하기 때문)
			this.carName = carName;
			this.color = color;
			this.maker = maker;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
		}

		// [ 메소드 ]
		int speedUp(int speed){
			this.speed += speed;
			return this.speed;
		}

		int speedDown(int speed){
			this.speed -= speed;
			if(this.speed < 0) 
				stop();
			return this.speed;
		}

		void stop(){
			speed = 0;
		}


		@Override
		public String toString() {
			return maker + "에서 만든 " + color + " " + carName;
		}

		//차이름이 같으면, true를 리턴 [Object  비교함수인 equals() 오버라이딩]
		@Override
		public boolean equals(Object obj){
			//Car car = obj;      //obj는 Car보다 상위이므로, obj->Car 변환 시 명시적 형변환 필요
			Car car = (Car) obj;
			//if(carName == car.carName)  // ""일 경우는 true, new String("")일 경우는 false
			if(carName.equals(car.carName))
				return true;
			return false;
		}



		//boolean result = false;

		// [객체 생성 안 한 문자열의 비교]
		//String s1 = "abc";
		//String s2 = "abc";

		//result = s1.equals(s2); -> 결과 : true   //String클래스가 Object 클래스의 equals()를 오버라이딩 해서, 문자열""을 비교하는 함수를 만들었기 때문
		//result = (s1==s2);      -> 결과 : true

		// [객체 생성한 문자열의 비교]
		//String s3 = new String("abc");
		//String s4 = new String("abc");

		//result = s3.equals(s4); -> 결과 : true
		//result = (s3==s4);      -> 결과 : false



		// [상속 클래스간의 강제 형변환]
		// 상위 클래스 객체인 car를 하위 클래스 객체인 t에 집어넣기 위해 강제 형변환

		//Car car = new Car();   //car가 할당받은 것은 Car()의 주소값 //Object(), Car() 주소값과 모두 연결되어 있음 *Taxi()는 없음
		//Taxi t = new Taxi();
		//t = (Taxi) car;            //컴파일 O, 실행 X  //문법적으로 오류가 x므로, 컴파일이 됨. car는 Taxi()를 만든적이 없으므로 Taxi로 형변환될 수 없으므로 실행 X

		//Car car = new Taxi();  //car가 할당받은 것은 Taxi()의 주소값 //Object(), Car(), Taxi() 주소값과 모두 연결되어 있음 
		//Taxi t = new Taxi();
		//t = (Taxi) car;            //컴파일 O, 실행 O

		// [다른 형끼리의 강제 형변환]
		//1. 강제 형변환은 기본형-기본형, 참조형-참조형끼리만 가능
		//2. 바꿀 수 있는 값을 고려 (ex: true -> int 불가)
		// String s = "123";
		// int x = (int) s;

		//추상 클래스
		//자기자신의 생성자 호출 불가
		//Calender cal = new Calender();  // X
		//Calender cal = new 


}
