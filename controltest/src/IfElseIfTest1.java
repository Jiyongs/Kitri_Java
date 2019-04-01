public class IfElseIfTest1 {
	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		String result;

		if(x == y) {
			result = "같다.";
		} else if (x > y) {
			result = "크다.";
		} else {
			result = "작다.";
		}

		System.out.println(x + "은 " + y + "와 비교하여 " + result);

		// 조건이 많은 경우, 삼항연산자는 가독성이 떨어지므로 if문을 쓰는 것이 좋음
		// 하지만, 삼항연산자의 if문 보다 연산 속도가 더 빠름 (또 하지만, 요즘 컴퓨터 속도는 그런 것에 별로 영향받지 않음)
	}
}
