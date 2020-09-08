package com.revature.reimDAOs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Users;
import com.revature.models.reimbursement;
import com.revature.models.status;
import com.revature.reimServices.reimbursemServices;
import com.revature.reimUtil.remHibernateUtil;

public class reimbursDao implements IreimbursementDAO {
	private static final Logger log = LogManager.getLogger(reimbursDao.class);

		
		public reimbursDao() {
			super();
		}


		@Override
		public reimbursement findremById(int remid) {
			
			Session ses=remHibernateUtil.getSession();
			try {
			reimbursement rem= ses.get(reimbursement.class, remid);
			return rem;
			}catch (HibernateException e) {
				log.error("You couldn't find reimbursement by id ");
				e.printStackTrace();
				log.error("You couldn't find reimbursement by Id");
			}
			
			return null;
		}

		@Override
		public List<reimbursement> findremByStatus(int status) {
			Session ses=remHibernateUtil.getSession();
			try {
				List<reimbursement> lst=ses.createQuery("FROM reimbursement WHERE reim_stts="+status,reimbursement.class).list();
			
			return lst;
			}catch (HibernateException e) {
				log.error("You couldn't find reimbursement by id ");
				e.printStackTrace();
				log.error("You couldn't find reimbursement by Id");
			}
			return null;
			
		}

		@Override
		public List<reimbursement> findAll() {
			System.out.println("DOA");
			Session ses=remHibernateUtil.getSession();
			try {
				List <reimbursement> remlst=ses.createQuery("FROM reimbursement").list();
				return remlst;
			}catch(HibernateException e) {
				e.printStackTrace();
				log.error("You couldn't find all reimbursements");
			}
			return null;
		}


		@Override
		public boolean addRem(reimbursement rem) {
			Session ses=remHibernateUtil.getSession();
			Transaction tx=ses.beginTransaction();
			try {
				System.out.println(rem);
				ses.save(rem);
				tx.commit();
				return true;
			}catch (HibernateException e) {
				e.printStackTrace();
				tx.rollback();
				log.error("You couldn't add reimbursement");
			return false;
			}
		}
		public List<reimbursement> getallremByAuthor( Users authr)
		{
			Session ses= remHibernateUtil.getSession();
			System.out.println("User is :"+ authr);
			List <reimbursement> ls=ses.createQuery("FROM reimbursement WHERE reim_athr ="+authr.getUserid(),reimbursement.class).list();
			return ls;
		}
		
		public boolean updatereimbursement(reimbursement rem) {
			Session ses = remHibernateUtil.getSession();
			Transaction tx = ses.beginTransaction();
			
			try {
				ses.merge(rem);
				tx.commit();
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				tx.rollback();
				log.error("You couldn't update reimbursement ");
				return false;
			} finally {
				remHibernateUtil.closeSes();
			}
		}
		
	}
		

		


