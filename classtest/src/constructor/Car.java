package constructor;

public class Car {
		// [ Car class�� �ʵ�(=�Ӽ�) ]
		String carName;
		String color;
		String maker;
		int speed;

		// [ Car class�� ����� ���� ������ ]
		// (��ü �ʱ�ȭ)
		public Car() {
			/*
			carName = "�Ÿ";
			color = "������";
			maker = "����";
			*/
			this("�Ÿ", "������", "����"); //this() : �ڱ� Ŭ���� ������ ȣ�� �Լ�
		}

		public Car(String color) {
			/*
			carName = "�Ÿ";
			this.color = color;   //this.color = Car class�� ��������
									 //color = Car() �������� �Ű�����(��������)
			maker = "����";
			*/
			this("�Ÿ", color, "����");
		}

		public Car(String carName, String color) {
			/*
			this.carName = carName;
			this.color = color;
			maker = "����";
			*/
			this(carName, color, "����");
		}

		public Car(String carName, String color, String maker) {
			this.carName = carName;
			this.color = color;
			this.maker = maker;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
		}

		// [ Car class�� �޼ҵ� ]
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
			return "���̸� : " + carName + "    ���� : " + color + "    ������ : " + maker;
		}
}
