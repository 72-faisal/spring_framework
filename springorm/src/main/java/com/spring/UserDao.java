package com.spring;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UserDao {
	
	public HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public void insertUser(User u) {
		this.hibernateTemplate.save(u);
	}
	public User getUserById(int id) {
		return this.hibernateTemplate.get(User.class, id);
	}
	@Transactional
	public void updateUser(User u) {
		this.hibernateTemplate.save(u);
	}
	
	@Transactional
	public void deleteUser(User u) {
		this.hibernateTemplate.save(u);
	}
}
