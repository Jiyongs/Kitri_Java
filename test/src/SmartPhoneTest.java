public class SmartPhoneTest {
	public static void main(String[] args) {
		SmartPhone phone1 = new SmartPhone("�Ｚ", "�����ó�Ʈ2", 850000);
		SmartPhone phone2 = new SmartPhone("����", "������5", 740000, 30);
		SmartPhone phone3 = new SmartPhone("�Ｚ", "������S3", 750000, 35);

		System.out.println("=== ��ǰ��� ===");
		System.out.println(phone1.toString());
		System.out.println(phone2.toString());
		System.out.println(phone3.toString());
		//phone1.info();
		//phone2.info();
		//phone3.info();
		System.out.println("---------------------");

	}
}
