/* Задание 2
Создать 2 класса. Реализовать взаимную блокировку(deadlock) этих классов.*/

package com.itvdn.javaProfessional.petrov.lesson014.homeWork.task002;

public class Main {
    public static void main(String[] args) {
        MyClass1 myClass1 = new MyClass1();
        MyClass2 myClass2 = new MyClass2();
        myClass1.setMyClass2(myClass2);
        myClass2.setMyClass1(myClass1);
        myClass1.start();
        myClass2.start();
    }
}
