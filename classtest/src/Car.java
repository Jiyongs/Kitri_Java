public class Car {
	String carName;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ;
	String color;
	String maker;
	int speed;

	//Defalt �����ڰ� �����Ǿ� �ִ�
	//public Car() { }

	// ���� (+10)
	public void speedUp(){
		speed += 10;
	}
	// ���� (-10)
	public void speedDown() {
		speed -= 10;
		//speed�� �������� ������ �ʵ��� ����
		if(speed < 0)
			stop();
	}
	// ����
	public void stop() {
		speed = 0; 
	}									  

}
