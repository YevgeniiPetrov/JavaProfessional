/* Задание
Создайте 2 класса, Animal и Cat.
В классе Animal инициализируйте 3 поля различных модификаторов.
В классе Cat используя рефлексию получите доступ к полям класса Animal и измените содержимое каждого
из полей.*/

package com.itvdn.javaProfessional.petrov.lesson007.homeWork.task001;

import java.lang.reflect.Field;

public class Cat {
    private static void setField(Object object, Field field) throws IllegalAccessException {
        switch (field.getType().getSimpleName()) {
            case "String":
                field.set(object, "value");
                break;
            case "int":
                field.set(object, 10);
                break;
        }
    }

    private static void setFields(Object object, Field[] fields) throws IllegalAccessException {
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            setField(object, field);
        }
    }

    private static void printFields(Object object, Field[] fields) throws IllegalAccessException {
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            System.out.println(object.getClass().getSimpleName() + ": " + field.getName() + " = " + field.get(object));
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Animal animal = new Animal();
        Class<?> animalClass = animal.getClass();
        Field[] fields = animalClass.getDeclaredFields();
        System.out.println("Before");
        printFields(animal, fields);
        setFields(animal, fields);
        System.out.println("After:");
        printFields(animal, fields);
    }
}
