package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task001;

public class MinNumbers extends Thread {
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
