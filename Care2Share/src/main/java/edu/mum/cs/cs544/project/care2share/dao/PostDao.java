package edu.mum.cs.cs544.project.care2share.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.project.care2share.model.Post;

@Transactional
public interface PostDao<T> extends GeneralDao<T> {

	List<Post> getAllByUsername(String username);

	List<Post> getAll();

	List<Post> getAllByBloggerId(int id);

}
