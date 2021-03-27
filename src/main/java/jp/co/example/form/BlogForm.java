package jp.co.example.form;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class BlogForm {

		private Timestamp date;

		@NotBlank
		private String title;

		private String body;

		private Integer like_button;

		private Integer blog_user_id;

		public void setDate(Timestamp date) {
			this.date = date;
		}

		public Timestamp getDate() {
			return date;
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

		public Integer getLike() {
			return like_button;
		}

		public void setBlog_user_id(Integer user_id) {
			this.blog_user_id = user_id;
		}

		public Integer getBlog_user_id() {
			return blog_user_id;
		}
	}

