package com.itvdn.javaProfessional.petrov.lesson014.homeWork.task003;

import com.itvdn.javaProfessional.petrov.lesson014.homeWork.task002.MyClass1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass_1 extends MyClass1 {
    private Lock reentrantLock;

    public MyClass_1() {
        reentrantLock = new ReentrantLock();
    }

    public Lock getReentrantLock() {
        return reentrantLock;
    }

    @Override
    public void run() {
        if (reentrantLock.tryLock()) {
            if (((MyClass_2) getMyClass2()).getReentrantLock().tryLock()) {
                try {
                    getMyClass2().join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    ((MyClass_2) getMyClass2()).getReentrantLock().unlock();
                    reentrantLock.unlock();
                }
            } else {
                reentrantLock.unlock();
            }
        }
    }
}
