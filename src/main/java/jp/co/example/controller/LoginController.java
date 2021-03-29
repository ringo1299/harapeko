package jp.co.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.example.entity.User;
import jp.co.example.exception.LoginException;
import jp.co.example.form.UserForm;
import jp.co.example.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@Autowired
	HttpSession session;

	@Autowired
	private User userData;

	//ログイン画面表示
	@RequestMapping("/")
	public String iframeLogin(@ModelAttribute("login") User user, Model model) {
		model.addAttribute("loginMessage", "ログインしてください。未登録の場合は「新規登録」をclick！");
		return "/login/login";
	}

	//新規登録画面への遷移
	@RequestMapping("/new_user")
	public String new_user(@ModelAttribute("insert") UserForm userForm, Model model) {
		return "/login/new_user";
	}

	//トップ画面への遷移
	@RequestMapping("/top")
	public String top(Model model) {
		if((userData = (User) session.getAttribute("userData"))==null) {
			model.addAttribute("errorMessage", "※タイムアウトしました。ログインし直してください。");
			return "/login/error";
		}
		return "/login/top";
	}

	@RequestMapping("/new_user_success")
	public String new_user_success() {
		return "/login/new_user_success";
	}

	//ログインの処理をしてトップ画面に遷移
	@RequestMapping("/judgLogin")
	public String login(@ModelAttribute("login") UserForm userForm, Model model) {

		Boolean login = loginService.login(userForm);

		if (login == false) {
			try {
				sqlException();
			} catch (LoginException le) {
				model.addAttribute("loginMessage", "ログインに失敗しました。もう一度やり直してください。");
				return "/login/login";
			}
		} else {
			userData = loginService.userData(userForm);
			session.setAttribute("userData", userData);
			model.addAttribute("user", userData);
			return "redirect:/top";
		}
		return "/login/login";
	}

	//新規登録
	@RequestMapping("/new_insert")
	public String new_insert(@Validated @ModelAttribute("insert") UserForm userForm, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "/login/new_user";
		}

		String judg = "insert";
		if (loginService.duplicateCheck(userForm, judg)) {
			loginService.insert(userForm);
			//登録完了したらログイン画面に戻す
			model.addAttribute("loginMessage", "新規登録が完了しました！ログインしてください。");
			return "/login/new_user_success";
		} else {
			//IDが重複していたら例外をスローする
			try {
				sqlException();
			} catch (LoginException le) {
				String exception = "※このユーザーIDは既に使用されています。";
				model.addAttribute("exception", exception);
				return "/login/new_user";
			}
			return "/login/new_user";
		}
	}

	@RequestMapping("/mypage")
	public String mypage(Model model) {
		if((userData = (User) session.getAttribute("userData"))==null) {
			model.addAttribute("errorMessage", "※タイムアウトしました。ログインし直してください。");
			return "/login/error";
		}
		userData = (User) session.getAttribute("userData");
		Integer like = loginService.likeCount(userData.getId());
		Integer blog = loginService.blogCount(userData.getId());
		model.addAttribute("like", like);
		model.addAttribute("blog", blog);
		model.addAttribute("user", userData);
		return "/login/mypage";
	}

	@RequestMapping("/logout")
	public String logout(@ModelAttribute("login") User user, Model model) {
		session.invalidate();
		model.addAttribute("errorMessage", "ログアウトしました。");
		return "/login/error";
	}

	@RequestMapping("/user_edit")
	public String user_edit(@ModelAttribute("edit") UserForm userForm, Model model) {
		if((userData = (User) session.getAttribute("userData"))==null) {
			model.addAttribute("errorMessage", "※タイムアウトしました。ログインし直してください。");
			return "/login/error";
		}
		return "/login/user_edit";
	}

	@RequestMapping("/edit")
	public String edit(@Validated @ModelAttribute("edit") UserForm userForm, BindingResult bindingResult, Model model) {
		if((userData = (User) session.getAttribute("userData"))==null) {
			model.addAttribute("errorMessage", "※タイムアウトしました。ログインし直してください。");
			return "/login/error";
		}

		if (bindingResult.hasErrors()) {
			return "/login/user_edit";
		}

		String judg = "update";
		if (loginService.duplicateCheck(userForm, judg)) {
			User newUserData = loginService.updateUserData(userForm);
			if(newUserData != null) {
				session.setAttribute("userData", newUserData);
				return "/login/update_success";
			} else {
				model.addAttribute("errorMessage", "※タイムアウトしました。ログインし直して下さい。");
				return "/login/error";
			}
		} else {
			//IDが重複していたら例外をスローする
			try {
				sqlException();
			} catch (LoginException le) {
				String exception = "※このユーザーIDは既に使用されています。";
				model.addAttribute("exception", exception);
				return "/login/user_edit";
			}
		}
		return "/login/user_edit";
	}

	//例外スロー
	public static void sqlException() throws LoginException {
		throw new LoginException();
	}



	//ログイン画面表示②　新規登録完了後
	/*@RequestMapping("/insertSuccess")
	public String iframeInsertSuccess(@ModelAttribute("login") User user, Model model) {
		model.addAttribute("loginMessage", "新規登録が完了しました！ログインしてください。");
		return "login";
	}

	//ログイン画面表示③　ログイン処理失敗
	@RequestMapping("/loginFail")
	public String iframeLoginFail(@ModelAttribute("login") User user, Model model) {
		model.addAttribute("loginMessage", "ログインに失敗しました。もう一度やり直してください。");
		return "login";
	}*/
	//ログイン成功後のトップ画面遷移
	/*@RequestMapping("/loginSuccess")
	public String afterLogin(@ModelAttribute("userSession") User user, Model model) {
		model.addAttribute("user", user);
		return "/login/top";
	}*/



}
