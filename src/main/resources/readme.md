Architecture of JMX Technology
==============================

The JMX technology can be diveided into three levels, as follow :

- Instrumentation
- JMX agent
- Remote management

Instrumentation
---------------

Instrument the resource using MBean or MXBean

JMX Agent
---------

The core component a JMX agent is the MBean server, a managed object server in which MBeans are registered.

Remote Management
-----------------

The MBean server relies on protocol adaptors and connectors to make a JMX agent accessible from management applications outside the agent's Java Virtual Machine.


Monitoring and Management of the Java Virtual Machine
=====================================================

Platform MXBeans and the Platform MBean Server
----------------------------------------------

The platform MXBeans are a set of MXBeans that is provided with the Java SE platform for monitoring and managing the Java VM.


JConsole
--------

The Java SE platform includes the JConsole monitoring and management tool, which complies with the JMX specification.


Standard MBeans
---------------

- MBean Interface
- MBean Implementation

Notifications
-------------
???

Remote Management
-----------------
???

Exposing a Resource for Remote Management By JConsole
-----------------------------------------------------
???




