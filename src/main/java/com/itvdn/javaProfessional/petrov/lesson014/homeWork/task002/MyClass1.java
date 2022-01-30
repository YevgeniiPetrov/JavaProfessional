package com.itvdn.javaProfessional.petrov.lesson014.homeWork.task002;

public class MyClass1 extends Thread {
    private MyClass2 myClass2;

    public MyClass2 getMyClass2() {
        return myClass2;
    }

    public void setMyClass2(MyClass2 myClass2) {
        this.myClass2 = myClass2;
    }

    @Override
    public void run() {
        try {
            myClass2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
