package com.itvdn.javaProfessional.petrov.lesson008.homeWork.task001;

public class MathHandler {
    @MathAnno(num1 = 50)
    @MathAnno(num2 = 100)
    @MathAnno(num1 = 20, num2 = 70)
    public void mathSum(int num1, int num2) {
        System.out.println(num1 + num2);
    }
}
