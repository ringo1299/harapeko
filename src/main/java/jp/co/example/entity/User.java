package jp.co.example.entity;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class User {

	@NotBlank
	private String user_id;

	@NotBlank
	private String pass;

	@NotBlank
	private String nickname;

	private String message;
	private Integer id;


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

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
	return id;
	}


}
