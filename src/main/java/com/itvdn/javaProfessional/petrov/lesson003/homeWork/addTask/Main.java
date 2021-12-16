/* HashMap.
Не обращайте внимание что всего 3 метода.
метод put Довольно таки большой получиться.

1. Изначальный размер - 16
2. Когда мапа заполнена на 70% - увеличиваем. Извне мапу не увеличивают.
3. Увеличиваем на 2 раза (можно на 1.5 как в реальности)
4. При колизии, не заморачиваемся с Tree, делаем односвязанный список
Методы:

put(K key, V value)
get(K key)
size()

По желанию, можете реализовать:
getKeySet()
getValues()*/

package com.itvdn.javaProfessional.petrov.lesson003.homeWork.addTask;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        for (int i = 0; i < 100; i++) {
            myHashMap.put("" + i, ((int) (Math.random() * 100)));
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(myHashMap.get("" + i));
        }
    }
}
