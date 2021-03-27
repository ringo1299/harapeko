package jp.co.example.entity;

public class FoodStuff {

	private String foodstuff;
	private Integer quantity_num;
	private Integer quantity_den;
	private String unit;

	private String quantity;
	private String calc;

	public void setFoodstuff(String foodstuff) {
		this.foodstuff = foodstuff;
	}

	public String getFoodstuff() {
		return foodstuff;
	}

	public void setQuantity_num(Integer quantity_num) {
		this.quantity_num = quantity_num;
	}

	public Integer getQuantity_num() {
		return quantity_num;
	}

	public void setQuantity_den(Integer quantity_den) {
		this.quantity_den = quantity_den;
	}

	public Integer getQuantity_den() {
		return quantity_den;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getUnit() {
		return unit;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setCalc(String calc) {
		this.calc = calc;
	}

	public String getCalc() {
		return calc;
	}
}
