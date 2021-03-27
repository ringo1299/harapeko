package jp.co.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.example.entity.Blog;
import jp.co.example.entity.User;
import jp.co.example.form.BlogForm;
import jp.co.example.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	HttpSession  session;

	@Autowired
	private User userData;

	@Autowired
	private Blog blogData;

	@Autowired
	private BlogService blogService;

	@RequestMapping("/blog_form")
	public String blog_form(@ModelAttribute("blog_form") BlogForm blogForm, Model model) {

		String process = "new";
		List<Blog> blogNew = blogProcess(process);
		if(blogNew==null) {
			model.addAttribute("errorMessage", "※タイムアウトしました。ログインし直して下さい。");
			return "/login/error";
		}
		session.setAttribute("blogNew", blogNew);
		return "/blog/blog_form";
	}

	@RequestMapping("/blog")
	@SuppressWarnings("unchecked")
	public String blog(@RequestParam int index, String judg, Model model) {
		if((userData = (User) session.getAttribute("userData"))==null) {
			model.addAttribute("errorMessage", "※タイムアウトしました。ログインし直してください。");
			return "/login/error";
		}

		if(judg.equals("new")) {
		List<Blog> blogNew = (List<Blog>)session.getAttribute("blogNew");
		blogData = blogNew.get(index);
		} else if(judg.equals("all")) {
			List<Blog> blogAll = (List<Blog>)session.getAttribute("blogAll");
			blogData = blogAll.get(index);
		} else if(judg.equals("newOther")) {
			List<Blog> blogNewOther = (List<Blog>)session.getAttribute("blogOtherNewList");
			blogData = blogNewOther.get(index);
		} else if(judg.equals("like")) {
			List<Blog> like = (List<Blog>)session.getAttribute("blogLikeList");
			blogData = like.get(index);
		}
		model.addAttribute("blogData", blogData);
		return "/blog/blog";
	}

	@RequestMapping("blogList")
	public String blogList(Model model) {
		if((userData = (User) session.getAttribute("userData"))==null) {
			model.addAttribute("errorMessage", "※タイムアウトしました。ログインし直してください。");
			return "/login/error";
		}
		String process = "all";
		List<Blog> blogAll = blogProcess(process);
		session.setAttribute("blogAll", blogAll);
		return "/blog/blogList";
	}

	@RequestMapping("/form")
	public String form(@Validated @ModelAttribute("blog_form") BlogForm blogForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "/blog/blog_form";
		}

		if((userData = (User) session.getAttribute("userData"))==null) {
			model.addAttribute("errorMessage", "※タイムアウトしました。ログインし直してください。");
			return "/login/error";
		}
		boolean post = blogService.post(blogForm);
		if(post == false) {
			return "/blog/blog_form";
		} else {
			blogData = blogService.blogData(blogForm);
			session.setAttribute("blogData", blogData);
			model.addAttribute("message", "投稿が完了しました！");
			return "/blog/blog";
		}
	}

	@RequestMapping("/blogOther")
	public String blogOther(Model model) {
		if((userData = (User) session.getAttribute("userData"))==null) {
			model.addAttribute("errorMessage", "※タイムアウトしました。ログインし直してください。");
			return "/login/error";
		}
		String process ="otherNew";
		List<Blog> blogOtherNewList = blogProcess(process);
		session.setAttribute("blogOtherNewList", blogOtherNewList);

		process="like";
		List<Blog> blogLikeList = blogProcess(process);
		session.setAttribute("blogLikeList", blogLikeList);
		return "/blog/blogOther";
	}

	@RequestMapping(value="/pushLike", method = RequestMethod.POST)
	@ResponseBody
	public String pushLike(@RequestBody Integer id, Model model) {
		Gson gson = new Gson();
		int like = blogService.countLike(id);
		String stringLike = Integer.toString(like);
		return gson.toJson(stringLike);
	}


	public List<Blog> blogProcess(String process){
		try {
		userData = (User)session.getAttribute("userData");
		Integer user_id = userData.getId();
		List<Blog> blogList = blogService.newBlogData(user_id, process);
		return blogList;
		} catch (Exception e) {
			return null;
		}
	}

}
