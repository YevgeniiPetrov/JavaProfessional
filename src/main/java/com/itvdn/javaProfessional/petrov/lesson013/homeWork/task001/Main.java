/* Задание
Создать 2 произвольных класса с полями и методами.
Необходимо синхронизировать методы этих классов между собой,
т.е. чтобы выводило на экран значения друг за другом (1 класс, 2 класс, 1, 2 и т.д.).*/

package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task001;

public class Main {
    public static void main(String[] args) {
        RandomNumbersLists randomNumbersLists = new RandomNumbersLists(10);
        new MinNumbers(randomNumbersLists).start();
        new MaxNumbers(randomNumbersLists).start();
    }
}
