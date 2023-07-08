package com.jdbc.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleJdbc {

	public static void main(String[] args) throws SQLException {
		//TODO Auto-generated method stub
		//jdbc is protocal which is used to connect to relational db via java application.
		
		//question 1 -> create a jdbc connection 
		//              and add a new table to the database 
		
		//default port for mysql - 3306
		//postgre : 5432
		
		
		//install the mysql workbench with all the deafult packages
		//create a db
		//add a new table
		//add a record to the table
		//get the record by id 
		//update the record 
		//delete the record   
//--------//String url = "jdbc:mysql://localhost:3306/database_name";----------------------------------
		  //String username = "root";
		  //String password = "your_password"; // Replace with your actual password
		  //Connection connection = DriverManager.getConnection(url, username, password);
		  //jdbc//databse//localhost//portNo//userid//username//password
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb","prafful","prafful");
		
		Statement statement = connection.createStatement();
		
		//executing query
		statement.execute("create table lect5_attendance(id int primary key, name varchar(40))");
		
		//in sql if i forgot ROOT password then i need to reinstall
		//other password i can update
		
		
//----------------------------------HANDLING THIS ERRROR----------------------------------	
//		xception in thread "main" java.sql.SQLException: No suitable driver found for jdbc:mysql://127.0.0.1:3306/attendancel5
//			at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:706)
//			at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:229)
//			at com.jdbc.examples.SampleJdbc.main(SampleJdbc.java:27)
//	REASON---------
//WHY DO WE NEED DRIVER? 
//there might be some implentation that does not exist here and may need 
//there might be some code inside that is depend on this jar which our existing class connection does
//   not have implementation..get connection may have dependency on that jar
//so we need my sql driver jar

//if i click on connection.createstatement we cant find any implentaton of it 
//it is not present so
//download that jar --fron mysql driver jar maven,(not pom)try maven central rep
		
//------------------------------------Handling this error 2-----------------------------------
//Exception in thread "main" java.sql.SQLException: Access denied for user 'root'@'localhost' (using password: NO)
//at com.mysql.cj.jdbc.exceptions.SQLError.createSQLException(SQLError.java:129)
//at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:122)
//at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:828)
//at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:448)
//at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:241)
//at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:198)
//at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:681)
//at java.sql/java.sql.DriverManager.getConnection(DriverManager.java:229)
//at com.jdbc.examples.SampleJdbc.main(SampleJdbc.java:27)
	}

}







//proper way
//package com.jdbc.examples;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class SampleJdbc {
//
//    public static void main(String[] args) {
//        Connection connection = null;
//        Statement statement = null;
//
//        try {
//            // Establish the JDBC connection
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "", "password");
//
//            // Create a statement
//            statement = connection.createStatement();
//
//            // Execute an SQL query to create the table
//            String createTableSql = "CREATE TABLE IF NOT EXISTS lect5_attendance (id INT PRIMARY KEY, name VARCHAR(40))";
//            statement.execute(createTableSql);
//
//            System.out.println("Table created successfully.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // Close the statement and connection
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}

