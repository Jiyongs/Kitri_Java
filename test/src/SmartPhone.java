public class SmartPhone {
	private String maker;
	private String name;
	private int price;
	private int discountRate;

	public SmartPhone(String maker, String name, int price){
		this.maker = maker;
		this.name = name;
		this.price = price;
	}

	public SmartPhone(String maker, String name, int price, int discountRate){
		this.maker = maker;
		this.name = name;
		this.price = price;
		this.discountRate = discountRate;
	}

	public int calculateDiscount(){
		double dis = discountRate *0.01;
		return (int)(price - price * dis);
	}

	@Override
	public String toString() {
		String str = (name + "---------------------\n[" + maker + "]\n���� : " + price);
		if(discountRate!=0){
			str+="\n���ΰ��� : " + calculateDiscount();
		}
		return str;
	}

	public void info(){
		System.out.println("---------------------");
		System.out.println(name + " [" + maker + "]");
		System.out.println("���� : " + price);
		if(discountRate!=0){
			System.out.println("���ΰ��� : " + calculateDiscount());
		}
	}
}
