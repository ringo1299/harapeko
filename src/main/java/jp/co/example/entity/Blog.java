package jp.co.example.entity;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class Blog {

	private Timestamp post_day;
	private String dateString;

	@NotBlank
	private String title;

	@NotBlank
	private String body;

	private Integer like_button;

	private String nickname;

	//ブログのid
	private Integer id;

	//ユーザーのid
	private Integer blog_user_id;

	public void setPost_day(Timestamp date) {
		this.post_day = date;
	}

	public Timestamp getPost_day() {
		return post_day;
	}

	public void setDateString(String date) {
		this.dateString = date;
	}

	public String getDateString() {
		return dateString;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getBody() {
		return body;
	}

	public void setLike_button(Integer like) {
		this.like_button = like;
	}

	public Integer getLikeButton() {
		return like_button;
	}

	public void setNickname(String nickname) {
		this.nickname= nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setBlog_user_id(Integer user_id) {
		this.blog_user_id = user_id;
	}

	public Integer getBlog_user_id() {
		return blog_user_id;
	}
}
