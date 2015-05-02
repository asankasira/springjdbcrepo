package com.asanka.jdbc.spring.daosupport;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

@SuppressWarnings("deprecation")
public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {

	public int getCustomerCount(){
		
		String sql = "select count(*) from customers";
		return getSimpleJdbcTemplate().queryForInt(sql);
	}
}
