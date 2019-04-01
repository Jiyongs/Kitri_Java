package constructor;

/*
1. ü�� hp 100, ��� mode 0 (0 : �Ϲ�, 1 : ���)
2. ���� attack()
      - 1ȸ ���ݴ� ���� ü�� (�Ϲݸ�� : -10, ��и�� : -15)
   ��庯�� changeMode()
      - �� ü�� -25
	  - �� ü�� 40������ ���� ���� �Ұ�

	** call by value
	** call by reference : ��ü�� �Ű������� ���޵� ��, ��ü�� ���� �ƴ� �ּҰ��� �����Ѵ�.
*/
public class Marine {
// [�ʵ�]
	int hp;
	int mode;

	int power;			    //��庰 ���ݷ�
	boolean gameOver;   //���ӿ��� ����                            

// [������]
	// ����Ʈ ������
	public Marine(){
		this(100, 0, 10, false);
	}
	// ����� ���� ������
	public Marine(int hp, int mode, int power, boolean gameOver){
		this.hp = hp;
		this.mode = mode;
		this.power = power;
		this.gameOver = gameOver;
	}

// [�޼ҵ�]
	//����
	public void attack(int count, Marine enemy) {
		if(enemy.hp>0){
				enemy.hp -= power * count;
					if(enemy.hp <= 0) {
						//���� ����
						gameOver = true;
					} 
			} else
				//���� ����
				gameOver = true;
	}

	//��� ����
	public void changeMode(){
		if(hp > 40){
			mode = 1;
			hp -= 25;
			power = 15;
		} else {
			System.out.println("��� : ��� ���� �Ұ�~!!!!");
		}
	}

	//���� ���
	public void info(Marine enemy){
		if(gameOver)
			System.out.println("�� ü�� : " + hp + ", �� ü�� : die");
		else
			System.out.println("�� ü�� : " + hp + ", �� ü�� : " + enemy.hp);
	}

	///////////////////////////////////////
	//���� ��� (������ ����)
	String getStatus() {
		return (hp <= 0 ? "die" : hp + "");
	}

}
// ���ƿ� 1 