public class Car {
		// [ �ʵ� ]
		String carName;
		String color;
		String maker;
		int speed;

		// [ ������ ]
		public Car() {
			this("�Ÿ", "������", "����");  //this() : �ڱ� Ŭ���� ������ ȣ�� �Լ�
		}

		public Car(String color) {
			this("�Ÿ", color, "����");
		}

		public Car(String carName, String color) {
			this(carName, color, "����");
		}

		public Car(String carName, String color, String maker) {
			//super();�� �����Ǿ� ���� --> Object Ŭ������ �����ڸ� ȣ���ϱ� ����(Object�� �޸𸮿� �ö󰡾� ��� �����ϱ� ����)
			this.carName = carName;
			this.color = color;
			this.maker = maker;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
		}

		// [ �޼ҵ� ]
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
			return maker + "���� ���� " + color + " " + carName;
		}

		//���̸��� ������, true�� ���� [Object  ���Լ��� equals() �������̵�]
		@Override
		public boolean equals(Object obj){
			//Car car = obj;      //obj�� Car���� �����̹Ƿ�, obj->Car ��ȯ �� ����� ����ȯ �ʿ�
			Car car = (Car) obj;
			//if(carName == car.carName)  // ""�� ���� true, new String("")�� ���� false
			if(carName.equals(car.carName))
				return true;
			return false;
		}



		//boolean result = false;

		// [��ü ���� �� �� ���ڿ��� ��]
		//String s1 = "abc";
		//String s2 = "abc";

		//result = s1.equals(s2); -> ��� : true   //StringŬ������ Object Ŭ������ equals()�� �������̵� �ؼ�, ���ڿ�""�� ���ϴ� �Լ��� ������� ����
		//result = (s1==s2);      -> ��� : true

		// [��ü ������ ���ڿ��� ��]
		//String s3 = new String("abc");
		//String s4 = new String("abc");

		//result = s3.equals(s4); -> ��� : true
		//result = (s3==s4);      -> ��� : false



		// [��� Ŭ�������� ���� ����ȯ]
		// ���� Ŭ���� ��ü�� car�� ���� Ŭ���� ��ü�� t�� ����ֱ� ���� ���� ����ȯ

		//Car car = new Car();   //car�� �Ҵ���� ���� Car()�� �ּҰ� //Object(), Car() �ּҰ��� ��� ����Ǿ� ���� *Taxi()�� ����
		//Taxi t = new Taxi();
		//t = (Taxi) car;            //������ O, ���� X  //���������� ������ x�Ƿ�, �������� ��. car�� Taxi()�� �������� �����Ƿ� Taxi�� ����ȯ�� �� �����Ƿ� ���� X

		//Car car = new Taxi();  //car�� �Ҵ���� ���� Taxi()�� �ּҰ� //Object(), Car(), Taxi() �ּҰ��� ��� ����Ǿ� ���� 
		//Taxi t = new Taxi();
		//t = (Taxi) car;            //������ O, ���� O

		// [�ٸ� �������� ���� ����ȯ]
		//1. ���� ����ȯ�� �⺻��-�⺻��, ������-������������ ����
		//2. �ٲ� �� �ִ� ���� ��� (ex: true -> int �Ұ�)
		// String s = "123";
		// int x = (int) s;

		//�߻� Ŭ����
		//�ڱ��ڽ��� ������ ȣ�� �Ұ�
		//Calender cal = new Calender();  // X
		//Calender cal = new 


}
