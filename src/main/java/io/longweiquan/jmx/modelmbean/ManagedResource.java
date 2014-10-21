package io.longweiquan.jmx.modelmbean;

/**
 * Managed Resource used with ModelMBean.
 */
public class ManagedResource {

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