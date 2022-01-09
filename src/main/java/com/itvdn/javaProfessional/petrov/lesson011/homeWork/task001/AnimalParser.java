/* Задание
Создать XML файл со структурой:
<?xml version="1.0" encoding="UTF-8"?>
<animal>
<cat>
<name>Marsel</ name >
<age>7</age>
<breed>Sphynx</breed>
<weight>6</weight>
</cat>
<cat >
<name>Myrzik</ name >
<age>5</age>
<breed>Oriental</breed>
<weight>4</weight>
</cat>
</animal>
Создать класс AnimalParser.
Вывести в консоль name, breed всех котов используя любой из рассматриваемых ранее парсеров.*/

package com.itvdn.javaProfessional.petrov.lesson011.homeWork.task001;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class AnimalParser {
    private static final String[] TAGS = {"name", "breed"};

    public static void printElementInfo(Element element) {
        System.out.println(element.getNodeName() + ": ");
        for (String tag : TAGS) {
            System.out.println("\t" + tag + ": " + element.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue());
        }
    }

    public static void main(String[] args) {
        File file = new File("../JavaProfessional/src/main/java/com/itvdn/javaProfessional/petrov/lesson011/homeWork/task001/xml.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(file);
            Element root = document.getDocumentElement();
            NodeList childNodes = root.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    printElementInfo((Element) node);
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
