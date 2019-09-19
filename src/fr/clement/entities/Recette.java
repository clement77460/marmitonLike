package fr.clement.entities;

import java.util.ArrayList;
import java.util.HashMap;


public class Recette {
	private ArrayList<Ingredient> ingredients;
	private String description;
	private String labelRecette;
	private HashMap<String, Double> receipeNutriments;
	
	public Recette(String labelRecette0, String description0) {
		this.description=description0;
		this.labelRecette=labelRecette0;
		this.ingredients=new ArrayList<Ingredient>();
		this.receipeNutriments=new HashMap<String, Double>();
		this.receipeNutriments.put("fibre", 0.0);
		this.receipeNutriments.put("kcal",  0.0);
		this.receipeNutriments.put("lipide",  0.0);
		this.receipeNutriments.put("glucide",  0.0);
		this.receipeNutriments.put("poids_gramme",  0.0);
	}
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
	
	public void computeReceipeNutriments(){
		for(Ingredient e : ingredients){
			this.receipeNutriments.put("fibre", e.getFibre()+this.receipeNutriments.get("fibre"));
			this.receipeNutriments.put("kcal", e.getKcal()+this.receipeNutriments.get("kcal"));
			this.receipeNutriments.put("lipide", e.getLipide()+this.receipeNutriments.get("lipide"));
			this.receipeNutriments.put("glucide", e.getGlucide()+this.receipeNutriments.get("glucide"));
			this.receipeNutriments.put("poids_gramme", e.getPortionRecette()+this.receipeNutriments.get("poids_gramme"));
		}
	}
	
	public HashMap<String, Double> getReceipeNutriments() {
		return this.receipeNutriments;
	}
	
	@Override
	public String toString() {
		return "Recette [ingredients=" + ingredients + ", description=" + description + ", labelRecette=" + labelRecette
				+ "]";
	}

	public void setDescription(String description0) {
		this.description=description0;
	}
	
	public String getLabelRecette() {
		return this.labelRecette;
	}
}
