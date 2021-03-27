package jp.co.example.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.dao.LoginDao;
import jp.co.example.entity.User;
import jp.co.example.exception.LoginException;
import jp.co.example.form.UserForm;
import jp.co.example.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	@Autowired
	HttpSession session;

	/**
	 * Daoのcheckメソッドからの戻り値に値が入っていたらfalse(ID重複)、
	 * nullならtrue(重複なし)を返す。
	 */
	public Boolean duplicateCheck(UserForm userForm, String judg) {
		String check = "";
		try {
		if(judg.equals("insert")) {
			check = loginDao.check(userForm);
		} else if(judg.equals("update")){
			User userData = (User)session.getAttribute("userData");
			Integer id = userData.getId();
			check = loginDao.checkUpdate(userForm, id);
		}
		if(check == null) {
	        	return true;
	        } else {
	        	return false;
	        }
		} catch(Exception e) {
			return null;
		}
	}

	public void insert(UserForm userForm) {
		loginDao.insert(userForm);
	}

	public Boolean login(UserForm userForm) {
		User userData = loginDao.login(userForm);
		if(userData == null) {
			return false;
		}
		return true;
	}

	public User userData(UserForm userForm) {
		User data = loginDao.login(userForm);
		if(data == null) {
			return data = null;
		}

		return data;
	}
	public Integer likeCount(Integer id) {
		Integer like = loginDao.likeCount(id);
		if(like == null) {
			return like = 0;
		}
		return like;
	}

	public Integer blogCount(Integer id) {
		Integer blog = loginDao.blogCount(id);
		if(blog == null) {
			return blog = 0;
		}
		return blog;
	}

	public User updateUserData(UserForm userForm) {
		try {
		User userData = (User)session.getAttribute("userData");
		Integer id = userData.getId();
		loginDao.updateUserData(userForm, id);
		User newUserData = new User();
		newUserData.setId(id);
		newUserData.setUser_id(userForm.getUser_id());
		newUserData.setPass(userForm.getPass());
		newUserData.setNickname(userForm.getNickname());
		newUserData.setMessage(userForm.getMessage());
		return newUserData;
		} catch(Exception e) {
			return null;
		}

	}

	public static void loginServiceException() throws LoginException {
		throw new LoginException();
	}
}
