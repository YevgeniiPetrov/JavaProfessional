package com.itvdn.javaProfessional.petrov.lesson010.homeWork.task001;

import java.util.Objects;

public class Car implements Cloneable {
    private String model;
    private int speed;
    private int price;

    public Car() {
    }

    public Car(String model, int speed, int price) {
        this.model = model;
        this.speed = speed;
        this.price = price;
    }

    // for deep clone
    public Car(Car car) {
        this(car.getModel(), car.getSpeed(), car.getPrice());
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return speed == car.speed && price == car.price && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, speed, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
