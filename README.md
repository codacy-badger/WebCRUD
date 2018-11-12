# WebCRUD
An application using Spring MVC and Hibernate to provide the CRUD Operations on a MySQL table.
  
## Compiling 
Create a .war-File using maven (mvn clean install)
  
## Usage
Start the .war-Container on a Java-EE Server.
  
## MySQL  
Create the table using the following command:
```mysql
CREATE TABLE `customers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `forename` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
  
## Usage
All replies and requests are made with JSON  
  
POST /customer - Creates Customer  
GET /customer - Responds with a List of all Customers  
GET /customer/id - Responds with the Customer with the given ID  
DELETE /customer/id - Deletes Customer with the given ID  
PUT /customer/id - Updates the Customer with the given ID
