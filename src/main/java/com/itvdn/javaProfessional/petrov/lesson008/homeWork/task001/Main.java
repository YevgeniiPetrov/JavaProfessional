/* Задание
Создать свою аннотацию используя аннотацию @Repeteable с Java 8, вызвать дважды аннотацию подтягивая разные параметры выполнить сложение 2-х чисел.
@MathAnno(num1 = 50)
@MathAnno(num2 = 100)
public void mathSum(int num1, int num2)*/

package com.itvdn.javaProfessional.petrov.lesson008.homeWork.task001;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        MathHandler mathHandler = new MathHandler();
        Class<?> cl = mathHandler.getClass();
        try {
            Method method = cl.getDeclaredMethod("mathSum", int.class, int.class);
            MathAnnoMultiple mathAnnoMultiple = method.getAnnotation(MathAnnoMultiple.class);
            for (MathAnno mathAnno : mathAnnoMultiple.value()) {
                mathHandler.mathSum(mathAnno.num1(), mathAnno.num2());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
