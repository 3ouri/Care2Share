package edu.mum.cs.cs544.project.care2share.dao;

public interface GeneralDao<T> {

	public T add(T t);

	public T get(Class<T> clazz, long id);

	public T update(T t);

	public boolean delete(Class<T> clazz, long id);

}
