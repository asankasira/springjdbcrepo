package com.asanka.jdbc.spring.templates;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class NamedParamTemplmpl {

	private DataSource dataSource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//Use SimpleJdbcTemplate class to use both features of Jdbc and NamedParameterJdbc template classes.
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public void insertTraingle(int Id, String trianName){
		String sql = "insert into traingle(id, name) values (:tId, :tName)";
		SqlParameterSource parameterSource = new MapSqlParameterSource()
													.addValue("tId", Id)
													.addValue("tName", trianName);
		
		namedParameterJdbcTemplate.update(sql, parameterSource);
	}
}
