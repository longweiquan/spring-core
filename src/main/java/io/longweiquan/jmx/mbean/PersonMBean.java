package io.longweiquan.jmx.mbean;

/**
 * Standard MBean Interface respecting the JMX name constraints.
 */
public interface PersonMBean {

	int getAge();
    void setAge(int age);
    int add(int x, int y);
}
