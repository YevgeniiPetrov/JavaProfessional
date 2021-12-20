package com.itvdn.javaProfessional.petrov.lesson001.homeWork.task001;

public class Car implements Comparable { //<Car>{
    int speed;
    int price;
    String model;
    String color;

    Car(int speed, int price, String model, String color) {
        this.speed = speed;
        this.price = price;
        this.model = model;
        this.color = color;
    }

    public String toString() {
        return this.model + " " + this.color + " " + this.speed + " " + this.price;
    }

    // Сортируем по скорости/цене
    public int compareTo(Object o) {    // public int compareTo(Car o) {
        int temp = this.speed - ((Car)o).speed;   // int temp = this.speed - o.speed;
        if (temp != 0) {
            return temp;
        }
        temp = this.price - ((Car)o).price;
        if (temp != 0) {
            return temp;
        }
        temp = this.model.compareTo(((Car)o).model);
        if (temp == 0) {
            return this.color.compareTo(((Car)o).color);
        } else {
            return temp;
        }
    }

    // Сравнение 2-х строковых значений
    // return this.model.compareTo((Car)o).model);
}
