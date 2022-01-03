package com.itvdn.javaProfessional.petrov.lesson008.homeWork.task003;

import java.lang.annotation.*;

@Deprecated
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FoodAnno {
    int weight();
    String title();
}
