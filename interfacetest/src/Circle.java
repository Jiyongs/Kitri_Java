public class Circle implements DohyungArea {

	int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return (Math.PI * Math.pow(radius, 2));
	}

}
