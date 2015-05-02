package com.asanka.jdbc.spring.orm;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asanka.jdbc.spring.model.Office;

@Repository
public class HibernateSpringDAOImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger log = Logger.getLogger(HibernateSpringDAOImpl.class);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public Long getTriangleCount(){
		String hql = "select count(*) from Traingle";
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		
		return (Long)query.uniqueResult();
	}
	
	public List<Office> getAllOfficeLocations(){
		String hql = " from Office";
		Session session = getSessionFactory().openSession();
		Query query = session.createQuery(hql);	
		
		List<Office> result = query.list();		
		return result;
	}
	
	
}
