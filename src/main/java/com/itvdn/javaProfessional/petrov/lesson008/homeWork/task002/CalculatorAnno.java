package com.itvdn.javaProfessional.petrov.lesson008.homeWork.task002;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CalculatorAnno {
    int firstNumber();
    int secondNumber();
}
