/* Задание 2
Необходимо осуществить десериализацию с файла предыдущего проекта(Animal) и вывести на экран содержимое.*/

package com.itvdn.javaProfessional.petrov.lesson009.homeWork.task002;

import com.itvdn.javaProfessional.petrov.lesson009.homeWork.task001.Animal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        File file = new File("../JavaProfessional/src/main/java/com/itvdn/javaProfessional/petrov/lesson009/homeWork/task001/file.txt");
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            Animal animal = (Animal) inputStream.readObject();
            System.out.println("After deserialization:\n\t" + animal);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
