package com.flyingh.dom4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Demo2 {
	private static final String PATH = "src/test/java/com/flyingh/dom4j/books.xml";
	private Document document;

	@Before
	public void before() throws DocumentException {
		document = new SAXReader().read(getClass().getResourceAsStream(
				"books.xml"));
	}

	@Test
	public void test4() {
		Element bookElement = (Element) document.getRootElement()
				.elements("book").get(2);
		bookElement.element("name").setText("Java EE");
	}

	@Test
	public void test3() {
		Element cElement = document.getRootElement().element("book")
				.element("c");
		cElement.getParent().remove(cElement);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void test2() {
		Element bookElement = document.getRootElement().element("book");
		List<Element> elements = bookElement.elements();
		Element cElement = DocumentHelper.createElement("c").addAttribute(
				"info", "d");
		elements.add(4, cElement);
	}

	@Test
	public void test() {
		document.getRootElement().element("book").addElement("a")
				.addAttribute("info", "b");
	}

	@After
	public void after() throws IOException {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(PATH), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}

}
