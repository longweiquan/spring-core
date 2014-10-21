spring-core
===========

Spring core usage tutorial




Logging
-------

Spring use JCL (Jakarta Commons Logging) by default. So we have 3 choices of logging configurations :

1. By default, JCL use JUL (java.util.logging) implementation.
2. Provide JCL implementation like log4j.
3. Replace JCL by SLF4J with JCL-SLF4J bridge.