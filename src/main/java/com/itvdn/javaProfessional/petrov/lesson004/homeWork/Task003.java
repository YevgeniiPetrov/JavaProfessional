/* Задание 3
Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла по возрастанию.*/

package com.itvdn.javaProfessional.petrov.lesson004.homeWork;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task003 {
    public static int getNumber() {
        return (int) (Math.random() * 1000);
    }

    public static List<Integer> getNumbers() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < getNumber(); i++) {
            list.add(getNumber());
        }
        return list;
    }

    public static List<Integer> getNumbers(File file) {
        List<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void fillFile(File file, List<Integer> numbers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Integer num : numbers) {
                writer.write(num + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("../JavaProfessional/src/main/resources/task003.txt");
        fillFile(file, getNumbers());
        List<Integer> list = getNumbers(file);
        Collections.sort(list);
        fillFile(file, list);
    }
}
