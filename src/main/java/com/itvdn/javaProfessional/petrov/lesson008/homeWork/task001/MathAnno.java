package com.itvdn.javaProfessional.petrov.lesson008.homeWork.task001;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MathAnnoMultiple.class)
public @interface MathAnno {
    int num1() default 0;
    int num2() default 0;
}
