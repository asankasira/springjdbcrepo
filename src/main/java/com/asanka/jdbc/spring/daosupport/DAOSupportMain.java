package com.asanka.jdbc.spring.daosupport;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DAOSupportMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		SimpleJdbcDaoImpl daoImpl = context.getBean("simpleDaoImpl", SimpleJdbcDaoImpl.class);
		
		System.out.println("######## Total no of Customers: " + daoImpl.getCustomerCount());
	}
}
