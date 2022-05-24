package com.demo;

import java.util.HashSet;
import java.util.Set;

import org.apache.catalina.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateMavenApplication {

	
	  static User userObj; static Session sessionObj; static SessionFactory
	  sessionFactoryObj;
	 
 

	public static void main(String[] args) {
		SpringApplication.run(HibernateMavenApplication.class, args);
		System.out.println("Hibernate many to many (Annotation)");
		Session session = Util.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
	        stock.setStockCode("1001");
	        stock.setStockName("HAMAM");
	 
	        Category category1 = new Category("CONSUMER","CONSUMER COMPANY");
	        Category category2 = new Category("INVESTMENT","INVESTMENT COMPANY");
	       
			/*
			 * category1.setName("CONSUMER"); category1.setDesc("CONSUMER COMPANY");
			 * 
			 * category1.setName("INVESTMENT"); category1.setDesc("INVESTMENT COMPANY");
			 */
			
			  Set<Category> categories = new HashSet<Category>();
			  categories.add(category1); 
			  categories.add(category2);
			  
			  
			  stock.setCategories(categories);
			  //category1.setStocks(stock);
			// session.persist(category1);
			 // session.persist(category2);
	        session.save(stock);
	    
		session.getTransaction().commit();
		session.close();
		System.out.println("Done");
		}
}
