package com.kitri.array;

public class Car {

	private String carName;
	private String color;
	private String maker;

	public Car(String carName, String color, String maker) {
		super();
		this.carName = carName;
		this.color = color;
		this.maker = maker;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	@Override
	public String toString() {
		return "Car [carName=" + carName + ", color=" + color + ", maker=" + maker + "]";
	}

}
