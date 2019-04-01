public class OperTest5 {
	public static void main(String[] args) {
		int x = 0;
		System.out.println("1. x =" + x);

		x = 10;	//일반 대입 연산
		System.out.println("2. x =" + x);

		x += 5;   // x = x + 5  //연산 후 대입 연산 (두 번의 연산을 한 번으로 줄여줌)
		System.out.println("3. x =" + x);

		x -= 5;
		System.out.println("4. x =" + x);

		x *= 5;
		System.out.println("5. x =" + x);

		x /= 5;
		System.out.println("6. x =" + x);

		x %= 5;
		System.out.println("7. x =" + x);


		// int y = 10;
		// y의 값을 1 증가시키는 방법을 3가지 이상 제시하세요. (kt문제)

		int y = 10;
		y++;
		System.out.println(" y = " + y);
		++y;
		System.out.println(" y = " + y);
		y +=1;
		System.out.println(" y = " + y);
		y = y +1;
		System.out.println(" y = " + y);
	}
}
