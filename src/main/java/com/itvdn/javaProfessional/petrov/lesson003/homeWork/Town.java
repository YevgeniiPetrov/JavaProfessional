/* Задание 2
Программа определяет, какая семья (фамилия) живёт в городе:
Пример ввода:
 Москва
 Ивановы
 Киев
 Петровы
 Лондон
 Абрамовичи

 Лондон
Пример вывода:
 Абрамовичи*/

package com.itvdn.javaProfessional.petrov.lesson003.homeWork;

import java.util.HashMap;
import java.util.Map;

public class Town {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Москва", "Ивановы");
        map.put("Киев", "Петровы");
        map.put("Лондон", "Абрамовичи");
        System.out.println(map.get("Лондон"));
    }
}
