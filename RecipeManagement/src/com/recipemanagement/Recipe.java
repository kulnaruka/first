package com.recipemanagement;

public class Recipe {
	int recipeId;
	String recipeName;
	String submitterName;
	String ListOfIngredient;
	String detailedDiscription;
	public Recipe(String recipeName, String submitterName, String listOfIngredient,
			String detailedDiscription,int recipeId) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.submitterName = submitterName;
		ListOfIngredient = listOfIngredient;
		this.detailedDiscription = detailedDiscription;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	public String getListOfIngredient() {
		return ListOfIngredient;
	}
	public void setListOfIngredient(String listOfIngredient) {
		ListOfIngredient = listOfIngredient;
	}
	public String getDetailedDiscription() {
		return detailedDiscription;
	}
	public void setDetailedDiscription(String detailedDiscription) {
		this.detailedDiscription = detailedDiscription;
	}
	public static void displayRecipe(Recipe r) {
		System.out.println("Recipe Name is : " + r.getRecipeName());
		System.out.println("Submitter name is : " + r.getSubmitterName());
		System.out.println("List of Ingredients are :" + r.getListOfIngredient());
		System.out.println("detailed Discription is : "+ r.getDetailedDiscription());
		System.out.println("Recipe ID is : " + r.getRecipeId());
	}
	
	
}
