package jp.co.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.example.entity.FoodStuff;
import jp.co.example.entity.FoodUnit;
import jp.co.example.entity.Process;
import jp.co.example.entity.Recipe;
import jp.co.example.form.RecipeForm;
import jp.co.example.service.RecipeService;

@Controller
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	//レシピのリスト一覧を表示
	@RequestMapping("/recipeList")
	public String recipeList(Model model) {
		List<RecipeForm> recipeList1 = recipeService.getRecipeGenreList("肉料理");
		List<RecipeForm> recipeList2 = recipeService.getRecipeGenreList("野菜料理");
		List<RecipeForm> recipeList3 = recipeService.getRecipeGenreList("魚料理");
		model.addAttribute("recipeList1", recipeList1);
		model.addAttribute("recipeList2", recipeList2);
		model.addAttribute("recipeList3", recipeList3);
		return "/recipe/recipeList";
	}

	//レシピページの表示
	@RequestMapping("/recipe")
	public String recipe(@RequestParam("recipe_id") Integer recipe_id, @RequestParam("menu") String menu, Model model) {
		//レシピの説明、所要時間を取得
		Recipe recipeOverview = recipeService.getRecipeOverview(recipe_id);
		recipeOverview.setMenu_name(menu);
		model.addAttribute("overview", recipeOverview);

		//レシピの材料を取得
		List<FoodStuff> foodstuffList = recipeService.getFoodStuff(recipe_id);
		model.addAttribute("foodstuffList", foodstuffList);

		//レシピの「作り方」を取得
		List<Process> process = recipeService.getProcess(recipe_id);
		model.addAttribute("process", process);
		return "/recipe/recipe";
	}

	//材料の分量を人数分計算する
	@RequestMapping(value="/calc")
	public String calc(@RequestParam("recipe_id") Integer recipe_id, @RequestParam("menu") String menu,
			@RequestParam("numberOfPeople") Integer num, Model model) {
		List<FoodStuff> foodstuffList = recipeService.getFoodStuff(recipe_id);
		List<FoodStuff> foodstuffCalcList = recipeService.calcFoodstuff(foodstuffList, num);
		model.addAttribute("foodstuffList", foodstuffCalcList);

		Recipe recipeOverview = recipeService.getRecipeOverview(recipe_id);
		recipeOverview.setMenu_name(menu);
		model.addAttribute("overview", recipeOverview);

		List<Process> process = recipeService.getProcess(recipe_id);
		model.addAttribute("process", process);

		model.addAttribute("num", num);
		return "/recipe/recipe";
	}

	@RequestMapping("/recipeForm")
	public String recipeForm(Model model) {
		List<FoodUnit> unitList = recipeService.getUnitList();
		model.addAttribute("unitList", unitList);
		return "/recipe/recipeForm";
	}

	@RequestMapping("/search")
	public String recipe_search(@RequestParam("way") String search, @RequestParam("keyword") String word, Model model) {
		List<Recipe> recipeList = recipeService.searchRecipe(search, word);
		if(recipeList == null || recipeList.size() == 0 ) {
			model.addAttribute("word", word);
			model.addAttribute("nullMessage", "に一致する検索結果がありません。");
			return "/recipe/searchResult";
		} else {
			model.addAttribute("word", word);
			model.addAttribute("message", "に一致する検索結果");
			model.addAttribute("recipeResult", recipeList);
			return "/recipe/searchResult";
		}
	}
}
