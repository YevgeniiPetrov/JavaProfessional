package com.itvdn.javaProfessional.petrov.lesson003.homeWork.addTask;

import java.util.Arrays;

public class MyHashMap<TKey, TValue> {
    private class MyNode<TKey, TValue> {
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

    private MyNode[] buckets;
    private int size;
    private final int INITIAL_LENGTH = 16;
    private final int LOAD_FACTOR = 70;

    public MyHashMap() {
        buckets = new MyNode[INITIAL_LENGTH];
    }

    private boolean loadFactor() {
        return size * 100 / buckets.length >= LOAD_FACTOR;
    }

    private void resize() {
        MyNode[] prevBuckets = buckets;
        buckets = new MyNode[buckets.length * 2];
        for (MyNode node : prevBuckets) {
            if (node == null) {
                continue;
            }
            while (node != null) {
                int index = getIndex((TKey) node.getKey());
                TKey key = (TKey) node.getKey();
                TValue value = (TValue) node.getValue();
                if (buckets[index] == null) {
                    buckets[index] = new MyNode(key, value);
                } else {
                    addToBucket(buckets[index], key, value);
                }
                node = node.getNext();
            }
        }
    }

    private int getIndex(TKey key) {
        return key == null ? 0 : key.hashCode() & (buckets.length - 1);
    }

    private void addToBucket(MyNode node, TKey key, TValue value) {
        while (node.getNext() != null) {
            if ((key == node.getKey()) || (key != null && key.equals(node.getKey()))) {
                node.setValue(value);
                return;
            } else {
                node = node.getNext();
            }
        }
        node.setNext(new MyNode(key, value));
    }

    public void put(TKey key, TValue value) {
        if (loadFactor()) {
            resize();
        }
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new MyNode(key, value);
        } else {
            addToBucket(buckets[index], key, value);
        }
        size++;
    }

    public TValue get(TKey key) {
        int index = getIndex(key);
        MyNode node = buckets[index];
        TValue value = null;
        while (node != null) {
            if ((key == node.getKey()) || (key != null && key.equals(node.getKey()))) {
                value = (TValue) node.getValue();
                break;
            }
            node = node.getNext();
        }
        return value;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "buckets=" + Arrays.toString(buckets) +
                '}';
    }
}
