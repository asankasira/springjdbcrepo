/**
 * 
 */
package com.asanka.jdbc.spring.templates;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asanka.jdbc.spring.model.Office;
import com.asanka.jdbc.spring.model.ProductLine;

/**
 * @author Asanka Siriwardena
 *
 */
public class SpTemplDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		JdbcTemplmpl tempimpl = context.getBean("jdbcTemplmpl", JdbcTemplmpl.class);
		NamedParamTemplmpl npTmp = context.getBean("namedParamTemplmpl", NamedParamTemplmpl.class);
		
		
	/*	System.out.println("######## Total Orders: "+tempimpl.getOrderCount());
		System.out.println("######## Product Code: " + tempimpl.getProductCode(10118));
		System.out.println(tempimpl.getOffice(1));
		System.out.println(tempimpl.getAllOfficeLocations());*/
		
		/*ProductLine prodLine = new ProductLine();
		prodLine.setProductLine("Three wheelers");
		prodLine.setTextDescription("Provides a cost effective transport mode for short distances.");
		
		tempimpl.insertProductLine(prodLine);*/
		
		//tempimpl.createTraingle();
		
		/** Name Param Test */
		npTmp.insertTraingle(3, "Third Triangle");
	}

}
