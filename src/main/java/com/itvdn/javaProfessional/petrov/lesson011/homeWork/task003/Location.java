package com.itvdn.javaProfessional.petrov.lesson011.homeWork.task003;

import com.itvdn.javaProfessional.petrov.lesson011.homeWork.task002.Address;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "location")
public class Location {
    @XmlElement(name = "address")
    List<Address> addresses = new ArrayList<>();

    public void add(Address address) {
        addresses.add(address);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(addresses.toArray());
    }
}
