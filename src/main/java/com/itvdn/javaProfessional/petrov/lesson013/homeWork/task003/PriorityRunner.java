package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task003;

public class PriorityRunner extends Thread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + 1 + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
