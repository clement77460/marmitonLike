package fr.clement.engine;

import org.w3c.dom.Element;

import fr.clement.entities.Recette;
import fr.clement.parserWidget.XmlParser;

public class Engine {
	
	public Engine() {
		Recette recette=new Recette();
	}
	
	public void getIngredient(String lablelIngredient) {
		XmlParser parser=new XmlParser();
		parser.readXML("./data/ingredients.xml");
		Element element=parser.findParentElement("Oeuf");
		parser.findSubElement(element, "nutriments", "glucide");
		parser.findSubElement(element, "nutriments", "kcal");
		parser.findSubElement(element, "nutriments", "lipide");
		parser.findSubElement(element, "nutriments", "fibre");
	}

}
