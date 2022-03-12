package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task001;

public class MaxNumbers extends Thread {
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
