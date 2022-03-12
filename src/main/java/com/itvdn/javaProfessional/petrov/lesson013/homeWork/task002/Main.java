/* Задание 2
Задержка потока.
Необходимо создать 3 потока, каждых из этих потоков запустить
(например: main, second, first), и когда эти потоки успешно отработают –
вывести на экран сообщение (завершение потом first, second и main).*/

package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task002;

public class Main {
    public static void main(String[] args) {
        MyThread first = new MyThread("first", Thread.currentThread());
        MyThread second = new MyThread("second", first);
        MyThread main = new MyThread("main", second);
        main.start();
        first.start();
        second.start();
        System.out.println("Завершение");
    }
}
