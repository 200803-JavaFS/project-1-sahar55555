package com.revature.reimDAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.revature.models.Users;
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
		
		public void update(Users usr) {
			Session ses = remHibernateUtil.getSession();
			ses.merge(usr);
		}
		
		public Users selectById(int id) {
			Session ses = remHibernateUtil.getSession();
			
			Users usr = ses.get(Users.class, id);
			
			return usr;
		}
		
		public Users selectByName(String name) {
			Session ses = remHibernateUtil.getSession();
			
			List<Users> usrList = ses.createQuery("FROM Users WHERE name ="+name, Users.class).list();
			
			Users usrs = usrList.get(0);
			
			return usrs;
		}
		
		
		public List<Users> selectAll() {
			Session ses = remHibernateUtil.getSession();
			
			//List<Character> charList = ses.createCriteria(Character.class).list();
			
			CriteriaBuilder build = ses.getCriteriaBuilder();
			
			CriteriaQuery<Users> query = build.createQuery(Users.class);
			
			List<Users> usrList = ses.createQuery(query).list();
			
			return usrList;
		}

		public List<Users> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Users findById(int id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean addUser(Users a) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean updateAvenger(Users a) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean deleteUser(int supId) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAvengerWithHome(Users a) {
			// TODO Auto-generated method stub
			return false;
		}
	}


