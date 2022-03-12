package com.itvdn.javaProfessional.petrov.lesson014.homeWork.task002;

public class MyClass2 extends Thread {
    private MyClass1 myClass1;

    public MyClass1 getMyClass1() {
        return myClass1;
    }

    public void setMyClass1(MyClass1 myClass1) {
        this.myClass1 = myClass1;
    }

    @Override
    public void run() {
        try {
            myClass1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
