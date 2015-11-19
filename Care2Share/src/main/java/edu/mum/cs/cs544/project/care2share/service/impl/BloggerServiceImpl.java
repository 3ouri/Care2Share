package edu.mum.cs.cs544.project.care2share.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.cs544.project.care2share.dao.BloggerDao;
import edu.mum.cs.cs544.project.care2share.model.Blogger;
import edu.mum.cs.cs544.project.care2share.service.BloggerService;

@Service
@Transactional
public class BloggerServiceImpl implements BloggerService {

	@Autowired
	private BloggerDao<Blogger> bloggerDao;

	@Override
	public Blogger get(long id) {
		return bloggerDao.get(Blogger.class, id);
	}

}
