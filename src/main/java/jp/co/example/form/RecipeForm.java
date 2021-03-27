package jp.co.example.form;

public class RecipeForm {

	private Integer recipe_id;
	private String menu_name;

	public void setRecipe_id(Integer recipe_id) {
		this.recipe_id = recipe_id;
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
}
