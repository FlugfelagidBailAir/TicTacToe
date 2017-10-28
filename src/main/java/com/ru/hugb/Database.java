package com.ru.hugb;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.
import org.w3c.dom.*;

/**
* Class that interacts with a database that keeps track of a players wins
*/
public class Database{
	private NodeList list;
	String path = new File("src/main/resources/public/scores.xml").getAbsolutePath();
	private File xfile = new File(path);

	/**
	* Imports the contents of the database to a nodeList
	*/
	public void readFile() throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xfile);

		doc.getDocumentElement().normalize();

		NodeList rootList = doc.getElementsByTagName("scores");
		Node root = rootList.item(0);
		Element e = (Element)root;

		list = e.getElementsByTagName("person");
	}	
}