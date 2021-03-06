package com.flyingh.dom4j;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Before;
import org.junit.Test;

public class Demo {

	private static final String PATH = "src/test/java/com/flyingh/dom4j/books.xml";
	private Document document;

	@Before
	public void before() throws DocumentException {
		document = new SAXReader().read(getClass().getResourceAsStream(
				"books.xml"));
		// document = new SAXReader().read(getClass().getClassLoader()
		// .getResourceAsStream("com/flyingh/dom4j/books.xml"));
	}

	@Test
	public void test8() throws IOException {
		document.getRootElement().element("book").addElement("info")
				.addAttribute("haha", "hehe");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter xmlWriter = new XMLWriter(new OutputStreamWriter(
				new FileOutputStream(PATH), "UTF-8"), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}

	@Test
	public void test7() throws IOException {
		document.getRootElement().element("book").addElement("name")
				.setText("hello world");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(PATH), format);
		xmlWriter.write(document);
		xmlWriter.close();

	}

	@Test
	public void test6() {
		System.out.println(Charset.defaultCharset());
	}

	@Test
	public void test5() throws IOException {
		document.getRootElement().element("book").addElement("price")
				.setText("99.9");
		FileWriter writer = new FileWriter(PATH);
		System.out.println("writer encoding:" + writer.getEncoding());
		XMLWriter xmlWriter = new XMLWriter(writer,
				OutputFormat.createPrettyPrint());
		xmlWriter.write(document);
		xmlWriter.close();
	}

	@Test
	public void test4() throws IOException {
		document.getRootElement().element("book").addElement("price")
				.setText("99.9");
		new XMLWriter(System.out, OutputFormat.createPrettyPrint())
				.write(document);
		System.out.println("*************");
		new XMLWriter(System.out, OutputFormat.createCompactFormat())
				.write(document);
	}

	@Test
	public void test3() {
		Attribute selectSingleNode = (Attribute) document.getRootElement()
				.selectSingleNode("//books/book/@id");
		System.out.println(selectSingleNode.asXML());
		System.out.println(selectSingleNode.getName());
		System.out.println(selectSingleNode.getValue());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void test2() {
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
