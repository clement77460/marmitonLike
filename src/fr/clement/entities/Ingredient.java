package fr.clement.entities;

import java.util.HashMap;

public class Ingredient {
	private String label;
	private String portion;
	private String kcal;
	private String fibre;
	private String glucide;
	private String lipide;
	
	public Ingredient(String label0, String portion0, HashMap<String, String> dictionnary) {
		this.label=label0;
		this.portion=portion0;
		this.kcal=dictionnary.get("kcal");
		this.fibre=dictionnary.get("fibre");
		this.glucide=dictionnary.get("glucide");
		this.lipide=dictionnary.get("lipide");
	}

	public String getKcal() {
		return this.kcal;
	}

	public String getFibre() {
		return this.fibre;
	}

	public String getGlucide() {
		return this.glucide;
	}

	public String getLipide() {
		return this.lipide;
	}
	
	public String getLabel() {
		return this.label;
	}

	@Override
	public String toString() {
		return "Ingredient [label=" + label + " portion= "+portion+ " kcal=" + kcal + ", fibre=" + fibre + ", glucide=" + glucide
				+ ", lipide=" + lipide + "]";
	}
	
}
