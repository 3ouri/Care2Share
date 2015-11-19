package edu.mum.cs.cs544.project.care2share.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.project.care2share.dao.GeneralDao;

@Repository
@Transactional
public class GeneralDaoImpl<T> implements GeneralDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	public GeneralDaoImpl() {

	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> clazz) {
		StringBuffer stringBuffer = new StringBuffer("FROM ");
		stringBuffer.append(clazz.getSimpleName());
		Query query = sessionFactory.getCurrentSession().createQuery(stringBuffer.toString());
		return new ArrayList<T>(query.list());
	}

	@Override
	public T add(T t) {
		sessionFactory.getCurrentSession().save(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Class<T> clazz, long id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public T update(T t) {
		sessionFactory.getCurrentSession().merge(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean delete(Class<T> clazz, long id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete((T) session.load(clazz, id));
		return true;
	}

}
