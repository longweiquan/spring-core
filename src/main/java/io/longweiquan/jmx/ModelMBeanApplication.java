package io.longweiquan.jmx;

import io.longweiquan.jmx.modelmbean.ManagedResource;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;

import javax.management.Descriptor;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.modelmbean.DescriptorSupport;
import javax.management.modelmbean.ModelMBean;
import javax.management.modelmbean.ModelMBeanInfoSupport;
import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.management.modelmbean.RequiredModelMBean;

/**
 * The purpose of this class is to demonstrate use of ModelMBeans in the raw.
 */
public class ModelMBeanApplication {

	/**
	 * Construct the meta information for the SimpleCalculator ModelMBean
	 * operations and the operations' parameters.
	 * 
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	private static ModelMBeanOperationInfo[] buildModelMBeanOperationInfo() throws NoSuchMethodException, SecurityException {
		
		Method add = ManagedResource.class.getMethod("add", Integer.TYPE, Integer.TYPE);
		Method getAge = ManagedResource.class.getMethod("getAge");
		Method setAge = ManagedResource.class.getMethod("setAge", Integer.TYPE);
		
		ModelMBeanOperationInfo addOperationInfo = new ModelMBeanOperationInfo("Addition", add);
		ModelMBeanOperationInfo getAgeOperationInfo = new ModelMBeanOperationInfo("getAge", getAge);
		ModelMBeanOperationInfo setAgeOperationInfo = new ModelMBeanOperationInfo("setAge", setAge);

		return new ModelMBeanOperationInfo[] { addOperationInfo, getAgeOperationInfo, setAgeOperationInfo };
	}

	private static Descriptor buildDescriptor() {
		Descriptor descriptor = new DescriptorSupport();
		descriptor.setField("name", "ModelMBeanInTheRaw");
		descriptor.setField("descriptorType", "mbean");
		return descriptor;
	}

	/**
	 * Create a ModelMBean the "old fashioned" way.
	 * 
	 * @return ModelMBean created directly without framework.
	 */
	private static ModelMBean createRawModelMBean() throws Exception {

		ModelMBeanInfoSupport modelMBeanInfo = new ModelMBeanInfoSupport(
				ManagedResource.class.getName(),
				"person Managed Resource", null, // attributes
				null, // constructors
				buildModelMBeanOperationInfo(), // operations
				null, // notifications
				buildDescriptor());

		RequiredModelMBean modelMbean = new RequiredModelMBean(modelMBeanInfo);
		modelMbean.setManagedResource(new ManagedResource(), "ObjectReference");
		return modelMbean;
	}

	/**
	 * Demonstate use of ModelMBean.
	 * 
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws Exception {

		MBeanServer server = ManagementFactory.getPlatformMBeanServer();
		server.registerMBean(createRawModelMBean(), new ObjectName("io.longweiquan.jmx:type=ModelMBean"));

		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);
	}
}