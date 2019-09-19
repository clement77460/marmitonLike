package fr.clement.engine;

import java.util.HashMap;
import java.util.Map.Entry;

import org.w3c.dom.Element;

import fr.clement.entities.Ingredient;
import fr.clement.entities.Recette;
import fr.clement.entities.RecetteWrapper;
import fr.clement.parserWidget.XmlDocument;
import fr.clement.parserWidget.XmlParser;

public class Engine {
	private XmlDocument xmlDocument;
	private RecetteWrapper recetteWrapper;
	
	public Engine() {
		this.xmlDocument=new XmlDocument();
		this.recetteWrapper=new RecetteWrapper();
	}
	
	
	public void getIngredient(Recette recette, String lablelIngredient, String portion) {
		xmlDocument.readXML("./data/ingredients.xml");
		XmlParser<String, String> parser=new XmlParser<String,String>(xmlDocument.getDocument());
		
		Element element=parser.findParentElement(lablelIngredient);
		recette.addIngredient(new Ingredient(lablelIngredient, portion, parser.findSubElement(element, "nutriments")));
	}
	
	public void getSpecificRecette(String labelRecette, Element element) {
		xmlDocument.readXML("./data/recettes.xml");
		XmlParser<String, String> parser=new XmlParser<String,String>(xmlDocument.getDocument());
		
		
		String description=parser.getSpecificValueForElement(element, "description");//description recette
		HashMap<String, String> ingredients=parser.findSubElement(element, "details");//totalite ingredients
		
		this.buildReceipe(labelRecette, description, ingredients);
	}
	
	private void buildReceipe(String labelRecette, String description, HashMap<String, String> ingredients) {
		Recette recette=new Recette(labelRecette, description);
		this.fillRecetteWithIngredients(recette, ingredients);
		recette.computeReceipeNutriments();
		
		recetteWrapper.addRecette(recette);
	}
	
	public void fillRecetteWithIngredients(Recette recette, HashMap<String, String> ingredients) {
		for(Entry<String, String> entry : ingredients.entrySet()) {
			String cle = entry.getKey();
			String value = entry.getValue();
			this.getIngredient(recette, cle, value);
			
		}
	}
	
	public void initApp() {
		HashMap<String, Element> recettes=new HashMap<String, Element>();
		this.getAllReceipe(recettes);
		this.computeEveryReceipes(recettes);
		this.recetteWrapper.displayAllRecette();
	}
	
	private void computeEveryReceipes(HashMap<String, Element> recettes) {
		for(Entry<String, Element> entry : recettes.entrySet()) {
			String cle = entry.getKey(); //name of the receipe
			this.getSpecificRecette(cle, entry.getValue());
			
		}
	}
	
	public void getAllReceipe(HashMap<String, Element> recettes) {
		/**
		 * Function to insert all receipe in a dictionnary
		 * Key : name of the receipe
		 * Value : reference to the Element <Recette>
		 */
		xmlDocument.readXML("./data/recettes.xml");
		XmlParser<String, Element> parser=new XmlParser<String,Element>(xmlDocument.getDocument());	
		parser.parcourirElemAndFillDictionnary(xmlDocument.getDocument().getDocumentElement().getChildNodes(), recettes, 1);
	}

}
