import java.io.*;

// << game(int my) >>�� ���
public class Test {

	// [�ʵ�]
	int com;
	BufferedReader in;


	// [������]
	public Test() {
		System.out.println("==== ��ǻ�Ϳ� ���������� ����!!! =====");
		in = new BufferedReader(new InputStreamReader(System.in));
	}


	// [�޼ҵ�]
	// 1) ��ǻ�� ���� �߻�
	private void comRandom() {
		com = (int) (Math.random() * 3);
	}

	// 2) ���� ���� ���� ����
	private void menu() throws Exception {
			System.out.print("���� ���(1), ����(0)�� �Է��ϼ��� : ");
			int my = Integer.parseInt(in.readLine());
			if(my==0)
				exit();
	}

	// 3) ���� ����
	private void game(int my) throws Exception {
				String resultStr = "";
				if(my > 2 || my <0) {
					System.out.println("0-2�� �ϳ��� �Է� �����մϴ�.");
				}else {
					int mid = (my - com + 2) % 3;
					switch(mid){
						case 0 : resultStr = "�̰��."; break;
						case 1 : resultStr = "����."; break;
						default : resultStr = "����."; 
					}
					System.out.println(" �� : " + gbb(my) + "\t��ǻ�� : " + gbb(com) + "\t����� : " + resultStr);
					menu();
				}

	}

	// 4) ���� ����
	private void exit() {
		System.out.println("���α׷� �����մϴ�!!!");
		System.exit(0);  //���α׷� ���� �޼ҵ�
	}

	// +) ���
	public String gbb(int num) {
		String gbb = "";
		switch(num){
			case 0 : gbb = "����"; break;
			case 1 :  gbb = "����"; break;
			default :  gbb = "��";
		}
		return gbb;
	}


	// [���� Ŭ����]
	public static void main(String[] args) throws Exception {
		Test t = new Test();

		while(true){
				t.comRandom();
				System.out.print("����(0), ����(1), ��(2) �����ϼ���. : ");
				int my = Integer.parseInt(t.in.readLine());
				t.game(my);
		}
	}

}


// << game() �� ��� >>
/*
import java.io.*;


public class Test {

	// [�ʵ�]
	int com;
	BufferedReader in;


	// [������]
	public Test() {
		System.out.println("==== ��ǻ�Ϳ� ���������� ����!!! =====");
		in = new BufferedReader(new InputStreamReader(System.in));
	}


	// [�޼ҵ�]
	// 1) ��ǻ�� ���� �߻�
	private void comRandom() {
		com = (int) (Math.random() * 3);
	}

	// 2) ���� ���� ���� ����
	private void menu() throws Exception {
			System.out.print("���� ���(1), ����(0)�� �Է��ϼ��� : ");
			int my = Integer.parseInt(in.readLine());
			if(my==0){
				exit();
			} else game();
	}

	// 3) ���� ����
	private void game() throws Exception {
		while(true){
				comRandom();

				System.out.print("����(0), ����(1), ��(2) �����ϼ���. : ");
				int my = Integer.parseInt(in.readLine());
			
				if(my > 2 || my <0) {
					System.out.println("0-2�� �ϳ��� �Է� �����մϴ�.");
				}else {
					switch(my){
						case 0 : System.out.print("�� : ����     "); break;
						case 1 : System.out.print("�� : ����     "); break;
						default : System.out.print("�� : ��       ");
					}
					switch(com){
						case 0 : System.out.print("��ǻ�� : ����     "); break;
						case 1 : System.out.print("��ǻ�� : ����     "); break;
						default : System.out.print("��ǻ�� : ��       ");
					}
					int mid = (my - com + 2) % 3;
					switch(mid){
						case 0 : System.out.println("����� : �̰��."); menu();break;
						case 1 : System.out.println("����� : ����."); menu(); break;
						default : System.out.println("����� : ����."); menu();
					}
				}
		}
	}

	// 4) ���� ����
	private void exit() {
		System.out.println("���α׷� �����մϴ�!!!");
		System.exit(0);  //���α׷� ���� �޼ҵ�
	}


	// [���� Ŭ����]
	public static void main(String[] args) throws Exception {
		Test t = new Test();
		t.game();
	}
}
*/