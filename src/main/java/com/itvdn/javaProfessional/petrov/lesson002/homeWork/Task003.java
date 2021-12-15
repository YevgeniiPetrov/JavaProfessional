/* Задание 3
Минимальное из N чисел(использовать LinkedList):
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.*/

package com.itvdn.javaProfessional.petrov.lesson002.homeWork;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task003 {
    public static int getInputNumber(Scanner sc, String message) {
        System.out.println(message);
        return sc.nextInt();
    }

    public static List<Integer> getIntegerList(Scanner sc, int n) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int number = getInputNumber(sc, String.format("Введите число №%d:", i + 1));
            list.add(number);
        }
        return list;
    }

    public static int getMinimum(List<Integer> list) {
        return Collections.min(list);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = getInputNumber(sc, "Введите число N:");
        List<Integer> list = getIntegerList(sc, n);
        sc.close();
        System.out.printf("Минимальное число: %d", getMinimum(list));
    }
}
