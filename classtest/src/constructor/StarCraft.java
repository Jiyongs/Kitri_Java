package constructor;

public class StarCraft {
	public static void main(String[] args) {
		Marine my;
		Marine com;

		my = new Marine();
		com = new Marine();

		//�� ü�� : 100, �� ü�� : 100
		my.info(com);

		int count = 2;
		System.out.println("\n���� ���� " + count +"ȸ ����!!!!");
		my.attack(count, com);
		//�� ü�� : 100, �� ü�� : 80
		my.info(com);

		count = 4;
		System.out.println("\n���� ���� " + count +"ȸ ����!!!!");
		com.attack(count, my);
		//�� ü�� : 60, �� ü�� : 80
		my.info(com);

		System.out.println("\n�� ��� ����!!!!");
		my.changeMode();
		//�� ü�� : 35, �� ü�� : 80
		my.info(com);

		count = 3;
		System.out.println("\n���� ���� " + count +"ȸ ����!!!!");
		my.attack(count, com);
		//�� ü�� : 35, �� ü�� : 35
		my.info(com);

		System.out.println("\n�� ��� ����!!!!");
		//��� : ��� ���� �Ұ�~!!!!
		my.changeMode();
		//�� ü�� : 35, �� ü�� : 35
		my.info(com);


		count = 3;
		System.out.println("\n���� ���� " + count +"ȸ ����!!!!");
		my.attack(count, com);
		//�� ü�� : 35, �� ü�� : die
		my.info(com);
	}
}
