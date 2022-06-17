package it.polito.tdp.yelp.model;

public class Arco {
	
	private Review r1;
	private Review r2;
	private int weight;
	
	public Arco(Review r1, Review r2, int weight) {
		super();
		this.r1 = r1;
		this.r2 = r2;
		this.weight = weight;
	}

	public Review getR1() {
		return r1;
	}

	public void setR1(Review r1) {
		this.r1 = r1;
	}

	public Review getR2() {
		return r2;
	}

	public void setR2(Review r2) {
		this.r2 = r2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	

}
