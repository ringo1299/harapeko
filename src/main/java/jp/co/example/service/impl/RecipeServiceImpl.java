package jp.co.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.RecipeDao;
import jp.co.example.entity.FoodStuff;
import jp.co.example.entity.FoodUnit;
import jp.co.example.entity.Process;
import jp.co.example.entity.Recipe;
import jp.co.example.form.RecipeForm;
import jp.co.example.service.RecipeService;

@Repository
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDao recipeDao;

	public List<RecipeForm> getRecipeGenreList(String genre){
		return recipeDao.getRecipeGenreList(genre);
	}

	public Recipe getRecipeOverview(Integer id) {
		return recipeDao.getRecipeOverview(id);
	}

	public List<FoodStuff> getFoodStuff(Integer id){
		List<FoodStuff> foodstuffList = recipeDao.getFoodStuffList(id);
		for(int i = 0; i < foodstuffList.size(); i++) {
			String unit = foodstuffList.get(i).getUnit();
			if(unit.equals("大さじ") || unit.equals("小さじ")) {
				String quantity = Integer.toString(foodstuffList.get(i).getQuantity_num());
				foodstuffList.get(i).setQuantity(unit + quantity);
			} else if(unit.equals("少々") ||
						unit.equals("適量") ||
						unit.equals("お好みで")){
					foodstuffList.get(i).setQuantity(unit);
			} else {
				String quantity = Integer.toString(foodstuffList.get(i).getQuantity_num());
				foodstuffList.get(i).setQuantity(quantity + unit);
			}
		}
		return foodstuffList;
	}

	public List<Process> getProcess(Integer id){
		return recipeDao.getProcess(id);
	}

	public List<FoodStuff> calcFoodstuff(List<FoodStuff> foodstuffList, Integer num){
		for(int i = 0; i < foodstuffList.size(); i++) {
			String unit = foodstuffList.get(i).getUnit();
			if(unit.equals("大さじ") || unit.equals("小さじ")) {
				Integer quantity = foodstuffList.get(i).getQuantity_num();
				String calcStr = unit + Integer.toString(quantity * num);
				foodstuffList.get(i).setCalc(calcStr);
			} else if(unit.equals("少々") ||
						unit.equals("適量") ||
						unit.equals("お好みで")){
				foodstuffList.get(i).setCalc(unit);
			} else {
				Integer quantity = foodstuffList.get(i).getQuantity_num();
				String calcStr = Integer.toString(quantity * num) + unit;
				foodstuffList.get(i).setCalc(calcStr);
			}
		}
		return foodstuffList;
	}

	public List<Recipe> searchRecipe(String search, String word){
		if(search.equals("title")) {
			return recipeDao.searchTitleList(word);
		} else if(search.equals("foodstuff")) {
			return recipeDao.searchFoodstuffList(word);
		}
		return null;
	}

	public List<FoodUnit> getUnitList(){
		return recipeDao.getUnitList();
	}
}
