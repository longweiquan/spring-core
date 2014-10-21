package io.longweiquan.jmx.mbean;

/**
 * Standard MBean implementation respecting the JMX name constraints.
 */
public class Person implements PersonMBean {

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