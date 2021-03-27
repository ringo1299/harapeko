package jp.co.example.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.BlogDao;
import jp.co.example.entity.Blog;
import jp.co.example.entity.User;
import jp.co.example.form.BlogForm;
import jp.co.example.service.BlogService;

@Repository
public class BlogServiceImpl implements BlogService {

	@Autowired
	private Blog blogData;

	@Autowired
	private BlogDao blogDao;

	@Autowired
	HttpSession session;

	@Autowired
	User userData;

	@Autowired
	List<Blog> blogList;

	@Override
	public Boolean post(BlogForm blogForm) {
		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
		userData = (User) session.getAttribute("userData");
		blogForm.setDate(timeStamp);
		blogForm.setBlog_user_id(userData.getId());
		blogForm.setLike_button(0);
		boolean post = blogDao.post(blogForm);
		return post;
	}

	@Override
	public Blog blogData(BlogForm blogForm) {
		blogData = blogDao.getBlogData(blogForm);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
		String date = sdf.format(blogData.getPost_day());
		blogData.setDateString(date);
		return blogData;
	}

	@Override
	public List<Blog> newBlogData(Integer user_id, String process) {
		try {
			if(process.equals("new")) {
			blogList = blogDao.getNewBlogData(user_id);
			} else if(process.equals("all")) {
				blogList = blogDao.getAllNewBlogData(user_id);
			} else if(process.equals("otherNew")) {
				blogList = blogDao.getNewBlogOtherData();
			} else if(process.equals("like")) {
				blogList = blogDao.getLikeBlogData();
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
			for (int i = 0; i < blogList.size(); i++) {
				blogData = blogList.get(i);
				String date = sdf.format(blogData.getPost_day());
				blogData.setDateString(date);
				if(process.equals("otherNew") ||
					process.equals("like")){
						String nickname = blogDao.getNickname(blogData.getBlog_user_id());
						blogData.setNickname(nickname);
					}
				blogList.set(i, blogData);
			}
		} catch (Exception e) {

		}
		return blogList;
	}

	public Blog setDate(int i, SimpleDateFormat sdf) {
		blogData = blogList.get(i);
		String date = sdf.format(blogData.getPost_day());
		blogData.setDateString(date);
		blogList.set(i, blogData);
		return blogData;
	}

	public Integer countLike(Integer id) {
		Integer like = blogDao.getLike(id);
		like++;
		blogDao.setLike(like, id);
		return like;
	}

}
