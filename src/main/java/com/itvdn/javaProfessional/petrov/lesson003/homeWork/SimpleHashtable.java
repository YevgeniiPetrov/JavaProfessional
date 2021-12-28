/* Собственная Hashtable. Реализовать метод вставки в собственном классе SimpleHashtable.
* Собственная Hashtable. Реализовать методы замещения, удаления в собственном классе SimpleHashtable
* дополняя предыдущее задание.*/

package com.itvdn.javaProfessional.petrov.lesson003.homeWork;

import java.util.Arrays;

public class SimpleHashtable<TKey, TValue> {
    private class SimpleNode<TKey, TValue> {
        private TKey key;
        private TValue value;
        private SimpleNode prev;
        private SimpleNode next;

        public SimpleNode(TKey key, TValue value) {
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

        public SimpleNode getNext() {
            return next;
        }

        public void setNext(SimpleNode next) {
            this.next = next;
        }

        public SimpleNode getPrev() {
            return prev;
        }

        public void setPrev(SimpleNode prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "SimpleNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private SimpleNode[] buckets;
    private int size;
    private final int INITIAL_LENGTH = 16;
    private final int LOAD_FACTOR = 75;

    public SimpleHashtable() {
        buckets = new SimpleNode[INITIAL_LENGTH];
    }

    private boolean loadFactor() {
        return size * 100 / buckets.length >= LOAD_FACTOR;
    }

    private void resize() {
        size = 0;
        SimpleNode[] prevBuckets = buckets;
        buckets = new SimpleNode[buckets.length * 2];
        for (SimpleNode node : prevBuckets) {
            if (node == null) {
                continue;
            }
            while (node != null) {
                int index = getIndex((TKey) node.getKey());
                TKey key = (TKey) node.getKey();
                TValue value = (TValue) node.getValue();
                if (buckets[index] == null) {
                    buckets[index] = new SimpleNode(key, value);
                    size++;
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

    private void addToBucket(SimpleNode node, TKey key, TValue value) {
        while (node.getNext() != null) {
            if ((key == node.getKey()) || (key != null && key.equals(node.getKey()))) {
                node.setValue(value);
                return;
            } else {
                node = node.getNext();
            }
        }
        SimpleNode newNode = new SimpleNode(key, value);
        node.setNext(newNode);
        newNode.setPrev(node);
    }

    private SimpleNode removeFromBucket(SimpleNode node, TKey key) {
        SimpleNode first = node;
        while (node.getNext() != null) {
            if (key.equals(node.getKey())) {
                SimpleNode prev = node.getPrev();
                SimpleNode next = node.getNext();
                if (prev != null) {
                    prev.setNext(next);
                }
                if (next != null) {
                    next.setPrev(prev);
                }
                break;
            }  else {
                node = node.getNext();
            }
        }
        while (node.getPrev() != null) {
            node = node.getPrev();
        }
        return first == node ? node.getNext() : node;
    }

    public void put(TKey key, TValue value) {
        if (key == null || value == null) {
            throw new NullPointerException();
        }
        if (loadFactor()) {
            resize();
        }
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new SimpleNode(key, value);
            size++;
        } else {
            addToBucket(buckets[index], key, value);
        }
    }

    public void remove(TKey key) {
        if (key == null) {
            throw new NullPointerException();
        }
        int index = getIndex(key);
        if (buckets[index] == null) {
            return;
        } else {
            buckets[index] = removeFromBucket(buckets[index], key);
        }
        if (buckets[index] == null) {
            size--;
        }
    }

    public int size() {
        return size;
    }

    public TValue get(TKey key) {
        int index = getIndex(key);
        SimpleNode node = buckets[index];
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

    @Override
    public String toString() {
        SimpleNode[] temp = new SimpleNode[size];
        for (int i = 0, j = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                temp[j++] = buckets[i];
            }
        }
        return "SimpleHashtable{" +
                "buckets=" + Arrays.toString(temp) +
                '}';
    }

    public static void main(String[] args) {
        int countItems = 100;
        SimpleHashtable<String, Integer> simpleHashtable = new SimpleHashtable<>();
        for (int i = 0; i < countItems; i++) {
            simpleHashtable.put("" + i, i);
            System.out.println(simpleHashtable.size() + " " + simpleHashtable);
        }
        for (int i = 0; i < countItems; i++) {
            simpleHashtable.remove("" + i);
            System.out.println(simpleHashtable.size() + " " + simpleHashtable);
        }
    }
}
