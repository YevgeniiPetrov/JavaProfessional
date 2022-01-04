/* Задание
Создайте класс Animal
Опишите в нем 3 различных поля, создайте конструктор, методы.
Создайте файл и выполните сериализацию объекта Animal.*/

package com.itvdn.javaProfessional.petrov.lesson009.homeWork.task001;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal(3, 7, "Barsik");
        File file = new File("../JavaProfessional/src/main/java/com/itvdn/javaProfessional/petrov/lesson009/homeWork/task001/file.txt");
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            System.out.println("Before serialization:\n\t" + animal);
            outputStream.writeObject(animal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
