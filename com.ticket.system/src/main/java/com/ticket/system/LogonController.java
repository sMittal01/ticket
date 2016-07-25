package com.ticket.system;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.ticket.system.beans.LogonBean;

public class LogonController {

	private static LogonController instance;
	
	private LogonController(){
		
	}
	
	public synchronized static LogonController getInstance(){
		if(null == instance){
			instance = new LogonController();
		}
		return instance;
	}
	
	public void createUser(String userName, String pwd){
		EntityManager manager = EntityManagerProvider.getEm();
		EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
        	manager.persist(new LogonBean(userName, pwd));
        } catch (Exception e) {
            throw new PersistenceException("Error while creating the User");
        }
        tx.commit();
	}
	
	public static LogonBean getUser(String userName, String pwd){
		EntityManager manager = EntityManagerProvider.getEm();
		LogonBean bean = manager.find(LogonBean.class, userName);
		return bean;
	}
	
}
