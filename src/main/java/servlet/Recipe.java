package servlet;

public class Recipe {
	private String recipeName;
	 private String recipeDesc;
	 private String imgUrl;
	 public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getRecipeDesc() {
		return recipeDesc;
	}
	public void setRecipeDesc(String recipeDesc) {
		this.recipeDesc = recipeDesc;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
