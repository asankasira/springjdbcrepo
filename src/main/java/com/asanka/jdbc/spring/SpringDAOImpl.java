/**
 * 
 */
package com.asanka.jdbc.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.asanka.jdbc.DBConnection;

/**
 * @author Asanka Siriwardena
 *
 */
@Component
public class SpringDAOImpl {

	private final static Logger logger = Logger.getLogger(SpringDAOImpl.class);
	
	@Autowired
	private DataSource dataSource;

	public void printOfficeLocations() {
		
		logger.info("---- Inside printOfficeLocations() ------");
		
		String sql = "Select * from offices where officecode > ?";
		
		try(Connection conn = DBConnection.getMySQLConnection();
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			pst.setInt(1, 2);
			
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
	
	/**
	 * This impl method uses spring datasource to create a connection
	 */
	public void showAllProductLines() {
		
		logger.info("---- Inside showAllProductLines() ------");
		
		String sql = "Select * from productlines";
		
		try(Connection conn = dataSource.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql)){
			
			try(ResultSet rs = pst.executeQuery()){
				
				while(rs.next()){
					System.out.println("########## "+rs.getString("productLine")+" ##########");
				}
			}
			
		}catch (SQLException e) {
			logger.error("SQLException inside showAllProductLines(..) ", e);
		}
		
		logger.info("---- End of showAllProductLines() ------");
	}

	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
