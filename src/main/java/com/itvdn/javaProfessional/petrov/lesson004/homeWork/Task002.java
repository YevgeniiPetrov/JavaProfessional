/* Задание 2
Создайте файл, запишите в него произвольные данные и закройте файл. Затем снова откройте этот файл,
прочитайте из него данные и выведете их на консоль.*/

package com.itvdn.javaProfessional.petrov.lesson004.homeWork;

import java.io.*;

public class Task002 {
    public static void fillFile(File file, String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
             writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("../JavaProfessional/src/main/resources/task002.txt");
        fillFile(file, "Hello, world!");
        readFile(file);
    }
}
