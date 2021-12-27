/* Задание 3
Создайте класс, в нем определите 3 поля, к этим полям создайте конструкторы и методы.
Под средством рефлексии получите всю информацию о полях, методах, конструкторах, а также
модификаторах доступа
*/

package com.itvdn.javaProfessional.petrov.lesson007.homeWork.task003;

public class SimpleClass {
    private String firstField;
    private int secondField;
    private double thirdField;

    public SimpleClass(String firstField) {
        this.firstField = firstField;
    }

    public SimpleClass(String firstField, int secondField) {
        this.firstField = firstField;
        this.secondField = secondField;
    }

    public SimpleClass(String firstField, int secondField, double thirdField) {
        this.firstField = firstField;
        this.secondField = secondField;
        this.thirdField = thirdField;
    }

    public String getFirstField() {
        return firstField;
    }

    public void setFirstField(String firstField) {
        this.firstField = firstField;
    }

    public int getSecondField() {
        return secondField;
    }

    public void setSecondField(int secondField) {
        this.secondField = secondField;
    }

    public double getThirdField() {
        return thirdField;
    }

    public void setThirdField(double thirdField) {
        this.thirdField = thirdField;
    }
}
