/* Задание
Напишите основные арифметические действия калькулятора, используя лямбда-выражения. */

package com.itvdn.javaProfessional.petrov.lesson015.homeWork.addTask;

public class Main {
    public static void main(String[] args) {
        Operation sum = (firstNumber, secondNumber) -> firstNumber + secondNumber;
        Operation dif = (firstNumber, secondNumber) -> firstNumber - secondNumber;
        Operation mul = (firstNumber, secondNumber) -> firstNumber * secondNumber;
        Operation div = (firstNumber, secondNumber) -> firstNumber / secondNumber;
        int a = 10;
        int b = 5;
        System.out.println(sum.calculate(a, b));
        System.out.println(dif.calculate(a, b));
        System.out.println(mul.calculate(a, b));
        System.out.println(div.calculate(a, b));
    }
}
