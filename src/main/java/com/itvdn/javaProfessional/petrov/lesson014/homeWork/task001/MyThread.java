package com.itvdn.javaProfessional.petrov.lesson014.homeWork.task001;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread " + getName());
        if (isDaemon()) {
            System.out.println(
                    "\tid: " + getId() +
                            "\n\tpriority: " + getPriority() +
                            "\n\tstate: " + getState() +
                            "\n\tthread group name: " + getThreadGroup().getName());
        } else {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
