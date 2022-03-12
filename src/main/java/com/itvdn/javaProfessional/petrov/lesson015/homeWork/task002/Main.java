/* Задание 2
Создать список и заполнить рандомными числами 10 ячеек, нужно вывести сумму квадратов всех элементов
списка. Мы используем метод map() для возведения в квадрат каждого элемента, а потом применяем метод
reduce() для свертки всех элементов в одно число.*/

package com.itvdn.javaProfessional.petrov.lesson015.homeWork.task002;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new Random().ints(10, 1, 100)
                .boxed()
                .collect(Collectors.toList());
        int sum = numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
