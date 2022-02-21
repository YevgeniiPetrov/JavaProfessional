/* Задание
Создайте классы Currency, Parser, Main
Подключиться к NBU API(https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json)
и вывести в консоль 3 валюты на выбор*/

package com.itvdn.javaProfessional.petrov.lesson012.homeWork.task001;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
        try {
            Currency[] currencies = Parser.parseJson(url, Currency[].class);
            for (int i = 0; i < 3; i++) {
                int random = (int) (Math.random() * currencies.length);
                System.out.println(currencies[random]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
