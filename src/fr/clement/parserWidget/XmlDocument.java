package fr.clement.parserWidget;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlDocument {
	private final DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	public XmlDocument() {
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
			this.document= builder.parse(xmlName);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void saveXML(String xmlName) {
		try {
            Source source = new DOMSource(this.document);
            File xmlFile = new File(xmlName);
            StreamResult result = new StreamResult(new OutputStreamWriter(
                                  new FileOutputStream(xmlName), "ISO-8859-1"));
            Transformer xformer = TransformerFactory.newInstance().newTransformer();
            xformer.transform(source, result);
        } catch(Exception e) {
            e.printStackTrace();
            
        }
	}
	
	public Document getDocument() {
		return this.document;
	}
}
