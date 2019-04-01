public class Rect extends Dohyung {

	int width;
	int height;

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getRound() {
		return 2 * (width + height);
	}
}
