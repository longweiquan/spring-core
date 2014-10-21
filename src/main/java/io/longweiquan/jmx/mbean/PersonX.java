package io.longweiquan.jmx.mbean;

/**
 * There is not name nor package constraint for MXBean implementation. 
 */
public class PersonX implements PersonMXBean {

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int add(int x, int y) {
        return x + y;
    }
}