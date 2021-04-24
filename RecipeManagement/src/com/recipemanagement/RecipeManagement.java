package com.recipemanagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeManagement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean flag;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for Admin and enter 2 for general");
		int choice = sc.nextInt();
		Operations ops = new Operations();

		sc.nextLine();
		if (choice == 1) {
			while (true) {
				System.out.println("Enter the Password");
				if (sc.nextLine().equals("Kul_21513")) {
					System.out.println("Welcome Admin!");
					flag = true;
					break;
				} else {
					System.out.println("Wrong Password!!");
					continue;
				}
			}

			// Admin
			if (flag == true) {
				while (true) {
					System.out.println("Admin! Enter your choice");
					System.out.println("1. See Recipes ");
					System.out.println("2. Approve new recipes");
					System.out.println("3. Exit");
					int opt = sc.nextInt();
					if (opt == 1) {
						ArrayList<Recipe> list = ops.seeAllRecipe();
						int i = 1;
						for (Recipe r : list) {
							System.out.println("Recipe " + i);
							Recipe.displayRecipe(r);
							i++;
							System.out.println();
							System.out.println();
						}
					}
					if (opt == 2) {
						ArrayList<Recipe> list = ops.getListFromNeedApproval();
						int i = 1;
						if (list.size() == 0) {
							System.out.println("No Recipe available for approval !!");
						}
						for (Recipe r : list) {
							System.out.println("Recipe " + i);
							Recipe.displayRecipe(r);
							i++;
							System.out.println();
							System.out.println();
							System.out.println("Do you want to approve it ?");
							System.out.println("Press 1 for Approve and 2 for Disapprove");
							int chois = sc.nextInt();
							if (chois == 1) {
								ops.addRecipeToRecipeTable(r);
								System.out.println("Recipe Approved and added!");
								ops.deleteRecipeFromNeedApprovalTable(r);
							}
							if (chois == 2) {
								ops.deleteRecipeFromNeedApprovalTable(r);
								System.out.println("Recipe Disapproved!");
							}
						}
					}
					if (opt == 3)
						break;
				}

			}
		} // Admin end

		// General Start
		if (choice == 2) {
			while (true) {
				System.out.println("Hello, what do you want to do : ");
				System.out.println("1. See Recipes ");
				System.out.println("2. Want to Add a recipe");
				System.out.println("3. Exit");
				int choi = sc.nextInt();
				if (choi == 1) {
					ArrayList<Recipe> list = ops.seeAllRecipe();
					int i = 1;
					for (Recipe r : list) {
						System.out.println("Recipe " + i);
						System.out.println("Recipe Name is : " + r.recipeName);
						System.out.println("Submitter name is : " + r.submitterName);
						System.out.println("List of Ingredients are :" + r.ListOfIngredient);
						System.out.println("detailed Discription is : " + r.detailedDiscription);
						System.out.println("Recipe ID is : " + r.recipeId);
						i++;
						System.out.println();
						System.out.println();

					}
				}
				if (choi == 2) {
					System.out.println(
							"Enter the Recipe Name , Submitter Name , List of Ingredient, detailed Discription and Recipe Id ");
					sc.nextLine();
					String temp = sc.nextLine();

					String[] arr = temp.split("-");

					Recipe r = new Recipe(arr[0], arr[1], arr[2], arr[3], Integer.parseInt(arr[4]));
					ops.addRecipeToNeedApprovalTable(r);
					System.out.println("Your Recipe has been sent for Approval to the admin");
					System.out.println();
					System.out.println();
				}
				if (choi == 3)
					break;
			}

		} // General end

		sc.close();

	}

}
