/* Задание 3
Необходимо создать строку с текстом (текст взять любой из интернета). Разбить эту строку на 2 подстроки равной длине и
вывести на экран каждое предложения с новой строки.*/

package com.itvdn.javaProfessional.petrov.lesson005.homeWork;

public class Task003 {
    public static String[] split(String string) {
        String[] result = new String[2];
        int index = string.length() / 2 + string.length() % 2;
        result[0] = string.substring(0, index);
        result[1] = string.substring(index % 2 == 0 ? index : index - 1);
        return result;
    }

    public static void main(String[] args) {
        String string = "Hello, world";
        for (String str : split(string)) {
            System.out.println(str + " (length = " + str.length() + ")");
        }
    }
}
