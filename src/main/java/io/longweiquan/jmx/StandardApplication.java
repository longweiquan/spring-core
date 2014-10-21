package io.longweiquan.jmx;

import io.longweiquan.jmx.mbean.PersonMBean;
import io.longweiquan.jmx.mbean.PersonMXBean;
import io.longweiquan.jmx.mbean.PersonX;
import io.longweiquan.jmx.mbean.Person;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class StandardApplication {

	public static void main(String[] args)  throws Exception { 
	     
        MBeanServer server = ManagementFactory.getPlatformMBeanServer(); 

        PersonMBean mbean = new Person(); 
        server.registerMBean(mbean, new ObjectName("io.longweiquan.jmx:type=PersonMBean")); 
        PersonMXBean mxbean = new PersonX(); 
        server.registerMBean(mxbean, new ObjectName("io.longweiquan.jmx:type=PersonMXBean")); 
        
        System.out.println("Waiting forever..."); 
        Thread.sleep(Long.MAX_VALUE); 
    }
}
