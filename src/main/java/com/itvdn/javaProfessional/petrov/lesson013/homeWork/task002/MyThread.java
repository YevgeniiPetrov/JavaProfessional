package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task002;

public class MyThread extends Thread {
    private Thread thread;

    public MyThread(String name, Thread thread) {
        super(name);
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
