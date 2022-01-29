package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersLists {
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
