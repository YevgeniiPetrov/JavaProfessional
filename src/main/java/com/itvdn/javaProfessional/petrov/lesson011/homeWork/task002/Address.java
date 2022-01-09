package com.itvdn.javaProfessional.petrov.lesson011.homeWork.task002;

import javax.xml.bind.annotation.XmlElement;

public class Address {
    private City city;
    private String street;
    private String house;

    public Address(City city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    @XmlElement
    public City getCity() {
        return city;
    }

    @XmlElement
    public String getStreet() {
        return street;
    }

    @XmlElement
    public String getHouse() {
        return house;
    }
}
