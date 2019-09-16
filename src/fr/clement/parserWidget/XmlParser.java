package fr.clement.parserWidget;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlParser {
	private final DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public XmlParser() {
		this.factory = DocumentBuilderFactory.newInstance();
		this.createDocumentBuilder();
	}
	
	private void createDocumentBuilder() {
		try 
		{
		  this.builder = this.factory.newDocumentBuilder();
		}
		catch (final ParserConfigurationException e) 
		{
		  e.printStackTrace();
		}
	}
	
	public void readXML(String xmlName) {
		try {
			this.document= builder.parse(new File(xmlName));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
			  System.out.println("\n*************INGREDIENT************");
			  Element nom = (Element) ingredient.getElementsByTagName("nom").item(0);
			  System.out.println("nom : " + nom.getTextContent());
			  if(nom.getTextContent().equals(elementName)) {
				  return ingredient;
			  }
			  
		    }
		  }
		  
		  return null;
	}
	
	public int findSubElement(Element parent, String childLabel, String label) {
		
		int valeurNutriment=0;
		
		NodeList childs=parent.getElementsByTagName(childLabel);
		int nbRacineNoeuds = childs.getLength();
		
		for (int i = 0; i<nbRacineNoeuds; i++) 
		{
			
		    if(childs.item(i).getNodeType() == Node.ELEMENT_NODE) 
		    {
		    	Element nutriment = (Element) childs.item(i);
		    	Element value = (Element) nutriment.getElementsByTagName(label).item(0);
		    	valeurNutriment=Integer.parseInt(value.getTextContent());
		    	System.out.println(label+" : " + valeurNutriment);
		    	
		    	return valeurNutriment;
		    }
		}
		return valeurNutriment;
	}
}
