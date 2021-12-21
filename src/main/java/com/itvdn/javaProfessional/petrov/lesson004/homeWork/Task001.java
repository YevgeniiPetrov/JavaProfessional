/* Создайте в package текстовый файл и клас, внесите в файл некий текст.
Выведите на экран содержимое файла.*/

package com.itvdn.javaProfessional.petrov.lesson004.homeWork;

import java.io.*;

public class Task001 {
    public static void main(String[] args) {
        File file = new File("task001.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file));
             BufferedReader reader = new BufferedReader(new FileReader(file));) {
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
