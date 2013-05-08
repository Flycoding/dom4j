package com.flyingh.dom4j;

import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

public class Demo {

	private Document document;

	@Before
	public void before() throws DocumentException {
		document = new SAXReader().read(getClass().getResourceAsStream(
				"books.xml"));
		// document = new SAXReader().read(getClass().getClassLoader()
		// .getResourceAsStream("com/flyingh/dom4j/books.xml"));
	}
	
	@Test
	public void test3(){
		Attribute selectSingleNode = (Attribute) document.getRootElement().selectSingleNode("//books/book/@id");
		System.out.println(selectSingleNode.asXML());
		System.out.println(selectSingleNode.getName());
		System.out.println(selectSingleNode.getValue());
		
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void test2(){
		List<Element> selectNodes = document.getRootElement().selectNodes(
				"//books/book/name");
		for (Element element : selectNodes) {
			System.out.println(element.getText());
		}
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		List<Element> books = document.getRootElement().elements("book");
		if (books.size() < 1) {
			return;
		}
		Element secondBook = books.get(1);
		System.out.println(secondBook.attributeValue("id"));
		System.out.println(secondBook.elementText("name"));
		System.out.println(secondBook.element("name").getText());
	}
}
