package com.kitri.util.jcf;

public class TVProgram {
	private String title;
	private String broadcast;

	public TVProgram(String title, String broadcast) {
		this.title = title;
		this.broadcast = broadcast;
	}

	public TVProgram() {
	}
	
	//
	@Override
	public String toString() {
		return title + "("+broadcast + ")\n";
	}
	
	

}
