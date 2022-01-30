package com.itvdn.javaProfessional.petrov.lesson014.homeWork.task003;

import com.itvdn.javaProfessional.petrov.lesson014.homeWork.task002.MyClass2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass_2 extends MyClass2 {
    private Lock reentrantLock;

    public MyClass_2() {
        reentrantLock = new ReentrantLock();
    }

    public Lock getReentrantLock() {
        return reentrantLock;
    }

    @Override
    public void run() {
        if (reentrantLock.tryLock()) {
            if (((MyClass_1) getMyClass1()).getReentrantLock().tryLock()) {
                try {
                    getMyClass1().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    ((MyClass_1) getMyClass1()).getReentrantLock().unlock();
                    reentrantLock.unlock();
                }
            } else {
                reentrantLock.unlock();
            }
        }
    }
}
