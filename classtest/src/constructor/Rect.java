package constructor;

/*
1. ���� width, ���� height
2. ���� : calcArea()
   �ѷ� : calcRound()
*/

public class Rect {
	int width;
	int height;

// [������]
	// ����Ʈ ������
	public Rect(){
		this(4,3);
	}
	//����� ���� ������
	public Rect(int width, int height){
		this.width = width;
		this.height = height;
	}

// [�޼ҵ�]
	//���� ���ϱ�
	public int calcArea(){
		return width * height;
	}
	//�ѷ� ���ϱ�
	public int calcRound() {
		return width*2 + height*2;
	}

	//���� ����ϱ�
	public void info(){
		System.out.println("���ΰ� " + width + "�̰� ���ΰ� " + height + "�� �簢���� ���̴� " + calcArea() + "�̰� �ѷ��� " + calcRound() + "�Դϴ�.");
	}
}
