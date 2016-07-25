package com.ticket.system;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ticket.system.beans.TicketBean;

public class TicketController {

	private static TicketController instance;

	private TicketController(){

	}

	public static synchronized TicketController getInstance(){
		if(null == instance){
			instance = new TicketController();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<TicketBean> getTicketList(String userName){
		EntityManager em = EntityManagerProvider.getEm();
		Query query = em.createNamedQuery("findAllTicketsProcessedByUser");
		query.setParameter("username", userName);
		List<TicketBean> list = query.getResultList();
		return list;
	}

	public void createTicket(String userName){
		EntityManager em = EntityManagerProvider.getEm();

		try{
			em.getTransaction().begin();
			TicketBean bean = new TicketBean();
			bean.setDescription("Boo");
			bean.setProcessor(userName);
			bean.setReporter(userName);
			bean.setStatus("created");
			em.persist(bean);
			em.getTransaction().commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public TicketBean getTicket(String id){
		EntityManager em = EntityManagerProvider.getEm();
		String act = id.substring(0, id.indexOf("."));
		System.out.println(act);
		TicketBean bean = em.find(TicketBean.class, Integer.valueOf(act));
		return bean;
	}

	public void createTicket(String status, String processor, String reporter, String desc) {
		EntityManager em = EntityManagerProvider.getEm();

		try{
			em.getTransaction().begin();
			TicketBean bean = new TicketBean();
			bean.setDescription(desc);
			bean.setProcessor(processor);
			bean.setReporter(reporter);
			bean.setStatus(status);
			em.persist(bean);
			em.getTransaction().commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

	public void updateTicket(Integer id, String status, String processor, String reporter, String desc) {
		EntityManager em = EntityManagerProvider.getEm();
		TicketBean bean = em.find(TicketBean.class, id);
		if(null != bean){
			try{
				em.getTransaction().begin();
				bean.setDescription(desc);
				bean.setProcessor(processor);
				bean.setReporter(reporter);
				bean.setStatus(status);
				em.merge(bean);
				em.getTransaction().commit();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}


	}



}
