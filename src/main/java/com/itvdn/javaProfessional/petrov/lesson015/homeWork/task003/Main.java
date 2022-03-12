/* Задание 3
Создать класс Book, сделать 3 поля и соответствующие методы. Необходимо реализовать замыкание
анонимного класса и лямбда-выражения.*/

package com.itvdn.javaProfessional.petrov.lesson015.homeWork.task003;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book 1", "Author 1", 100));
        books.add(new Book("Book 2", "Author 2", 150));
        books.add(new Book("Book 3", "Author 3", 200));
        Operation operation = book -> System.out.println(book);
        books.forEach(operation::read);
    }
}
