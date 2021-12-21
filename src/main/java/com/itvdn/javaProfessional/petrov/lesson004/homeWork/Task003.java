/* Задание 3
Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.*/

package com.itvdn.javaProfessional.petrov.lesson004.homeWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task003 {


    public static void main(String[] args) {
        File file = new File("../JavaProfessional/src/main/resources/task003.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
