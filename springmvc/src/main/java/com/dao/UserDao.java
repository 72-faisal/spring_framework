package com.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Repository
public class UserDao {
	 private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	@Transactional
	public void insertUser(User u) {
		this.hibernateTemplate.saveOrUpdate(u);
	}

	public User getUserById(int id) {
		return this.hibernateTemplate.get(User.class, id);
	}

	@Transactional
	public void deleteUser(User u) {
		this.hibernateTemplate.delete(u);
	}

	public List<User> getAllUser() {
		return this.hibernateTemplate.loadAll(User.class);
	}

}
