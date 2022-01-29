/* Задание
Создайте класс Car.
Опишите в нем 3 различных поля, создайте конструктор, методы.
Выполните поверхностное и глубокое клонирования объекта Car.*/

package com.itvdn.javaProfessional.petrov.lesson010.homeWork.task001;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("BMW", 200, 30000);
        Car shallowCloneCar = null;
        try {
            shallowCloneCar = (Car) car.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Car deepCloneCar = new Car(car);
        System.out.println("Original car:\n\t" + car);
        System.out.println("Shallow clone car:\n\t" + shallowCloneCar);
        System.out.println("Deep clone car:\n\t" + deepCloneCar);
    }
}
