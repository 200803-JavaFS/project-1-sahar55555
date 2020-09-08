package com.revature.reimDAOs;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.revature.models.Users;
import com.revature.models.useRl;
import com.revature.reimUtil.remHibernateUtil;

public class UsersDao implements IUsersDao {
	
	public UsersDao() {
	
			super();
		}
		
		public void insert(Users usr) {
			Session ses = remHibernateUtil.getSession();
			
			Transaction tx = ses.beginTransaction();
			
			ses.save(usr);
			
			tx.commit();
		}
		
//		public void update(Users usr) {
//			Session ses = remHibernateUtil.getSession();
//			ses.merge(usr);
//		}
		
		public Users selectById(int id) {
			Session ses = remHibernateUtil.getSession();
			
			Users usrs = ses.get(Users.class, id);
			
			return usrs;
		}
		
		public Users getUserByUsername(String username) {
			Session sesh = remHibernateUtil.getSession();
			
			List<Users> list = sesh.createQuery("FROM Users WHERE usrnm = '"+username+"'", Users.class).list();
			Users u = list.get(0);
			
			return u;
		}
		
//		public Users selectByName(String name) {
//			Session ses = remHibernateUtil.getSession();
//			
//			List<Users> usrList = ses.createQuery("FROM Users WHERE name ="+name, Users.class).list();
//			
//			Users usrs = usrList.get(0);
//			
//			return usrs;
//		}
		
		public Users getUbypswd(String pswd) {
			Session ses = remHibernateUtil.getSession();
			
			List<Users> usrList = ses.createQuery("FROM Users WHERE usrpaswd ="+pswd, Users.class).list();
			
			Users usrs = usrList.get(0);
			
			return usrs;
		}

		public List<Users> findAll() {
			Session ses = remHibernateUtil.getSession();
			
			List<Users> list = ses.createQuery("FROM Users").list();
			
			return list;
		}

		
			public Users findusrByusrnm(String usr) {
				Session ses=remHibernateUtil.getSession();
				Users usrs=ses.createQuery("FROM Users where usrnm='"+usr+"'",Users.class).list().get(0);
				return usrs;
			}
		@Override
		public Users findById(int id) {
			Session ses=remHibernateUtil.getSession();
			Users usrs=ses.get(Users.class, id);
			return usrs;
		}

		@Override
		public boolean addUser(Users usrs) {
			Session ses=remHibernateUtil.getSession();
			Transaction tx= ses.beginTransaction();
			try {
				ses.save(usrs);
				tx.commit();
				return true;
			}catch(HibernateException e) {
				e.printStackTrace();
			}
			return false;
		}

		@Override
		public boolean updateUsers(Users usrs) {
			Session ses=remHibernateUtil.getSession();
			Transaction tx= ses.beginTransaction();
			try {
				ses.merge(usrs);
				tx.commit();
				return true;
			}catch (HibernateException e) {
				e.printStackTrace();
				tx.rollback();
			
			return false;
			}
		}
		
		

		public int userRoleid(String username) {
		Session ses=remHibernateUtil.getSession();
		Users usrs=ses.createQuery("FROM Users where usrnm='"+username+"'",Users.class).list().get(0);
			useRl usrlId=usrs.getUsr_rlid();
			return usrlId.getUseroleid();
	
	}
			
	}

//public List<Users> selectAll() {
//Session ses = remHibernateUtil.getSession();
//
////List<Character> charList = ses.createCriteria(Character.class).list();
//
//CriteriaBuilder build = ses.getCriteriaBuilder();
//
//CriteriaQuery<Users> query = build.createQuery(Users.class);
//
//List<Users> usrs = ses.createQuery(query).list();
//
//return usrs;
//}

