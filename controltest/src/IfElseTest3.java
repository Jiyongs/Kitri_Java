public class IfElseTest3 {
	public static void main(String[] args) {

		int score = 100;
		String level;

		if(score >= 90) {
			level = "A";
		} else if(score >= 80) {
			level = "B";
		} else if(score >= 70) {
			level = "C";
		} else if (score >= 60){
			level = "D";
		} else {
			level = "F";
		}
//100�� :       F            &&       T       ||         T
// 49�� :        T           &&        F       ||         F
		if(score % 10 > 5 && score >= 60 || score >= 100) {
			level += "+";
		}

		System.out.println("������ " + score + "���̹Ƿ� " + level + "�����Դϴ�.");

	}
}
