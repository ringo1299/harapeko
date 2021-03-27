package jp.co.example.service;

import jp.co.example.entity.User;
import jp.co.example.form.UserForm;

public interface LoginService {

	/**
	 * 重複チェック
	 * @param user
	 * @return 重複していたらfalse、重複していなかったらtrueを返す。
	 */
	public Boolean duplicateCheck(UserForm userForm, String judg);


	/**
	 * DBにインサートする
	 * @param user
	 */
	public void insert(UserForm userForm);


	/**
	 * ユーザーIDとパスワードが一致するか判断する
	 * @param userForm
	 * @return
	 */
	public Boolean login(UserForm userForm);

	/**
	 * ユーザー情報をとってくる
	 * @param user
	 * @return
	 */
	public User userData(UserForm userForm);

	/**
	 * Like数を取得します
	 * @param user_id
	 * @return
	 */
	public Integer likeCount(Integer user_id);

	/**
	 * ブログ投稿数を取得します。
	 * @param user_id
	 * @return
	 */
	public Integer blogCount(Integer user_id);

	/**
	 * ユーザー情報をupdateします。
	 * @param userForm
	 * @return
	 */
	public User updateUserData(UserForm userForm);

}
