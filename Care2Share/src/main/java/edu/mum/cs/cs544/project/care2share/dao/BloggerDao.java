package edu.mum.cs.cs544.project.care2share.dao;

import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.project.care2share.model.Blogger;

@Transactional
public interface BloggerDao<T> extends GeneralDao<T> {

	Blogger getByUsername(String username);

}
