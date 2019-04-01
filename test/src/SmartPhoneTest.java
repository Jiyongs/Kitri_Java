public class SmartPhoneTest {
	public static void main(String[] args) {
		SmartPhone phone1 = new SmartPhone("삼성", "갤럭시노트2", 850000);
		SmartPhone phone2 = new SmartPhone("애플", "아이폰5", 740000, 30);
		SmartPhone phone3 = new SmartPhone("삼성", "갤럭시S3", 750000, 35);

		System.out.println("=== 제품목록 ===");
		System.out.println(phone1.toString());
		System.out.println(phone2.toString());
		System.out.println(phone3.toString());
		//phone1.info();
		//phone2.info();
		//phone3.info();
		System.out.println("---------------------");

	}
}
