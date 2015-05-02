/**
 * 
 */
package com.asanka.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * @author Asanka Siriwardena
 *
 */
public class DBConnection {
	
	
	private static final String DB_URL_CLASSIC = "jdbc:mysql://localhost/classicmodels";
	
	private static Connection conn = null;
	private final static Logger logger = Logger.getLogger(DBConnection.class);

	public static Connection getMySQLConnection() {
		
		try {
			
			loadMySQLDriver();
			logger.info("Connecting to mysql database...");
			
			if(conn == null || conn.isClosed()){
				conn = DriverManager.getConnection(DB_URL_CLASSIC, "root", "");
			}
		} catch (SQLException e) {
			logger.error("Error creating MySQL DB Connection ..", e);
		}
		
		return conn;
	}
	
	protected static void loadMySQLDriver(){
		
		logger.debug("Loading MySQL Driver Class ... ");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			logger.error("My SQL Driver class not found ...", e);
		}
	}
}
