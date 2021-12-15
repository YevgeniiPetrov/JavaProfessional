/* Задание 2
Используя коллекцию удвойте слово:
1. Введите с клавиатуры 5 слов в список строк.
2. Метод doubleValues должен удваивать слова по принципу a,b,c -> a,a,b,b,c,c.
3. Используя цикл for выведите результат на экран, каждое значение с новой строки.*/

package com.itvdn.javaProfessional.petrov.lesson002.homeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task002 {
    public static List<String> doubleValues(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String str : list) {
            newList.add(str);
            newList.add(str);
        }
        return newList;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line;
        for (int i = 0; i < 5; i++) {
            System.out.printf("Введите слово №%d:\n", i + 1);
            list.add(sc.nextLine());
        }
        sc.close();
        list = doubleValues(list);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
