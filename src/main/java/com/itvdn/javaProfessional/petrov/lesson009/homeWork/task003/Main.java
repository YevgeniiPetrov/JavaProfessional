/* Задание 3
Создайте класс Car.
Опишите в нем 3 различных поля включая статические поля, создайте конструктор, методы.
Посредством Java создайте файл и выполните сериализацию объекта Car используя интерфейс Externalizable.*/

package com.itvdn.javaProfessional.petrov.lesson009.homeWork.task003;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("BMW", 200, 30000);
        File file = new File("../JavaProfessional/src/main/java/com/itvdn/javaProfessional/petrov/lesson009/homeWork/task003/file.txt");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("Before serialization:\n\t" + car);
            outputStream.writeObject(car);
            car = (Car) inputStream.readObject();
            System.out.println("After deserialization:\n\t" + car);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
