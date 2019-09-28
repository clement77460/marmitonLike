package fr.clement.entities;

import java.util.ArrayList;
import java.util.HashMap;

public class IngredientWrapper {
	private ArrayList<Ingredient> ingredients;
	
	public IngredientWrapper() {
		this.ingredients=new ArrayList<Ingredient>(); 
	}
	
	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}
	
	public  ArrayList<Ingredient> getIngredients() {
		return this.ingredients;
	}
	
	public HashMap<String, String> getIngredientsWithPortion(){
		HashMap<String,String> ingredientsWithPortion = new HashMap<String,String>();
		
		for(Ingredient i : ingredients) {
			ingredientsWithPortion.put(i.getLabel(), Double.toString(i.getPortionRecette()));
		}
		
		return ingredientsWithPortion;
	}
}
