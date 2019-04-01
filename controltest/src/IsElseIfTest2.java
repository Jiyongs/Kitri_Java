/*
score(����)��
	90�̻��̸� ���� = A
	80�̻��̸� ���� = B
	70�̻��̸� ���� = C
	60�̻��̸� ���� = D
	60�̸��̑m ���� = F

x5�� �̻��̸� +

��� : ������ xx���̹Ƿ� X�����Դϴ�.
*/

public class IsElseIfTest2 {
	public static void main(String[] args) {
		int score = 49;
		String level;

		// ��� 1 (��ø if else��)
		if(score >= 90) {
			level = "A";
			if(score > 94) {
				level = "A+";
			}
		} else if(score >= 80) {
			level = "B";
			if(score > 84) {
				level = "B+";
			}
		} else if(score >= 70) {
			level = "C";
			if(score > 74) {
				level = "C+";
			}
		} else if (score >= 60){
			level = "D";
			if(score > 64) {
				level = "D+";
			}
		} else {
			level = "F";
		}
		System.out.println("������ " + score + "���̹Ƿ� " + level + "�����Դϴ�.");

		// ��� 2 (if�� �� ��)
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

		// *�켱���� && > ||
		// ���� >= 60    (D �̻�)
		// ���� >= 100
		// ���� x5 >= 5�� ���
		if(score >= 60 && (score >= 100 || (score % 10) >= 5)) {
			level += "+";
		}

		System.out.println("������ " + score + "���̹Ƿ� " + level + "�����Դϴ�.");

	}
}
