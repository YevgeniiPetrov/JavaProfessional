package com.itvdn.javaProfessional.petrov.lesson010.homeWork.task002;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

public class Bird implements Externalizable {
    private static int count = 0;
    private final String NAME;
    private transient int age;

    public Bird() {
        NAME = "Bird";
    }

    public Bird(String NAME, int age) {
        this.NAME = NAME;
        this.age = age;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public String getNAME() {
        return NAME;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return age == bird.age && Objects.equals(NAME, bird.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, age);
    }

    @Override
    public String toString() {
        return "Bird{" +
                "NAME='" + NAME + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(count);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        count = in.readInt();
        age = in.readInt();
    }
}
