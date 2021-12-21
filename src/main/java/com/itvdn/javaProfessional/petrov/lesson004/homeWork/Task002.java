/* Задание 2
Создайте файл, запишите в него произвольные данные и закройте файл. Затем снова откройте этот файл,
прочитайте из него данные и выведете их на консоль.*/

package com.itvdn.javaProfessional.petrov.lesson004.homeWork;

import java.io.*;

public class Task002 {
    public static void main(String[] args) {
        File file = new File("../JavaProfessional/src/main/resources/task002.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file));
             BufferedReader reader = new BufferedReader(new FileReader(file))) {
            writer.write("Hello, world!");
            writer.flush();
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
