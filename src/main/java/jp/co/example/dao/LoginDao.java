package jp.co.example.dao;

import jp.co.example.entity.User;
import jp.co.example.form.UserForm;

public interface LoginDao {

	/**
	 * ユーザーIDが重複していないかチェックします。
	 * @param userForm
	 * @return 重複していなかったらtrue,していたらfalse
	 */
	public String check(UserForm userForm);

	/**
	 * 新規ユーザー情報をDBにインサートします。
	 * @param userForm
	 */
	public void insert(UserForm userForm);

	/**
	 * ログイン処理をします。
	 * @param userForm
	 * @return User情報
	 */
	public User login(UserForm userForm);

	/**
	 * ユーザーがLikeされた数を合計します。
	 * @param user_id
	 * @return 総Like数
	 */
	public Integer likeCount(Integer user_id);

	/**
	 * ユーザーのブログ投稿数を取得します。
	 * @param user_id
	 * @return ブログ投稿数
	 */
	public Integer blogCount(Integer user_id);

	/**
	 * ユーザー情報を更新します。
	 * @param userForm
	 * @param id
	 */
	public void updateUserData(UserForm userForm, Integer id);

	/**
	 * 変更するユーザーIDが他のユーザーと重複していないかチェックします。
	 * @param userForm
	 * @param id
	 * @return
	 */
	public String checkUpdate(UserForm userForm, Integer id);


}
