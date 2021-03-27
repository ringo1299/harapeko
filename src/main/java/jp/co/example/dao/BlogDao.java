package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.Blog;
//import jp.co.example.entity.BlogNew;
import jp.co.example.form.BlogForm;

public interface BlogDao {

	/**
	 * DBにブログ内容をインサートします。
	 * @param blogForm
	 * @return
	 */
	public boolean post(BlogForm blogForm);

	/**
	 * DBからブログ内容を取得します。
	 * @param blogForm
	 * @return
	 */
	public Blog getBlogData(BlogForm blogForm);

	/**
	 * DBに登録されたブログを新しい順で5件取得します。
	 * @param blogForm
	 * @return
	 */
	public List<Blog> getNewBlogData(Integer user_id);

	/**
	 * DBに登録されたブログを新しい順で全て取得します。
	 * @param user_id
	 * @return
	 */
	public List<Blog> getAllNewBlogData(Integer user_id);


	/**
	 * DBに登録されたブログをユーザー関係なく新しい順で5件取得します。
	 * @return
	 */
	public List<Blog> getNewBlogOtherData();

	/**
	 * ＤＢに登録されたブログの中から人気のある順で5件取得します。
	 * @return
	 */
	public List<Blog> getLikeBlogData();

	/**
	 * ユーザーIDからニックネームを取得します。
	 * @param user_id
	 * @return
	 */
	public String getNickname(Integer user_id);


	/**
	 * ブログのLike数を取得します。
	 * @param id
	 * @return
	 */
	public Integer getLike(Integer id);

	/**
	 * Likeを更新します。
	 * @param like
	 */
	public void setLike(Integer like, Integer id);
}
