/* Задание 3
Изменить задание №2. Всеми возможными способами (которые Вы знаете) решить проблему взаимной блокировки.*/

package com.itvdn.javaProfessional.petrov.lesson014.homeWork.task003;

public class Main {
    public static void main(String[] args) {
        MyClass_1 myClass1 = new MyClass_1();
        MyClass_2 myClass2 = new MyClass_2();
        myClass1.setMyClass2(myClass2);
        myClass2.setMyClass1(myClass1);
        myClass1.start();
        myClass2.start();
    }
}
