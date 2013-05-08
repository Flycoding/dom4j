package com.flyingh.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

public class Demo3 {
	private Document document;

	@Before
	public void before() throws DocumentException {
		document = new SAXReader().read(getClass().getResourceAsStream(
				"books.xml"));
	}

	@Test
	public void test() throws DocumentException {
		System.out.println(document.selectSingleNode("//name").getText());
	}

}
