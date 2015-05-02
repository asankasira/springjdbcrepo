/**
 * 
 */
package com.asanka.jdbc.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Asanka Siriwardena
 *
 */
public class SpringDBDemo {


	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		SpringDAOImpl impl = context.getBean("springDAOImpl", SpringDAOImpl.class);
		
		impl.showAllProductLines();
	}

}
