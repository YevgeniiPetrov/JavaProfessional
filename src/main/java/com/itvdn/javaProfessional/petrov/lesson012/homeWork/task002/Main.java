/* Задание 2
Создать 2 класса: JacksonParser, Main
Создать строку с содержимым в формате JSON (к примеру): Страна: Украина, город: Киев, улица: Крещатик.
Строку обработать и записать в JSON файл, используя Jackson-библиотеку.*/

package com.itvdn.javaProfessional.petrov.lesson012.homeWork.task002;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String address = "{" +
                "\"country\": \"Ukraine\", " +
                "\"city\": \"Kyiv\", " +
                "\"street\": \"Khreschatyk\"" +
                "}";
        String filePath = "../JavaProfessional/src/main/java/com/itvdn/javaProfessional/petrov/lesson012/homeWork/task002/address.json";
        try {
            JacksonParser.toJson(address, filePath);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
