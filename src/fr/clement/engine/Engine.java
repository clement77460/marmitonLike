package fr.clement.engine;

import java.util.HashMap;
import java.util.Map.Entry;

import org.w3c.dom.Element;

import fr.clement.entities.Ingredient;
import fr.clement.entities.Recette;
import fr.clement.parserWidget.XmlParser;

public class Engine {
	private XmlParser parser;
	
	public Engine() {
		this.parser=new XmlParser();
	}
	

	
	public void getIngredient(Recette recette, String lablelIngredient, String portion) {
		this.parser.readXML("./data/ingredients.xml");
		Element element=parser.findParentElement(lablelIngredient);
		recette.addIngredient(new Ingredient(lablelIngredient, portion, parser.findSubElement(element, "nutriments")));
	}
	
	public void getSpecificRecette(String labelRecette) {
		System.out.println("***** Pour la recette : "+ labelRecette+" ******\n");
		this.parser.readXML("./data/recettes.xml");
		Element element=parser.findParentElement(labelRecette);
		
		String description=parser.getSpecificValueForElement(element, "description");//description recette
		HashMap<String, String> ingredients=parser.findSubElement(element, "details");//totalite ingredients
		Recette recette=new Recette(labelRecette, description);
		
		this.fillRecetteWithIngredients(recette, ingredients);
		System.out.println(recette.toString());
		System.out.println("\n **** Fin de la recette Brioche coco :) ****");

		
	}
	
	public void fillRecetteWithIngredients(Recette recette, HashMap<String, String> ingredients) {
		for(Entry<String, String> entry : ingredients.entrySet()) {
			String cle = entry.getKey();
			String value = entry.getValue();
			this.getIngredient(recette, cle, value);
			
		}
	}

}
