package jp.co.example.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.RecipeDao;
import jp.co.example.entity.FoodStuff;
import jp.co.example.entity.FoodUnit;
import jp.co.example.entity.Process;
import jp.co.example.entity.Recipe;
import jp.co.example.form.RecipeForm;

@Repository
public class RecipeDaoImpl implements RecipeDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	private Recipe recipe;

	public List<RecipeForm> getRecipeGenreList(String genre) {
		String sql = "SELECT recipe_id, menu_name FROM menu WHERE genre_id = (SELECT genre_id FROM genre_list WHERE genre = :genre) ";
		try {
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("genre", genre);

			return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<RecipeForm>(RecipeForm.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Recipe getRecipeOverview(Integer id) {
		String sql = "SELECT * FROM menu_overview WHERE recipe_id = :recipe_id";
		try {
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("recipe_id", id);
			Map<String, Object> map = jdbcTemplate.queryForMap(sql, param);

			recipe.setRecipe_id((Integer) map.get("recipe_id"));
			recipe.setComment((String) map.get("comment"));
			recipe.setTime((String) map.get("time"));

			return recipe;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<FoodStuff> getFoodStuffList(Integer id) {
		String sql = "SELECT foodstuff, quantity_num, unit FROM ingredient_list "
				+ "JOIN foodstuff_list ON ingredient_list.foodstuff_id = foodstuff_list.foodstuff_id "
				+ "JOIN unit_list ON ingredient_list.unit_id = unit_list.unit_id WHERE recipe_id = :recipe_id ORDER BY id ";
		try {
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("recipe_id", id);
			return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<FoodStuff>(FoodStuff.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Process> getProcess(Integer id) {
		String sql = "SELECT process FROM process WHERE recipe_id = :recipe_id ORDER BY id";
		try {
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("recipe_id", id);
			return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Process>(Process.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<String> getQuantity(Integer recipe_id) {
		String sql = "SELECT quantity FROM ingredient_list WHERE recipe_id = :recipe_id ORDER BY id ";
		try {
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("recipe_id", recipe_id);
			return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<String>(String.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Recipe> searchTitleList(String word) {
		String sql = "SELECT * FROM menu WHERE menu_name = :menu_name ";
		try {
			MapSqlParameterSource param = new MapSqlParameterSource();
			param.addValue("menu_name", word);
			return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Recipe>(Recipe.class));
		} catch (Exception e) {
			return null;
		}
	}

	public List<Recipe> searchFoodstuffList(String word) {
		String sql1 = "SELECT foodstuff_id FROM foodstuff_list WHERE foodstuff = :foodstuff ";

		String sql2 = "SELECT menu.recipe_id, menu_name FROM ingredient_list "
				+ "JOIN menu ON menu.recipe_id = ingredient_list.recipe_id WHERE foodstuff_id = :foodstuff_id ";
		try {
			MapSqlParameterSource param1 = new MapSqlParameterSource();
			param1.addValue("foodstuff", word);
			Integer foodstuff_id = jdbcTemplate.queryForObject(sql1, param1, Integer.class);

			MapSqlParameterSource param2 = new MapSqlParameterSource();
			//param2.addValue("menu_name", word);
			param2.addValue("foodstuff_id", foodstuff_id);
			return jdbcTemplate.query(sql2, param2, new BeanPropertyRowMapper<Recipe>(Recipe.class));

		} catch (Exception e) {
			return null;
		}
	}

	/*public void test(Integer recipe_id) {
		String sql = "SELECT quantity FROM menu_foodstuff_list WHERE recipeId = :recipeId LIMIT 1 ";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("recipeId", recipe_id);
		String test = jdbcTemplate.queryForObject(sql, param, String.class);
		System.out.println(test);
	}*/

	public List<FoodUnit> getUnitList() {
		String sql = "SELECT * FROM unit_list ";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<FoodUnit>(FoodUnit.class));
	}

}
