/* Задание
Создать 2 произвольных класса с полями и методами.
Необходимо синхронизировать методы этих классов между собой,
т.е. чтобы выводило на экран значения друг за другом (1 класс, 2 класс, 1, 2 и т.д.).*/

package com.itvdn.javaProfessional.petrov.lesson013.homeWork.task001;

public class Main_Test {
    public static void main(String[] args) {
        Product p = new Product();
        Producer pr = new Producer(p, 5);
        Consumer cons = new Consumer(p, 5);

        pr.start();
        cons.start();
    }
}

class Product {
    int id;
    boolean isProduced;

    synchronized void getIdProduct() {
        // Если товар не произведен, потребитель засыпает
        if (!isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Get " + this.id);
        isProduced = false;
        // Метод notify() выводит из блокировки другой поток, который находился в методе wait()
        notify();
    }

    synchronized void setIdProduct(int id) {
        // Если товар произведен, тогда засыпаем
        if (isProduced) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.id = id;
        System.out.println("Set " + this.id);
        isProduced = true;
        notify();
    }
}

class Producer extends Thread {
    Product p;
    int count;

    Producer(Product p, int count) {
        this.p = p;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 1; i < count + 1; i++) {
            p.setIdProduct(i);
        }
    }
}

class Consumer extends Thread {
    Product p;
    int count;

    Consumer(Product p, int count) {
        this.p = p;
        this.count = count;
    }

    // Получение товара
    @Override
    public void run() {
        for (int i = 1; i < count + 1; i++) {
            p.getIdProduct();
        }
    }
}

