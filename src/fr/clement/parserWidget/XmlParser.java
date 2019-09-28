package fr.clement.parserWidget;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser<K,V> {
	
	private Document document;
	
	public XmlParser(Document document) {
		this.document=document;
	}
	
	public Element findParentElement(String elementName) {
		/*
		 * Fonction qui retourne le noeud recherche
		 * 
		 */
		
		Element racine = this.document.getDocumentElement();
		NodeList racineNoeuds = racine.getChildNodes();
		
		int nbRacineNoeuds = racineNoeuds.getLength();
		
		  for (int i = 0; i<nbRacineNoeuds; i++) 
		  {
		    if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) 
		    {
		      Element ingredient = (Element) racineNoeuds.item(i);
			  Element nom = (Element) ingredient.getElementsByTagName("nom").item(0);
			  if(nom.getTextContent().equals(elementName)) {
				  return ingredient;
			  }
			  
		    }
		  }
		  
		  return null;
	}
	
	public String getSpecificValueForElement(Element element, String baliseName) {
		return element.getElementsByTagName(baliseName).item(0).getTextContent();
	}
	
	public HashMap<K, V> findSubElement(Element parent, String childLabel) {
		HashMap<K, V> dictionnary = new HashMap<K, V>();
		NodeList childs=parent.getElementsByTagName(childLabel); //on recupere nutriments
		int nbRacineNoeuds = childs.getLength();
		for (int i = 0; i<nbRacineNoeuds; i++) 
		{
			
		    if(childs.item(i).getNodeType() == Node.ELEMENT_NODE) 
		    {
		    	Element element = (Element) childs.item(i);
		    	if(element.getNodeName().equals(childLabel)) {
		    		parcourirElemAndFillDictionnary(element.getChildNodes(),dictionnary,0);
		    	}
		    }
		}
		return dictionnary;
	}
	
	public void parcourirElemAndFillDictionnary(NodeList elems, HashMap<K, V> dictionnary, int option) {
		// option =0 => fill String String
		// option =1 => fill int Element
		int nbRacineNoeuds = elems.getLength();
		for (int i = 0; i<nbRacineNoeuds; i++) 
		{
			
		    if(elems.item(i).getNodeType() == Node.ELEMENT_NODE) 
		    {
		    	
		    	Element value = (Element) elems.item(i);
		    	this.fillDictionnary(value,dictionnary,option);
		    	

		    }
		}
	}
	
	private void fillDictionnary(Element elem, HashMap<K, V> dictionnary, int option) {
		
		if(option==0) {
			dictionnary.put((K)elem.getTagName(),(V)elem.getTextContent());
		}
		else {
			if(option==1) {
				dictionnary.put((K)this.getSpecificValueForElement(elem,"nom"),(V)elem);
			}
		}
		
	}
	
	public void setDocument(Document document) {
		this.document=document;
	}
	
	public void addIngredientElement(String labelNom, HashMap<String, String> elementDictionnary) {
		/**
		 * <ingredients> => racine
		 * 		<ingredient> => ingredient
		 * 			<nom></nom> => done
		 * 			<nutriments>
		 * 				<fibre>
		 * 				....
		 * 			</nutriments>
		 * 		</ingredient>
		 * 		....
		 */
		
		Element ingredient = document.createElement("ingredient");
		
		Element nutriments=this.createSimpleElement(ingredient, "nutriments");
		
		HashMap<String, String> test=new HashMap<String, String>();
		test.put("nom", labelNom);
		this.createElementWithText(ingredient, test);
		this.createElementWithText(nutriments, elementDictionnary);
		
		document.getDocumentElement().appendChild(ingredient);
		
	}

	public void addReceipeElement(HashMap<String, String> descNom, HashMap<String, String> elementDictionnary) {
		/**
		 *   <recette>
			  	<nom></nom>
			  	<description></description>
			  	<details>
				  	<ingredient1>
				  	<ingredient2>
				  	<ingredient3>
			  	</details>
	  		 </recette>
		 */
		Element recette = document.createElement("recette");
		
		this.createElementWithText(recette, descNom);
		Element details=this.createSimpleElement(recette, "details");
		this.createElementWithText(details, elementDictionnary);
		
		
		document.getDocumentElement().appendChild(recette);
	}
	
	public void createElementWithText(Element parent, HashMap<String, String> elementDictionnary) {
		for(Entry<String, String> entry : elementDictionnary.entrySet()) {
			String cle = entry.getKey();
			String value = entry.getValue();
			Element e = document.createElement(cle);
			e.appendChild(document.createTextNode(value));
			parent.appendChild(e);
			
		}

	}
	
	public Element createSimpleElement(Element parent, String label) {
		Element e = document.createElement(label);
		parent.appendChild(e);
		
		return e;
	}

}
