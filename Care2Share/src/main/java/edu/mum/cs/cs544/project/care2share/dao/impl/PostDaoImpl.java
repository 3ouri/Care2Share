package edu.mum.cs.cs544.project.care2share.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.project.care2share.dao.PostDao;
import edu.mum.cs.cs544.project.care2share.model.Post;

@Repository
@Transactional
public class PostDaoImpl extends GeneralDaoImpl<Post> implements PostDao<Post> {

	public PostDaoImpl() {

	}

	@SuppressWarnings("unchecked")
	public List<Post> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("from Post order by publishedDate desc");
		return new ArrayList<Post>(query.list());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Post> getAllByUsername(String username) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Post where blogger.user.username = :username order by publishedDate desc");
		query.setString("username", username);
		return new ArrayList<Post>(query.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> getAllByBloggerId(int id) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from Post where blogger.id = :id order by publishedDate desc");
		query.setLong("id", id);
		return new ArrayList<Post>(query.list());
	}
}
