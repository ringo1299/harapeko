package jp.co.example.dao.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.example.dao.LoginDao;
import jp.co.example.entity.User;
import jp.co.example.form.UserForm;

@Repository
public class LoginDaoImpl implements LoginDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	/**
	 * 入力されたユーザーIDが既に登録されているかチェックします。
	 * 未登録の場合はtrue、登録されている場合はfalseを返します。
	 */
	public String check(UserForm userForm) {
		try {
		String sql = "SELECT user_id FROM users WHERE user_id = :user_id ";

        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("user_id", userForm.getUser_id());

        return jdbcTemplate.queryForObject(sql, param, String.class);

       } catch(IncorrectResultSizeDataAccessException  e) {

    	   return null;
       }
	}

	/**
	 * ユーザー情報をuserテーブルにインサートします。
	 */
	@Transactional
	public void insert(UserForm userForm) {
		String sql = "INSERT INTO users VALUES"
				+ " ((SELECT MAX(id) + 1 FROM users),"
				+ " :user_id, :pass, :nickname, :message)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", userForm.getUser_id());
		param.addValue("pass", userForm.getPass());
		param.addValue("nickname", userForm.getNickname());
		param.addValue("message", userForm.getMessage());

		jdbcTemplate.update(sql, param);

	}

	@Transactional
	public User login(UserForm userForm) {
		String sql = "SELECT id, user_id, pass, nickname, message FROM users "
				+ "WHERE user_id = :user_id AND pass = :pass";

		User userData = new User();

		try {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("user_id", userForm.getUser_id());
		param.addValue("pass", userForm.getPass());

		Map<String, Object> map = jdbcTemplate.queryForMap(sql, param);

		userData.setId((Integer) map.get("id"));
		userData.setUser_id((String) map.get("user_id"));
		userData.setPass((String) map.get("pass"));
		userData.setNickname((String) map.get("nickname"));
		userData.setMessage((String) map.get("message"));

		} catch(EmptyResultDataAccessException  e) {
			return userData = null;
		}
		return userData;
	}

	public Integer likeCount(Integer user_id) {
		String sql ="SELECT SUM(like_button) FROM blog_list WHERE blog_user_id = :blog_user_id ";
		 try {
			 MapSqlParameterSource param = new MapSqlParameterSource();
			 param.addValue("blog_user_id", user_id);

			 return jdbcTemplate.queryForObject(sql, param, Integer.class);
		 } catch (EmptyResultDataAccessException e) {
			 return null;
		 }
	}

	public Integer blogCount(Integer user_id) {
		String sql = "SELECT COUNT(*) FROM blog_list WHERE blog_user_id = :blog_user_id ";
		try {
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("blog_user_id", user_id);

			return jdbcTemplate.queryForObject(sql, param, Integer.class);
		} catch ( EmptyResultDataAccessException e) {
			return null;
		}
	}

	public void updateUserData(UserForm userForm, Integer id) {
		String sql = "UPDATE users SET user_id = :user_id, pass = :pass, nickname = :nickname, message = :message WHERE id = :id";

			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("user_id", userForm.getUser_id());
			param.addValue("pass", userForm.getPass());
			param.addValue("nickname", userForm.getNickname());
			param.addValue("message", userForm.getMessage());
			param.addValue("id", id);

			jdbcTemplate.update(sql, param);
	}

	public String checkUpdate(UserForm userForm, Integer id) {
			String sql = "SELECT user_id FROM users WHERE user_id = :user_id AND id != :id ";
			try {
	        MapSqlParameterSource param = new MapSqlParameterSource();
	        param.addValue("user_id", userForm.getUser_id());
	        param.addValue("id", id);

	        return jdbcTemplate.queryForObject(sql, param, String.class);
			} catch(EmptyResultDataAccessException  e) {
				return null;
			}
	}
}
