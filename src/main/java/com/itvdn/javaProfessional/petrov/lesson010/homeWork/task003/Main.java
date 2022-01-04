/* Задание 3
Создать класс Animal и Eagle.
Создать 3 поля в классе Animal, Eagle должен наследовать класс Animal.
Клонировать объект Eagle.*/

package com.itvdn.javaProfessional.petrov.lesson010.homeWork.task003;

public class Main {
    public static void main(String[] args) {
        Eagle eagle = new Eagle("Eagle", 2, 10);
        Eagle cloneEgle = null;
        try {
            cloneEgle = (Eagle) eagle.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("Original eagle:\n\t" + eagle);
        System.out.println("Clone eagle:\n\t" + cloneEgle);
    }
}
