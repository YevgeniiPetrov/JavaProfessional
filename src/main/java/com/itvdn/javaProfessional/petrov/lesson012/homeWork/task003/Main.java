/* Задание 3
Создать 2 класса: GsonParser, Main
Создать строку с содержимым в формате JSON (к примеру): Страна: Украина, город: Киев, улица: Крещатик.
Строку обработать и записать в JSON файл, используя GSON-библиотеку.*/

package com.itvdn.javaProfessional.petrov.lesson012.homeWork.task003;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String address = "{" +
                "\"country\": \"Ukraine\", " +
                "\"city\": \"Kyiv\", " +
                "\"street\": \"Khreschatyk\"" +
                "}";
        String filePath = "../JavaProfessional/src/main/java/com/itvdn/javaProfessional/petrov/lesson012/homeWork/task003/address.json";
        try {
            GsonParser.toJson(address, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
