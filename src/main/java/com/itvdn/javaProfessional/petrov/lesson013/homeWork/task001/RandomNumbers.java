package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task001;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {
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
