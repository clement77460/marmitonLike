package fr.clement.engine;

import java.util.HashMap;
import java.util.Map.Entry;

import org.w3c.dom.Element;

import fr.clement.entities.Ingredient;
import fr.clement.entities.Recette;
import fr.clement.parserWidget.XmlDocument;
import fr.clement.parserWidget.XmlParser;

public class Engine {
	private XmlDocument xmlDocument;
	
	public Engine() {
		this.xmlDocument=new XmlDocument();
	}
	

	
	public void getIngredient(Recette recette, String lablelIngredient, String portion) {
		xmlDocument.readXML("./data/ingredients.xml");
		XmlParser<String, String> parser=new XmlParser<String,String>(xmlDocument.getDocument());
		
		Element element=parser.findParentElement(lablelIngredient);
		recette.addIngredient(new Ingredient(lablelIngredient, portion, parser.findSubElement(element, "nutriments")));
	}
	
	public void getSpecificRecette(String labelRecette) {
		xmlDocument.readXML("./data/recettes.xml");
		XmlParser<String, String> parser=new XmlParser<String,String>(xmlDocument.getDocument());
		
		
		Element element=parser.findParentElement(labelRecette);
		
		String description=parser.getSpecificValueForElement(element, "description");//description recette
		HashMap<String, String> ingredients=parser.findSubElement(element, "details");//totalite ingredients
		Recette recette=new Recette(labelRecette, description);
		
		this.fillRecetteWithIngredients(recette, ingredients);

		recette.computeReceipeNutriments();
		xmlDocument.readXML("./data/recettes.xml");
		System.out.println("lol");
		XmlParser<String, Element> parser2=new XmlParser<String,Element>(xmlDocument.getDocument());
		HashMap<String, Element> recettes=new HashMap<String, Element>();
		parser2.parcourirElemAndFillDictionnary(xmlDocument.getDocument().getDocumentElement().getChildNodes(),recettes,1);
		System.out.println(recettes);
		
	}
	
	public void fillRecetteWithIngredients(Recette recette, HashMap<String, String> ingredients) {
		for(Entry<String, String> entry : ingredients.entrySet()) {
			String cle = entry.getKey();
			String value = entry.getValue();
			this.getIngredient(recette, cle, value);
			
		}
	}

}
