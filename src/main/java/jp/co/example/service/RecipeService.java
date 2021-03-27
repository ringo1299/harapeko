package jp.co.example.service;

import java.util.List;

import jp.co.example.entity.FoodStuff;
import jp.co.example.entity.FoodUnit;
import jp.co.example.entity.Process;
import jp.co.example.entity.Recipe;
import jp.co.example.form.RecipeForm;

public interface RecipeService {

	/**
	 * レシピをジャンルごとに取得します。
	 * @param genre
	 * @return
	 */
	public List<RecipeForm> getRecipeGenreList(String genre);

	/**
	 * レシピの概要を取得します。
	 * @param id
	 * @return
	 */
	public Recipe getRecipeOverview(Integer id);

	/**
	 * レシピの材料と分量を取得します。
	 * @param id
	 * @return
	 */
	public List<FoodStuff> getFoodStuff(Integer id);

	/**
	 * レシピの作り方を取得します。
	 * @param id
	 * @return
	 */
	public List<Process> getProcess(Integer id);

	/**
	 * 人数分の分量を計算します。
	 * @param num
	 * @return
	 */
	public List<FoodStuff> calcFoodstuff(List<FoodStuff> foodstuff, Integer num);

	public List<FoodUnit> getUnitList();

	public List<Recipe> searchRecipe(String search, String word);

}
