/* Задание 2
Напишите программу, которая будет выводить всю информацию о классе, пользователь сам выбирает, какой
именно класс интересует. */

package com.itvdn.javaProfessional.petrov.lesson007.homeWork.task002;

import java.lang.reflect.*;
import java.util.Scanner;

public class Task002 {
    public static void printMessage(String message) {
        System.out.println("=".repeat(50));
        System.out.println(message);
    }

    public static String getModifiersInfo(int modifiers) {
        return modifiers == 0 ? "" : Modifier.toString(modifiers) + " ";
    }

    public static String getFieldInfo(Field field) {
        return getModifiersInfo(field.getModifiers()) +
                field.getType().getSimpleName() + " " +
                field.getName();
    }

    public static void printFields(Class<?> cl) {
        printMessage("fields:");
        for (Field field : cl.getDeclaredFields()) {
            System.out.println(getFieldInfo(field));
        }
    }

    public static String getMethodParametersInfo(Executable executable) {
        String info = "";
        Parameter[] parameters = executable.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            info += parameters[i].getType().getSimpleName() + " " + parameters[i].getName();
            if (i != parameters.length - 1) {
                info += ", ";
            }
        }
        return info;
    }

    public static String getConstructorInfo(Class<?> cl, Constructor constructor) {
        return getModifiersInfo(constructor.getModifiers()) +
                cl.getSimpleName() + "(" +
                getMethodParametersInfo(constructor) + ")";
    }

    public static void printConstructors(Class<?> cl) {
        printMessage("constructors:");
        for (Constructor constructor : cl.getDeclaredConstructors()) {
            System.out.println(getConstructorInfo(cl, constructor));
        }
    }

    public static String getMethodInfo(Method method) {
        return getModifiersInfo(method.getModifiers()) +
                method.getReturnType().getSimpleName() + " " +
                method.getName() + "(" +
                getMethodParametersInfo(method) +  ")";
    }

    public static void printMethods(Class<?> cl) {
        printMessage("methods:");
        for (Method method : cl.getDeclaredMethods()) {
            System.out.println(getMethodInfo(method));
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите название класса:");
        try (Scanner sc = new Scanner(System.in)) {
            Class<?> cl = Class.forName(sc.nextLine());
            printFields(cl);
            printConstructors(cl);
            printMethods(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
