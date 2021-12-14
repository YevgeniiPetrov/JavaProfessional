/* Задание 2
Вывод на экран элементов List:
Создать список, заполнить его на 10 элементов и вывести на экран содержимое используя iterator.*/

package com.itvdn.javaProfessional.petrov.lesson001.homeWork.task002;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task002 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
