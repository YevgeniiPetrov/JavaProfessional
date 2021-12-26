/* Задание
Вводить с клавиатуры строки, пока пользователь не введёт строку 'end':
1. Создать список строк.
2. Ввести строки с клавиатуры и добавить их в список.
3. Вводить с клавиатуры строки, пока пользователь не введёт строку "end". "end" не учитывать.
4. Вывести строки на экран, каждую с новой строки.*/

package com.itvdn.javaProfessional.petrov.lesson002.homeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task001 {
    public static void main(String[] args) {
        final String END = "end";
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line;
        while (true) {
            System.out.printf("Введите строку, или '%s', если хотите завершить ввод:\n", END);
            line = sc.nextLine();
            if (line.equals(END)) {
                break;
            }
            list.add(line);
        }
        sc.close();
        for (String str : list) {
            System.out.println(str);
        }
    }
}
