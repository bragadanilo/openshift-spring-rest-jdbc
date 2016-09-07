# OpenShift - Spring Rest App Example - MySQL/JDBC

Example of an application that uses spring rest services. 

It is a basic CRUD to be used as a base project for those who wants to start to develop rest web services with spring.

###### This project is hosted in OpenShift Cloud. 
> The OpenShift `jbossews` cartridge documentation can be found at:

> http://openshift.github.io/documentation/oo_cartridge_guide.html#tomcat

#### Available Services

**GET**
	
http://<localhost:8080/app-jdbc/person
- *Get all persons*

http://<localhost:8080/app-jdbc/person/{id}
- *Get a person by id*

 
###### Installation 
It is a Maven based project. To run in eclipse it is necessary to import this project as a Existing Maven Project:
- (Import->Maven->Existing Maven Project).
- Initial script of MySql is at: src/resources/create-script.sql   
 
###### Developer
> Danilo Braga

> https://br.linkedin.com/in/bragadanilo