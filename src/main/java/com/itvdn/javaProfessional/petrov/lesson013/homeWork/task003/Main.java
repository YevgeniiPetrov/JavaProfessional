/* Задание 3
Демонстрация приоритетов.
Создать 2 класса PriorityRunner и PriorityThread.
Запустить 3 потока с приоритетами (min, max, norm).
При помощи цикла for выведем на экран значения от 1 до 50 и укажем, какой именно поток данную операцию делает.*/

package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task003;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("min", Thread.MIN_PRIORITY);
        map.put("max", Thread.MAX_PRIORITY);
        map.put("norm", Thread.NORM_PRIORITY);
        PriorityRunner priorityRunner = new PriorityRunner();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            PriorityThread priorityThread = new PriorityThread(priorityRunner);
            priorityThread.setName(entry.getKey());
            priorityThread.setPriority(entry.getValue());
            priorityThread.start();
        }
    }
}
