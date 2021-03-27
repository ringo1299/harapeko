package jp.co.example.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Recipe {

	private Integer recipe_id;
	private String menu_name;
	private String comment;
	private String time;

	public void setRecipe_id(Integer recipeId) {
		this.recipe_id = recipeId;
	}

	public Integer getRecipe_id() {
		return recipe_id;
	}

	public void setMenu_name(String menuTitle) {
		this.menu_name = menuTitle;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}
}
