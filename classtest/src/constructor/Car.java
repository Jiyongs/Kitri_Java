package constructor;

public class Car {
		// [ Car class의 필드(=속성) ]
		String carName;
		String color;
		String maker;
		int speed;

		// [ Car class의 사용자 정의 생성자 ]
		// (객체 초기화)
		public Car() {
			/*
			carName = "쏘나타";
			color = "검정색";
			maker = "현대";
			*/
			this("쏘나타", "검정색", "현대"); //this() : 자기 클래스 생성자 호출 함수
		}

		public Car(String color) {
			/*
			carName = "쏘나타";
			this.color = color;   //this.color = Car class의 전역변수
									 //color = Car() 생성자의 매개변수(지역변수)
			maker = "현대";
			*/
			this("쏘나타", color, "현대");
		}

		public Car(String carName, String color) {
			/*
			this.carName = carName;
			this.color = color;
			maker = "현대";
			*/
			this(carName, color, "현대");
		}

		public Car(String carName, String color, String maker) {
			this.carName = carName;
			this.color = color;
			this.maker = maker;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
		}

		// [ Car class의 메소드 ]
		public void speedUp(){
			speed += 10;
		}

		public int speedUp(int speed){
			this.speed += speed;
			return this.speed;
		}

		public void speedDown(){
			speed -= 10;
			if(speed < 0)	stop();
		}

		public int speedDown(int speed){
			this.speed -= speed;
			if(this.speed < 0) 
				stop();
			return this.speed;
		}

		public void stop(){
			speed = 0;
		}

		public String info() {
			return "차이름 : " + carName + "    색상 : " + color + "    제조사 : " + maker;
		}
}
