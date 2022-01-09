/* Задание 2
Создайте класс, используя SAXParser, в котором опишите иерархию XML файла.
Необходимо, чтобы проект создавал XML файл и строил дерево (город, название улицы, дом).
В городе используйте аттрибут(например, <city size=”big>Kiev</city>).*/

package com.itvdn.javaProfessional.petrov.lesson011.homeWork.task002;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    private static final String LOCATION = "location";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String STREET = "street";
    private static final String HOUSE = "house";
    private static final String SIZE = "size";
    private static final Address ADDRESSES[] = {
            new Address(City.KYIV, "Shevcehnko", "5"),
            new Address(City.LVIV, "I. Franko", "13"),
            new Address(City.VINNYTSIA, "G. Skovorody", "27"),
    };

    public static void main(String[] args) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            Element root = doc.createElement(LOCATION);
            doc.appendChild(root);
            for (Address address : ADDRESSES) {
                Element addressElement = doc.createElement(ADDRESS);
                root.appendChild(addressElement);

                Element cityElement = doc.createElement(CITY);
                cityElement.setAttribute(SIZE, address.getCity().getSize().toString());
                cityElement.setTextContent(address.getCity().toString());
                addressElement.appendChild(cityElement);

                Element streetElement = doc.createElement(STREET);
                streetElement.setTextContent(address.getStreet());
                addressElement.appendChild(streetElement);

                Element houseElement = doc.createElement(HOUSE);
                houseElement.setTextContent(address.getHouse());
                addressElement.appendChild(houseElement);
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            File file = new File("../JavaProfessional/src/main/java/com/itvdn/javaProfessional/petrov/lesson011/homeWork/task002/xml.xml");
            transformer.transform(source, new StreamResult(file));
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
