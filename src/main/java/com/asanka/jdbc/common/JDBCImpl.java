/**
 * 
 */
package com.asanka.jdbc.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.asanka.jdbc.DBConnection;



/**
 * @author Asanka Siriwardena
 *
 */
public class JDBCImpl {
	
	private final static Logger logger = Logger.getLogger(JDBCImpl.class);

	public void printOfficeLocations() {
		
		logger.info("---- Inside printOfficeLocations() ------");
		
		String sql = "Select * from offices where officecode > ?";
		
		try(Connection conn = DBConnection.getMySQLConnection();
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, 4);
			
			try(ResultSet rs = pst.executeQuery()){
				
				while(rs.next()){
					System.out.println(rs.getString("city"));
				}
			}
			
		}catch (SQLException e) {
			logger.error("SQLException inside printOfficeLocation(..) ", e);
		}
		
		logger.info("---- End of printOfficeLocations() ------");
	}
}
