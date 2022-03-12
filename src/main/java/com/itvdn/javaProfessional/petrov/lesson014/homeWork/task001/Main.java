/* Задание
Создайте поток-демон и выведите про него как можно больше информации.*/

package com.itvdn.javaProfessional.petrov.lesson014.homeWork.task001;

public class Main {
    public static void main(String[] args) {
        MyThread userThread = new MyThread();
        MyThread daemonThread = new MyThread();
        daemonThread.setDaemon(true);
        userThread.start();
        daemonThread.start();
    }
}
