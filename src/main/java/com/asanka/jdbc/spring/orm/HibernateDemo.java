package com.asanka.jdbc.spring.orm;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asanka.jdbc.spring.model.Office;

public class HibernateDemo {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		HibernateSpringDAOImpl springDAOImpl = context.getBean("hibernateSpringDAOImpl", HibernateSpringDAOImpl.class);
		
		/*List<Office> officeList = springDAOImpl.getAllOfficeLocations();
		
		if(officeList != null && !officeList.isEmpty()){
			for (Office office : officeList) {
				
				System.out.println(office.getOfficeCode() + " " + office.getCity());
			}
		}*/
		
		System.out.println(springDAOImpl.getAllOfficeLocations());
		System.out.println("@@@@@@ Triangle count from Hibernate: "+springDAOImpl.getTriangleCount());
	}

}
