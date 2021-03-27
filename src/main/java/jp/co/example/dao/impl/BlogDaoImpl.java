package jp.co.example.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.BlogDao;
import jp.co.example.entity.Blog;
import jp.co.example.form.BlogForm;

@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private Blog blogData;

	@Override
	public boolean post(BlogForm blogForm) {
		try {
			String sql = "INSERT INTO blog_list VALUES"
					+ " ((SELECT MAX(id) + 1 FROM blog_list),"
					+ " :post_day, :title, :body, :like_button, :blog_user_id)";

			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("post_day", blogForm.getDate());
			param.addValue("title", blogForm.getTitle());
			param.addValue("body", blogForm.getBody());
			param.addValue("like_button", blogForm.getLike());
			param.addValue("blog_user_id", blogForm.getBlog_user_id());

			jdbcTemplate.update(sql, param);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Blog getBlogData(BlogForm blogForm) {
		String sql = "SELECT post_day, title, body, like_button, blog_user_id FROM blog_list "
				+ "WHERE blog_user_id = :blog_user_id AND post_day = :post_day";

		try {
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("blog_user_id", blogForm.getBlog_user_id());
			param.addValue("post_day", blogForm.getDate());

			Map<String, Object> map = jdbcTemplate.queryForMap(sql, param);

			blogData.setPost_day((Timestamp) map.get("post_day"));
			blogData.setTitle((String) map.get("title"));
			blogData.setBody((String) map.get("body"));
			blogData.setLike_button((Integer) map.get("like_button"));
			blogData.setId((Integer) map.get("user_id"));
			return blogData;

		} catch (EmptyResultDataAccessException e) {
			return blogData = null;
		}
	}

	@Override
	public List<Blog> getNewBlogData(Integer user_id) {
		String sql = "SELECT * FROM blog_list WHERE user_id = :user_id ORDER BY post_day DESC LIMIT 5 ";

		try {
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("user_id", user_id);
			return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Blog>(Blog.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Blog> getAllNewBlogData(Integer user_id) {
		String sql = "SELECT * FROM blog_list WHERE blog_user_id = :blog_user_id ORDER BY post_day DESC ";

		try {
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("blog_user_id", user_id);
			return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Blog>(Blog.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Blog> getNewBlogOtherData(){
		String sql = "SELECT * FROM blog_list ORDER BY post_day DESC LIMIT 5 ";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Blog>(Blog.class));
	}

	@Override
	public List<Blog> getLikeBlogData(){
		String sql = "SELECT * FROM blog_list WHERE like_button IS NOT NULL ORDER BY like_button DESC LIMIT 5 ";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Blog>(Blog.class));
	}

	@Override
	public String getNickname(Integer user_id) {
		String sql ="SELECT nickname FROM users WHERE id = :id ";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", user_id);
		return jdbcTemplate.queryForObject(sql, param, String.class);
	}

	@Override
	public Integer getLike(Integer id) {
		String sql ="SELECT like_button FROM blog_list WHERE id = :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("id", id);
		return jdbcTemplate.queryForObject(sql, param, Integer.class);
	}

	@Override
	public void setLike(Integer like, Integer id) {
		String sql = "UPDATE blog_list SET like_button = :like_button WHERE id = :id";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("like_button", like);
		param.addValue("id", id);
		jdbcTemplate.update(sql, param);
	}
}
