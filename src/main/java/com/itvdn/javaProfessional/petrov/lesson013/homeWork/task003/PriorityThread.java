package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task003;

public class PriorityThread extends Thread {
    private Thread thread;

    public PriorityThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        thread.run();
    }
}
