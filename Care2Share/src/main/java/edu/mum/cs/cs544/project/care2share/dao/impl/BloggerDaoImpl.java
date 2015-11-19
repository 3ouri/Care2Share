package edu.mum.cs.cs544.project.care2share.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.project.care2share.dao.BloggerDao;
import edu.mum.cs.cs544.project.care2share.model.Blogger;

@Repository
@Transactional
public class BloggerDaoImpl extends GeneralDaoImpl<Blogger> implements BloggerDao<Blogger> {

	@Override
	public Blogger getByUsername(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Blogger where user.username = :username");
		query.setString("username", username);
		return (Blogger) query.list().get(0);
	}

}
