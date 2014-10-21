package io.longweiquan.jmx;

import io.longweiquan.jmx.modelmbean.SpringManagedResource;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

@Configuration
@EnableMBeanExport
@ComponentScan(basePackageClasses=SpringManagedResource.class)
public class SpringModelMBeanApplication {

	@Bean
	public MBeanServer getMBeanServer() {
		return ManagementFactory.getPlatformMBeanServer();
	}

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				SpringModelMBeanApplication.class);
		
		System.out.println("Waiting forever..."); 
        Thread.sleep(Long.MAX_VALUE); 
	}
}
