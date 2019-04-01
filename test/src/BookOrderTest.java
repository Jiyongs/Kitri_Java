public class BookOrderTest {
	public static void main(String[] args) {
		
		double discount = 0.15;
		int totalPrice = 0;

		String book[] = {"JAVA", "JQuery", "오라클", "스프링"}; 

		int price[] = {24000, 21000, 19000, 35000};


		System.out.println("===== 도서 구입 목록 =====");
		for(int i = 0; i<book.length; i++){
			totalPrice += price[i];
			System.out.println(book[i] + " : " + price[i]);
		}
		System.out.println("--------------------------");
		System.out.println("주문 총금액 : " + totalPrice);
		System.out.println("주문 총금액 : " + (int)(totalPrice-totalPrice * discount));

	}
}
