package io.longweiquan.jmx.mbean;

/**
 * Standard MXBean Interface respecting the JMX name constraints.
 */
public interface PersonMXBean {

	int getAge();
    void setAge(int age);
    int add(int x, int y);
}
