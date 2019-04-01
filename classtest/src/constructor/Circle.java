package constructor;

/*
1. ������ radius
2. ���� : calcArea()     - ������^2 * 3.14
   �ѷ� : calcRound()   - 2 * ������ * 3.14
*/
public class Circle {

	int radius;

// [������]
	// ����Ʈ ������
	public Circle(){
		this(4);
	}
	//����� ���� ������
	public Circle(int radius){
		this.radius = radius;
	}

// [�޼ҵ�]
	//���� ���ϱ�
	public double calcArea(){
		return Math.PI * Math.pow(radius,2);
	}
	//�ѷ� ���ϱ�
	public double calcRound(){
		return 2 * radius * Math.PI;
	}
	//���� ����ϱ�
	public void info(){
		System.out.println("�������� " + radius + "�� ���� ���̴� " + calcArea() + "�̰� �ѷ��� " + calcRound() +"�Դϴ�.");
	}
}
