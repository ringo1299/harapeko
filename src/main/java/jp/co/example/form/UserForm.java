package jp.co.example.form;

import javax.validation.constraints.NotBlank;

public class UserForm {


	@NotBlank
	private String user_id;

	@NotBlank
	private String pass;

	private String nickname;
	private String message;
	private Integer likeButton;

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setLikeButton(Integer like) {
		this.likeButton = like;
	}

	public Integer getLikeButton() {
		return likeButton;
	}
}
