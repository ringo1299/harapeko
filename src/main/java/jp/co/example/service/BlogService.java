package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.Blog;
import jp.co.example.form.BlogForm;

public interface BlogService {

	/**
	 * ブログを投稿します。
	 * @param blogForm
	 * @return
	 */
	public Boolean post(BlogForm blogForm);

	/**
	 * 投稿されたブログ内容を取得します。
	 * @param blogForm
	 * @return
	 */
	public Blog blogData(BlogForm blogForm);

	/**
	 * ブログの投稿リストを条件に合わせて取得します。
	 * @return
	 */
	public List<Blog> newBlogData(Integer user_id, String process);

	/**
	 * Likeを1増やしDBを更新します。
	 * @param id
	 * @return
	 */
	public Integer countLike(Integer id);

}
