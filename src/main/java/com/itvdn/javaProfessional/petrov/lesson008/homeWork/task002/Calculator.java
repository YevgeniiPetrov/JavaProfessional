/* Задание 2
Написать калькулятор с использованием аннотаций, аннотация передает 2 параметра.
Сделать полную документацию всех полей, методов, конструкторов класса используя аннотацию Documented,
либо же документационные комментарии.*/

package com.itvdn.javaProfessional.petrov.lesson008.homeWork.task002;

/**
 * @author Yevgenii Petrov
 */
public class Calculator {
    /**
     * the sum of two numbers
     * @param firstNumber
     * @param secondNumber
     * @return the sum of two numbers
     */
    @CalculatorAnno(firstNumber = 10, secondNumber = 20)
    public static double sum(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * the difference of two numbers
     * @param firstNumber
     * @param secondNumber
     * @return the difference of two numbers
     */
    @CalculatorAnno(firstNumber = 55, secondNumber = 31)
    public static double difference(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    /**
     * the multiplay of two numbers
     * @param firstNumber
     * @param secondNumber
     * @return the multiplay of two numbers
     */
    @CalculatorAnno(firstNumber = 18, secondNumber = 34)
    public static double multiplay(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    /**
     * the divide of two numbers
     * @param firstNumber
     * @param secondNumber
     * @return the divide of two numbers
     */
    @CalculatorAnno(firstNumber = 36, secondNumber = 12)
    public static double divide(double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }
}
