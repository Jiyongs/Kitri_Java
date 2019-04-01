public class Circle extends Dohyung {

	int radius;

	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return (Math.PI * Math.pow(radius, 2));
	}

	@Override
	public double getRound() {
		return (2*Math.PI*radius);
	}

}
