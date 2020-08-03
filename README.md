# A microservice demo for using Google JIB

[![Build Status](https://ci.devopoly.de/api/badges/lukibahr/maven-jib-sample/status.svg)](https://ci.devopoly.de/lukibahr/maven-jib-sample)

"Jib is a Maven plugin for building Docker and OCI images for your Java applications."
(from https://github.com/GoogleContainerTools/jib/tree/master/jib-maven-plugin)

This project is a demo setup on how to use the maven job plugin, development by Google. 
The application is based on Spring Boot and contains a UUIDController that generates a UUID and prints it to the screen.

The maven jib plugin containerizes the application when the `jib:build` goal is executed. You can even include the jib goal 
in another maven lifecycle like `mvn package`

Jib is based on OCI, OpenContainerInterface, which provides a standardidzesd interface for container runtimes

## Prerequisites

All you need is a docker daemin and a running maven installation (maven requires java)

## Usage

Run the maven project locally: `mvn exec:java`
Create a jar file: `mvn clean package`
Create a docker build: `mvn jib:build`
Included in packaging: `mvn package`
 
You can then run the container on any docker environment that can connect to the registry

```sh
$ docker pull lukasbahr/jib-demo:latest
$ docker run -it -p 8888:8888 lukasbahr/jib-demo:latest
```

Note, that the most registries require authentication to push an image.
To avoid security issues, do not put your credentials in your pom.xml. Instead, you can export them via environment variables and then interpolate them with maven:

```xml
<auth>
    <username>${env.DOCKERHUB_USER}</username>
    <password>${env.DOCKERHUB_PASSWORD}</password>
</auth>
```

## Run the container

Use docker to run the container: ``docker run -it -p 8080:8888 lukasbahr/uuid:0.2.5-SNAPSHOT``. 

## Metrics and endpoints

The main application has an endpoint available for uuid generation at ``http://localhost:8888/uuid``. 
There are metrics endpoints available at ``http://localhost:8080/actuator``. Navigate through the subroutes, e.g. `/actuator/prometheus` or `/actuator/metrics`.

## Further reading

- [https://dzone.com/articles/monitoring-using-spring-boot-2-prometheus-and-graf](https://dzone.com/articles/monitoring-using-spring-boot-2-prometheus-and-graf)