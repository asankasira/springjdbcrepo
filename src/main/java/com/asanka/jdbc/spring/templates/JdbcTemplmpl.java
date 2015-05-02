/**
 * 
 */
package com.asanka.jdbc.spring.templates;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.stereotype.Component;

import com.asanka.jdbc.spring.model.Office;
import com.asanka.jdbc.spring.model.ProductLine;

/**
 * @author Asanka Siriwardena
 *
 */
@Component
public class JdbcTemplmpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	private final static Logger log = Logger.getLogger(JdbcTemplmpl.class);
	
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(getDataSource());
	}
	
	public Integer getOrderCount(){
		String sql = "select count(*) from orders";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	/**
	 * fails when multiple results found
	 */
	public String getProductCode(int orderNumber){
		String sql = "select productCode from orderDetails where ordernumber = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{orderNumber}, String.class);
	}
	
	public Office getOffice(int officeCode){
		String sql = "select * from offices where officecode = ?";
		return jdbcTemplate.queryForObject(sql, new OfficeRowMapper(), officeCode);
	}
	
	public List<Office> getAllOfficeLocations(){
		String sql = "select * from offices";
		return jdbcTemplate.query(sql, new OfficeRowMapper());
	}
	
	
	/*DML Operations*/
	public void insertProductLine(ProductLine productLine){
		String sql = "Insert into productlines(productLine, textDescription) values(?,?)";
		jdbcTemplate.update(sql, productLine.getProductLine(), productLine.getTextDescription());
		log.info("ProductLine " + productLine.getProductLine() + " inserted successfully");
	}
	
	/*DDL Operations*/
	public void createTraingle(){
		String sql = "create table traingle (id int not null, name varchar(20), primary key(id)) ";
		jdbcTemplate.execute(sql);
		log.info("DDL statement executed successfully..!");
	}
	
	private static final class OfficeRowMapper implements RowMapper<Office>{

		@Override
		public Office mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Office office = new Office();
			office.setOfficeCode(rs.getInt("officecode"));
			office.setCity(rs.getString("city"));
			office.setPhone(rs.getString("phone"));
			office.setAddressLine1(rs.getString("addressLine1"));
			office.setAddressLine2(rs.getString("addressLine2"));
			office.setState(rs.getString("state"));
			office.setCountry(rs.getString("country"));
			office.setPostalCode(rs.getString("postalCode"));
			
			return office;
		}
		
	}
}
