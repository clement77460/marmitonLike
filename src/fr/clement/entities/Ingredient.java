package fr.clement.entities;

public class Ingredient {
	private String label;
	private Integer kcal;
	private Integer fibre;
	private Integer glucide;
	private Integer proteine;
	
	public Ingredient(String label0, int kcal0, int fibre0, int glucide0, int proteine0) {
		this.label=label0;
		this.kcal=kcal0;
		this.fibre=fibre0;
		this.glucide=glucide0;
		this.proteine=proteine0;
	}

	public Integer getKcal() {
		return this.kcal;
	}

	public Integer getFibre() {
		return this.fibre;
	}

	public Integer getGlucide() {
		return this.glucide;
	}

	public Integer getProteine() {
		return this.proteine;
	}
	
	public String getLabel() {
		return this.label;
	}
	
}
