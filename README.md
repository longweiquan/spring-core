spring-core
===========

Spring core usage tutorial




Logging
-------

Spring use JCL (Jakarta Commons Logging) by default. So we have 3 choices of logging configurations :

1. By default, JCL use JUL (java.util.logging) implementation.
2. Provide JCL implementation like log4j.
3. Replace JCL by slf4j with JCL-slf4j bridge.

SLF4J has better performance than JCL because SLF4J is Compile-time while JCL is Runtime.
SLF4J also works better in OSGi.

See examples below

JCL with JUL
```
<!-- Spring include JCL, by default, JCL use JUL -->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context</artifactId>
	<version>4.1.1.RELEASE</version>
</dependency>
```

JCL with log4j
```
<!-- Spring include JCL, here JCL is provaided by log4j -->
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context</artifactId>
	<version>4.1.1.RELEASE</version>
</dependency>
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

slf4j with log4j
```
<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-context</artifactId>
	<version>4.1.1.RELEASE</version>
	<exclusions>
		<!-- [slf4j-conf-1] exclude JCL from spring -->
        <exclusion>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
  	
<!-- [slf4j-conf-2] bridge JCL to slf4j API -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>jcl-over-slf4j</artifactId>
    <version>1.7.7</version>
</dependency>
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.7</version>
</dependency>
<!-- [slf4j-conf-3] bridge slf4j API to log4j -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-log4j12</artifactId>
    <version>1.7.7</version>
</dependency>
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```