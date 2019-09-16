package fr.clement.entities;

import java.util.ArrayList;


public class Recette {
	private ArrayList<Ingredient> ingredients;
	private String description;
	private String labelRecette;
	
	public Recette(String labelRecette0, String description0) {
		this.description=description0;
		this.labelRecette=labelRecette0;
		this.ingredients=new ArrayList<Ingredient>();
	}
	
	public void addIngredient(Ingredient ingredient) {
		//System.out.println("adding : "+ingredient.toString());
		this.ingredients.add(ingredient);
	}
	
	@Override
	public String toString() {
		return "Recette [ingredients=" + ingredients + ", description=" + description + ", labelRecette=" + labelRecette
				+ "]";
	}

	public void setDescription(String description0) {
		this.description=description0;
	}
}
