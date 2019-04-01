package com.kitri.car; //package 안에 있는 class는 반드시 package 명시해주어야 함!

public class Car {

	// class의 필드값은 보통 private로 보호해야 함
	private String name;
	private String color;
	private String maker;
	private int speed;

	public Car(String name) {
		super();
		this.name = name;
	}

	public Car(String name, String color, String maker) {
		super();
		this.name = name;
		this.color = color;
		this.maker = maker;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", maker=" + maker + ", speed=" + speed + "]";
	}


	
	
}
