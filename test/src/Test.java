import java.io.*;

// << game(int my) >>인 경우
public class Test {

	// [필드]
	int com;
	BufferedReader in;


	// [생성자]
	public Test() {
		System.out.println("==== 컴퓨터와 가위바위보 한판!!! =====");
		in = new BufferedReader(new InputStreamReader(System.in));
	}


	// [메소드]
	// 1) 컴퓨터 난수 발생
	private void comRandom() {
		com = (int) (Math.random() * 3);
	}

	// 2) 게임 종료 여부 묻기
	private void menu() throws Exception {
			System.out.print("게임 계속(1), 종료(0)을 입력하세요 : ");
			int my = Integer.parseInt(in.readLine());
			if(my==0)
				exit();
	}

	// 3) 게임 진행
	private void game(int my) throws Exception {
				String resultStr = "";
				if(my > 2 || my <0) {
					System.out.println("0-2중 하나만 입력 가능합니다.");
				}else {
					int mid = (my - com + 2) % 3;
					switch(mid){
						case 0 : resultStr = "이겼다."; break;
						case 1 : resultStr = "졌다."; break;
						default : resultStr = "비겼다."; 
					}
					System.out.println(" 나 : " + gbb(my) + "\t컴퓨터 : " + gbb(com) + "\t결과는 : " + resultStr);
					menu();
				}

	}

	// 4) 게임 종료
	private void exit() {
		System.out.println("프로그램 종료합니다!!!");
		System.exit(0);  //프로그램 종료 메소드
	}

	// +) 출력
	public String gbb(int num) {
		String gbb = "";
		switch(num){
			case 0 : gbb = "가위"; break;
			case 1 :  gbb = "바위"; break;
			default :  gbb = "보";
		}
		return gbb;
	}


	// [실행 클래스]
	public static void main(String[] args) throws Exception {
		Test t = new Test();

		while(true){
				t.comRandom();
				System.out.print("가위(0), 바위(1), 보(2) 선택하세요. : ");
				int my = Integer.parseInt(t.in.readLine());
				t.game(my);
		}
	}

}


// << game() 인 경우 >>
/*
import java.io.*;


public class Test {

	// [필드]
	int com;
	BufferedReader in;


	// [생성자]
	public Test() {
		System.out.println("==== 컴퓨터와 가위바위보 한판!!! =====");
		in = new BufferedReader(new InputStreamReader(System.in));
	}


	// [메소드]
	// 1) 컴퓨터 난수 발생
	private void comRandom() {
		com = (int) (Math.random() * 3);
	}

	// 2) 게임 종료 여부 묻기
	private void menu() throws Exception {
			System.out.print("게임 계속(1), 종료(0)을 입력하세요 : ");
			int my = Integer.parseInt(in.readLine());
			if(my==0){
				exit();
			} else game();
	}

	// 3) 게임 진행
	private void game() throws Exception {
		while(true){
				comRandom();

				System.out.print("가위(0), 바위(1), 보(2) 선택하세요. : ");
				int my = Integer.parseInt(in.readLine());
			
				if(my > 2 || my <0) {
					System.out.println("0-2중 하나만 입력 가능합니다.");
				}else {
					switch(my){
						case 0 : System.out.print("나 : 가위     "); break;
						case 1 : System.out.print("나 : 바위     "); break;
						default : System.out.print("나 : 보       ");
					}
					switch(com){
						case 0 : System.out.print("컴퓨터 : 가위     "); break;
						case 1 : System.out.print("컴퓨터 : 바위     "); break;
						default : System.out.print("컴퓨터 : 보       ");
					}
					int mid = (my - com + 2) % 3;
					switch(mid){
						case 0 : System.out.println("결과는 : 이겼다."); menu();break;
						case 1 : System.out.println("결과는 : 졌다."); menu(); break;
						default : System.out.println("결과는 : 비겼다."); menu();
					}
				}
		}
	}

	// 4) 게임 종료
	private void exit() {
		System.out.println("프로그램 종료합니다!!!");
		System.exit(0);  //프로그램 종료 메소드
	}


	// [실행 클래스]
	public static void main(String[] args) throws Exception {
		Test t = new Test();
		t.game();
	}
}
*/