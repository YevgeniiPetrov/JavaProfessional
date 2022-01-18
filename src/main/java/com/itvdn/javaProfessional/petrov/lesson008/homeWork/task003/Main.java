/* Задание 3
Создайте несколько классов, один класс наследует другой и использует аннотацию @Inherited.
Помимо этого, попробуйте ещё в проекте использовать 5 различных аннотаций.*/

package com.itvdn.javaProfessional.petrov.lesson008.homeWork.task003;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Class<?> cl = apple.getClass();
        while (!cl.getSimpleName().equals("Object")) {
            FoodAnno foodAnno = cl.getAnnotation(FoodAnno.class);
            System.out.println(cl.getSimpleName() + "\n\tAnnotation: " + foodAnno);
            cl = cl.getSuperclass();
        }
    }
}
