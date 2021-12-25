/* Создайте в package текстовый файл и клас, внесите в файл некий текст.
Выведите на экран содержимое файла.*/

package com.itvdn.javaProfessional.petrov.lesson004.homeWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task001 {
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
        File file = new File("../JavaProfessional/src/main/resources/task001.txt");
        readFile(file);
    }
}
