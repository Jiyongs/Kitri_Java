package com.kitri.util.jcf;

public class Drama extends TVProgram {
	private String director;
	private String actor;
	private String actress;
	
	public Drama(String title, String broadcast, String director, String actor, String actress) {
		super(title, broadcast);
		this.director = director;
		this.actor = actor;
		this.actress = actress;
	}
	
	public Drama(String director, String actor, String actress) {
		super();
		this.director = director;
		this.actor = actor;
		this.actress = actress;
	}
	
	@Override
	public String toString() {
		
		
			return super.toString()
					+ "- ���� : " + director
					+ (!actor.equals("") ? "\n- ���ڹ�� : " + actor + "\n" : "\n")
					+ (!actress.equals("") ? "- ���ڹ�� : " + actress + "\n" : "");

	}

	
		
}
