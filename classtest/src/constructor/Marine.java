package constructor;

/*
1. 체력 hp 100, 모드 mode 0 (0 : 일반, 1 : 흥분)
2. 공격 attack()
      - 1회 공격당 적의 체력 (일반모드 : -10, 흥분모드 : -15)
   모드변경 changeMode()
      - 내 체력 -25
	  - 내 체력 40이하일 경우는 변경 불가

	** call by value
	** call by reference : 객체가 매개변수로 전달될 때, 객체의 값이 아닌 주소값을 참조한다.
*/
public class Marine {
// [필드]
	int hp;
	int mode;

	int power;			    //모드별 공격력
	boolean gameOver;   //게임오버 여부                            

// [생성자]
	// 디폴트 생성자
	public Marine(){
		this(100, 0, 10, false);
	}
	// 사용자 정의 생성자
	public Marine(int hp, int mode, int power, boolean gameOver){
		this.hp = hp;
		this.mode = mode;
		this.power = power;
		this.gameOver = gameOver;
	}

// [메소드]
	//공격
	public void attack(int count, Marine enemy) {
		if(enemy.hp>0){
				enemy.hp -= power * count;
					if(enemy.hp <= 0) {
						//게임 종료
						gameOver = true;
					} 
			} else
				//게임 종료
				gameOver = true;
	}

	//모드 변경
	public void changeMode(){
		if(hp > 40){
			mode = 1;
			hp -= 25;
			power = 15;
		} else {
			System.out.println("경고 : 모드 변경 불가~!!!!");
		}
	}

	//정보 출력
	public void info(Marine enemy){
		if(gameOver)
			System.out.println("내 체력 : " + hp + ", 적 체력 : die");
		else
			System.out.println("내 체력 : " + hp + ", 적 체력 : " + enemy.hp);
	}

	///////////////////////////////////////
	//정보 출력 (선생님 버전)
	String getStatus() {
		return (hp <= 0 ? "die" : hp + "");
	}

}
// 좋아요 1 