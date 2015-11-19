package edu.mum.cs.cs544.project.care2share.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.project.care2share.dao.BloggerDao;
import edu.mum.cs.cs544.project.care2share.dao.PostDao;
import edu.mum.cs.cs544.project.care2share.model.Blogger;
import edu.mum.cs.cs544.project.care2share.model.Post;
import edu.mum.cs.cs544.project.care2share.service.PostService;

@Service
@Transactional
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDao<Post> postDao;

	@Autowired
	private BloggerDao<Blogger> bloggerDao;

	@Override
	public List<Post> getAll() {
		return postDao.getAll();
	}

	@Override
	public Post add(Post post, String username) {
		Blogger blogger = bloggerDao.getByUsername(username);
		post.setBlogger(blogger);
		post.setPublishedDate(new Date());
		return postDao.add(post);
	}

	@Override
	public Post get(long id) {
		return postDao.get(Post.class, id);
	}

	@Override
	public Post update(Post post, String username) {
		Blogger blogger = bloggerDao.getByUsername(username);
		post.setBlogger(blogger);
		post.setPublishedDate(new Date());
		return postDao.update(post);
	}

	@Override
	public boolean delete(long id) {
		return postDao.delete(Post.class, id);
	}

	@Override
	public List<Post> getAllByUsername(String username) {
		return postDao.getAllByUsername(username);
	}

	@Override
	public List<Post> getAllByBloggerId(int id) {
		return postDao.getAllByBloggerId(id);
	}

}
