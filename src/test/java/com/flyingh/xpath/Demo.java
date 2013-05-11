package com.flyingh.xpath;

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
				"users.xml"));
	}

	@Test
	public void test() {
		String username = "hehe";
		String password = "hehepass";
		Element node = (Element) document.selectSingleNode("//user[@username='"
				+ username + "' and @password='" + password + "']");
		if (node != null) {
			System.out.println("success!");
		} else {
			System.out.println("failure!");
		}
	}
}
