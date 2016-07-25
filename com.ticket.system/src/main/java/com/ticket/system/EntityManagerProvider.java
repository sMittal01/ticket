package com.ticket.system;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {
	
	private static EntityManagerProvider instance;
	
	private static EntityManagerFactory fact;
	
	
	public static synchronized EntityManagerProvider getInstance(){
		if( null ==  instance ){
			instance = new EntityManagerProvider();
			
		}
		return instance;
	}
	
	public static EntityManager getEm(){
		if(null == fact){
			fact = Persistence.createEntityManagerFactory("persistenceUnit");
		}
		return fact.createEntityManager();
	}

}
