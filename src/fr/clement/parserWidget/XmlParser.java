package fr.clement.parserWidget;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

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
	
	public HashMap<String, String> findSubElement(Element parent, String childLabel) {
		
		HashMap<String, String> dictionnary = new HashMap<String, String>();
		NodeList childs=parent.getElementsByTagName(childLabel); //on recupere nutriments
		int nbRacineNoeuds = childs.getLength();
		
		for (int i = 0; i<nbRacineNoeuds; i++) 
		{
			
		    if(childs.item(i).getNodeType() == Node.ELEMENT_NODE) 
		    {
		    	Element element = (Element) childs.item(i);
		    	if(element.getNodeName().equals(childLabel)) {
		    		parcourirElemAndFillDictionnary(element.getChildNodes(),dictionnary);
		    	}
		    }
		}
		return dictionnary;
	}
	
	private void parcourirElemAndFillDictionnary(NodeList elems, HashMap<String, String> dictionnary) {
		int nbRacineNoeuds = elems.getLength();
		for (int i = 0; i<nbRacineNoeuds; i++) 
		{
			
		    if(elems.item(i).getNodeType() == Node.ELEMENT_NODE) 
		    {
		    	
		    	Element value = (Element) elems.item(i);
		    	dictionnary.put(value.getTagName(),value.getTextContent());

		    }
		}
	}
}
