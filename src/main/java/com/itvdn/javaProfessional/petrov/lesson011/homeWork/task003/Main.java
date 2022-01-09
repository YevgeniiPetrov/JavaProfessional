/* Задание 3
Используя JAXB выполнить задание №3.*/

package com.itvdn.javaProfessional.petrov.lesson011.homeWork.task003;

import com.itvdn.javaProfessional.petrov.lesson011.homeWork.task002.Address;
import com.itvdn.javaProfessional.petrov.lesson011.homeWork.task002.City;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Main {
    public static void main(String[] args) {
        Location location = new Location();
        location.add(new Address(City.KYIV, "Shevcehnko", "5"));
        location.add(new Address(City.LVIV, "I. Franko", "13"));
        location.add(new Address(City.VINNYTSIA, "G. Skovorody", "27"));

        File file = new File("../JavaProfessional/src/main/java/com/itvdn/javaProfessional/petrov/lesson011/homeWork/task003/xml.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Location.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(location, file);
            marshaller.marshal(location, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
