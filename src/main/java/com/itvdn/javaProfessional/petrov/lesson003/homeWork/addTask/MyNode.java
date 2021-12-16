package com.itvdn.javaProfessional.petrov.lesson003.homeWork.addTask;

public class MyNode<TKey, TValue> {
    private TKey key;
    private TValue value;
    private MyNode next;

    public MyNode(TKey key, TValue value) {
        this.key = key;
        this.value = value;
    }

    public TKey getKey() {
        return key;
    }

    public TValue getValue() {
        return value;
    }

    public void setValue(TValue value) {
        this.value = value;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
