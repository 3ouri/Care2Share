package edu.mum.cs.cs544.project.care2share.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.cs544.project.care2share.model.Post;
import edu.mum.cs.cs544.project.care2share.service.PostService;

@Controller
public class PostController {

	@Autowired
	private PostService postService;

	@RequestMapping("/")
	public String redirectRoot(HttpServletRequest httpServletRequest) {
		HttpSession session = httpServletRequest.getSession();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		if (userDetails == null || userDetails.getUsername() == null) {
			session.setAttribute("anonymousUser", true);
		}
		session.setAttribute("inBlogger", false);
		return "redirect:/posts";
	}

	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public String gotToMainPage(Model model) {
		model.addAttribute("posts", postService.getAll());
		return "general/main";
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public String gotToPostPage(HttpServletRequest httpServletRequest, @PathVariable int id, Model model) {
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("inBlogger", false);
		model.addAttribute("post", postService.get(id));
		return "general/post";
	}

	@RequestMapping(value = "/user/addPost", method = RequestMethod.GET)
	public String goToAddPost(@ModelAttribute("post") Post post) {
		return "blogger/addPost";
	}

	@RequestMapping(value = "/user/posts", method = RequestMethod.POST)
	public String addPost(HttpServletRequest httpServletRequest, Post post) {
		HttpSession session = httpServletRequest.getSession();
		String username = (String) session.getAttribute("username");
		postService.add(post, username);
		return "redirect:/user/posts";
	}

	@RequestMapping(value = "/user/posts/{id}", method = RequestMethod.GET)
	public String goToEditPost(Model model, @PathVariable int id) {
		model.addAttribute("post", postService.get(id));
		return "blogger/editPost";
	}

	@RequestMapping(value = "/user/posts/{id}", method = RequestMethod.POST)
	public String updatePost(HttpServletRequest httpServletRequest, Post post) {
		HttpSession session = httpServletRequest.getSession();
		String username = (String) session.getAttribute("username");
		postService.update(post, username);
		return "redirect:/user/posts";
	}

	@RequestMapping(value = "/user/posts/delete", method = RequestMethod.POST)
	public String delete(int postId) {
		postService.delete(postId);
		return "redirect:/user/posts";
	}
}
