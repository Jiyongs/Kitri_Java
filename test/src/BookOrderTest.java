public class BookOrderTest {
	public static void main(String[] args) {
		
		double discount = 0.15;
		int totalPrice = 0;

		String book[] = {"JAVA", "JQuery", "����Ŭ", "������"}; 

		int price[] = {24000, 21000, 19000, 35000};


		System.out.println("===== ���� ���� ��� =====");
		for(int i = 0; i<book.length; i++){
			totalPrice += price[i];
			System.out.println(book[i] + " : " + price[i]);
		}
		System.out.println("--------------------------");
		System.out.println("�ֹ� �ѱݾ� : " + totalPrice);
		System.out.println("�ֹ� �ѱݾ� : " + (int)(totalPrice-totalPrice * discount));

	}
}
