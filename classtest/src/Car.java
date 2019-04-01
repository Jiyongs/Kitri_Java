public class Car {
	String carName;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ;
	String color;
	String maker;
	int speed;

	//Defalt 생성자가 생략되어 있다
	//public Car() { }

	// 가속 (+10)
	public void speedUp(){
		speed += 10;
	}
	// 감속 (-10)
	public void speedDown() {
		speed -= 10;
		//speed가 음수값을 가지지 않도록 설정
		if(speed < 0)
			stop();
	}
	// 정지
	public void stop() {
		speed = 0; 
	}									  

}
