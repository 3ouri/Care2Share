package edu.mum.cs.cs544.project.care2share.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.cs544.project.care2share.service.BloggerService;
import edu.mum.cs.cs544.project.care2share.service.PostService;

@Controller
public class BloggerController {

	@Autowired
	private BloggerService bloggerService;

	@Autowired
	private PostService postService;

	@RequestMapping(value = "/blogger/{id}", method = RequestMethod.GET)
	public String gotToBloggerPosts(HttpServletRequest httpServletRequest, @PathVariable int id, Model model) {
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("inBlogger", true);
		model.addAttribute("blogger", bloggerService.get(id));
		model.addAttribute("posts", postService.getAllByBloggerId(id));
		model.addAttribute("aboutUrl", id + "/about");
		model.addAttribute("contactUrl", id + "/contact");
		return "general/main";
	}

	@RequestMapping(value = "/blogger/{id}/about", method = RequestMethod.GET)
	public String gotToAboutPage(@PathVariable int id, Model model) {
		model.addAttribute("blogger", bloggerService.get(id));
		model.addAttribute("postsUrl", "../../blogger/" + id);
		model.addAttribute("contactUrl", "../" + id + "/contact");
		return "general/about";
	}

	@RequestMapping(value = "/blogger/{id}/contact", method = RequestMethod.GET)
	public String gotToContactPage(@PathVariable int id, Model model) {
		model.addAttribute("blogger", bloggerService.get(id));
		model.addAttribute("postsUrl", "../../blogger/" + id);
		model.addAttribute("aboutUrl", "../" + id + "/about");
		return "general/contact";
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String gotToLoginPage(Model model) {
		return "blogger/login";
	}

	@RequestMapping(value = "/user/posts", method = RequestMethod.GET)
	public String gotToUserPage(HttpServletRequest httpServletRequest, Model model) {
		HttpSession session = httpServletRequest.getSession();
		session.setAttribute("anonymousUser", false);
		String username = (String) session.getAttribute("username");
		model.addAttribute("posts", postService.getAllByUsername(username));
		return "blogger/postsList";
	}
}
