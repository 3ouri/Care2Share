package edu.mum.cs.cs544.project.care2share.service;

import java.util.List;

import edu.mum.cs.cs544.project.care2share.model.Post;

public interface PostService {

	public List<Post> getAll();

	public Post add(Post post, String username);

	public Post get(long id);

	public Post update(Post post, String username);

	public boolean delete(long id);

	public List<Post> getAllByUsername(String username);

	public List<Post> getAllByBloggerId(int id);
}
