/*
score(점수)가
	90이상이면 학점 = A
	80이상이면 학점 = B
	70이상이면 학점 = C
	60이상이면 학점 = D
	60미만이몀 학점 = F

x5점 이상이면 +

결과 : 점수가 xx점이므로 X학점입니다.
*/

public class IsElseIfTest2 {
	public static void main(String[] args) {
		int score = 49;
		String level;

		// 방법 1 (중첩 if else문)
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
		System.out.println("점수가 " + score + "점이므로 " + level + "학점입니다.");

		// 방법 2 (if문 두 개)
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

		// *우선순위 && > ||
		// 점수 >= 60    (D 이상)
		// 점수 >= 100
		// 점수 x5 >= 5인 경우
		if(score >= 60 && (score >= 100 || (score % 10) >= 5)) {
			level += "+";
		}

		System.out.println("점수가 " + score + "점이므로 " + level + "학점입니다.");

	}
}
