/* Задание
В папке с примерами, ex_004_comparable.
Дописать логику, чтобы метод compareTo() осуществил поиск по скорости
(если же скорость у 2-х объектов равна, то ищем по цене) -> цене - > моделе -> цвету машины.*/

package com.itvdn.javaProfessional.petrov.lesson001.homeWork.task001;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car(190, 8000, "BMW", "Red");
        Car c2 = new Car(190, 2000, "Opel", "Black");
        Car c3 = new Car(185, 10000, "Mercedes", "White");
        Car[] c = {c1, c2, c3};

        Arrays.sort(c);   // ClassCastException
        for (Car temp : c) {
            System.out.println(temp);
        }
    }
}
