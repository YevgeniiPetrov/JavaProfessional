/* Задание
Создать 2 произвольных класса с полями и методами.
Необходимо синхронизировать методы этих классов между собой,
т.е. чтобы выводило на экран значения друг за другом (1 класс, 2 класс, 1, 2 и т.д.).*/

package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RandomNumbersLists randomNumbersLists = new RandomNumbersLists(10);
        new MinNumbers(randomNumbersLists).start();
        new MaxNumbers(randomNumbersLists).start();
    }
}

class RandomNumbers {
    private final int MAX_NUMBERS = 10;
    private final int MAX_VALUE = 100;
    private List<Integer> numbers;

    public RandomNumbers() {
        numbers = new ArrayList<>();
        fill();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void fill() {
        for (int i = 0; i <= (int) (Math.random() * MAX_NUMBERS); i++) {
            numbers.add((int) (Math.random() * MAX_VALUE));
        }
    }
}

class RandomNumbersLists {
    private int count;
    private List<RandomNumbers> randomNumbers;
    private boolean isMaxValueCalculated;

    public RandomNumbersLists(int count) {
        this.count = count;
        randomNumbers = new ArrayList<>();
        fill();
    }

    private void fill() {
        for (int i = 0; i < count; i++) {
            randomNumbers.add(new RandomNumbers());
        }
    }

    public List<RandomNumbers> getRandomNumbers() {
        return randomNumbers;
    }

    public synchronized int getMaxValue(RandomNumbers numbers) {
        if (isMaxValueCalculated) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        isMaxValueCalculated = true;
        notify();
        return Collections.max(numbers.getNumbers());
    }

    public synchronized int getMinValue(RandomNumbers numbers) {
        if (!isMaxValueCalculated) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        isMaxValueCalculated = false;
        notify();
        return Collections.min(numbers.getNumbers());
    }
}

class MaxNumbers extends Thread {
    private RandomNumbersLists randomNumbersLists;

    public MaxNumbers(RandomNumbersLists randomNumbersLists) {
        this.randomNumbersLists = randomNumbersLists;
    }

    @Override
    public void run() {
        for (RandomNumbers rn : randomNumbersLists.getRandomNumbers()) {
            System.out.println(rn.getNumbers() + " Max number: " + randomNumbersLists.getMaxValue(rn));
        }
    }
}

class MinNumbers extends Thread {
    private RandomNumbersLists randomNumbersLists;

    public MinNumbers(RandomNumbersLists randomNumbersLists) {
        this.randomNumbersLists = randomNumbersLists;
    }

    @Override
    public void run() {
        for (RandomNumbers rn : randomNumbersLists.getRandomNumbers()) {
            System.out.println(rn.getNumbers() + " Min number: " + randomNumbersLists.getMinValue(rn));
        }
    }
}
