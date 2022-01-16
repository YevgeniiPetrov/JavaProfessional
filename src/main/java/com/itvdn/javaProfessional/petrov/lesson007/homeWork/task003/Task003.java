/* Задание 3
Создайте класс, в нем определите 3 поля, к этим полям создайте конструкторы и методы.
Под средством рефлексии получите всю информацию о полях, методах, конструкторах, а также
модификаторах доступа
*/

package com.itvdn.javaProfessional.petrov.lesson007.homeWork.task003;

import static com.itvdn.javaProfessional.petrov.lesson007.homeWork.task002.Task002.*;

public class Task003 {
    public static void main(String[] args) {
        try {
            Class<?> cl = Class.forName("com.itvdn.javaProfessional.petrov.lesson007.homeWork.task003.SimpleClass");
            printFields(cl);
            printConstructors(cl);
            printMethods(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
