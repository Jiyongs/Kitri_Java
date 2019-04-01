package constructor;

public class StarCraft {
	public static void main(String[] args) {
		Marine my;
		Marine com;

		my = new Marine();
		com = new Marine();

		//내 체력 : 100, 적 체력 : 100
		my.info(com);

		int count = 2;
		System.out.println("\n내가 적을 " + count +"회 공격!!!!");
		my.attack(count, com);
		//내 체력 : 100, 적 체력 : 80
		my.info(com);

		count = 4;
		System.out.println("\n적이 나를 " + count +"회 공격!!!!");
		com.attack(count, my);
		//내 체력 : 60, 적 체력 : 80
		my.info(com);

		System.out.println("\n내 모드 변경!!!!");
		my.changeMode();
		//내 체력 : 35, 적 체력 : 80
		my.info(com);

		count = 3;
		System.out.println("\n내가 적을 " + count +"회 공격!!!!");
		my.attack(count, com);
		//내 체력 : 35, 적 체력 : 35
		my.info(com);

		System.out.println("\n내 모드 변경!!!!");
		//경고 : 모드 변경 불가~!!!!
		my.changeMode();
		//내 체력 : 35, 적 체력 : 35
		my.info(com);


		count = 3;
		System.out.println("\n내가 적을 " + count +"회 공격!!!!");
		my.attack(count, com);
		//내 체력 : 35, 적 체력 : die
		my.info(com);
	}
}
