public class SwitchTest2 {
	public static void main(String[] args) {

		int score = 98;
		String grade;

		switch (score/10)
		{
		case 10 : case 9 : grade = "A"; break;   //case�� ��ø ������
		case 8 : grade = "B"; break;
		case 7 : grade = "C"; break;
		case 6 : grade = "D"; break;
		default : grade = "F";
		}

		if(score >= 60 && ( (score%10) >= 5 || score == 100) ){
			grade += "+";
		}

		System.out.println("������" + score + "���̹Ƿ� " + grade + "�����Դϴ�.");
	}
}
