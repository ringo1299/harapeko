package jp.co.example.dao;

import java.util.List;

import jp.co.example.entity.FoodStuff;
import jp.co.example.entity.FoodUnit;
import jp.co.example.entity.Process;
import jp.co.example.entity.Recipe;
import jp.co.example.form.RecipeForm;

public interface RecipeDao {

	/**
	 * レシピをジャンルで検索し、idと料理名を取得します。
	 * @param genre
	 * @return id、料理名
	 */
	public List<RecipeForm> getRecipeGenreList(String genre);

	/**
	 * レシピをidで検索し、料理の説明と所要時間を取得します。
	 * @param id
	 * @return 料理の説明、所要時間
	 */
	public Recipe getRecipeOverview(Integer recipe_id);

	/**
	 * idを元にレシピの材料と数量を取得します。
	 * @param id
	 * @return
	 */
	public List<FoodStuff> getFoodStuffList(Integer recipe_id);

	/**
	 * idを元に作り方の手順を取得します。
	 * @param id
	 * @return
	 */
	public List<Process> getProcess(Integer recipe_id);

	/**
	 *レシピの分量を取得します。
	 * @param id
	 * @return
	 */
	public List<String> getQuantity(Integer recipe_id);

	/**
	 * 食材の単位を取得します。
	 * @return
	 */
	public List<FoodUnit> getUnitList();

	/**
	 * 入力されたワードと一致するメニューを表示します。
	 * @param word
	 * @return
	 */
	public List<Recipe> searchTitleList(String word);

	/**
	 * 入力されたワードと一致する食材を持つメニューを表示します。
	 * @param word
	 * @return
	 */
	public List<Recipe> searchFoodstuffList(String word);
}
