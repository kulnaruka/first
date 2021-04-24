package com.recipemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Operations {
		
	
	
	ResultSet setConnectionToGetDetails(String query) throws SQLException, ClassNotFoundException {
		Connection con = getConnectionRecipeManagement();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		return rs;
	}

	private Connection getConnectionRecipeManagement()
			throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/sys";
		String uname = "root";
		String pass = "Kul_21513";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		return con;
	}
	
	void addRecipeToRecipeTable(Recipe r) throws ClassNotFoundException, SQLException {
		Connection con = getConnectionRecipeManagement();
		Statement st = con.createStatement();
		String query = "insert into recipe values(" +"'"+ r.getRecipeName() +"'"+ "," +"'"+ r.getSubmitterName() +"'"+ "," +"'"+ r.getListOfIngredient() +"'"+ "," +"'"+ r.getDetailedDiscription() +"'"+ "," + r.getRecipeId() + ")";
		System.out.println(query);
		st.executeUpdate(query);
		
	}
	void addRecipeToNeedApprovalTable(Recipe r) throws ClassNotFoundException, SQLException {
		Connection con = getConnectionRecipeManagement();
		Statement st = con.createStatement();
		String query = "insert into needApproval values(" +"'"+r.getRecipeName() +"'"+ "," +"'"+ r.getSubmitterName() +"'"+ "," +"'"+ r.getListOfIngredient() +"'"+ "," +"'"+ r.getDetailedDiscription() +"'"+ "," +r.getRecipeId() + ")";
		System.out.println(query);
		st.executeUpdate(query);
		
	}
	
	void deleteRecipeFromRecipeTable(Recipe r) throws ClassNotFoundException, SQLException{
		Connection con = getConnectionRecipeManagement();
		Statement st = con.createStatement();
		String query = "delete from recipe where recipeId = " + r.getRecipeId();
		st.executeUpdate(query);
		
	}
	void deleteRecipeFromNeedApprovalTable(Recipe r) throws ClassNotFoundException, SQLException {
		Connection con = getConnectionRecipeManagement();
		Statement st = con.createStatement();
		String query = "delete from needApproval where recipeId = " + r.getRecipeId();
		st.executeUpdate(query);
	}
	
	
	ArrayList<Recipe> getListFromNeedApproval() throws ClassNotFoundException, SQLException {
		ResultSet rs = setConnectionToGetDetails("select * from sys.needApproval");
		ArrayList<Recipe> listRecipe = new ArrayList<Recipe>();
		while(rs.next()) {
			Recipe r = new Recipe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			listRecipe.add(r);
		}
		
		return listRecipe;	
	}
	
	ArrayList<Recipe> seeAllRecipe() throws ClassNotFoundException, SQLException {
		ResultSet rs = setConnectionToGetDetails("select * from sys.recipe");
		ArrayList<Recipe> listRecipe =  new ArrayList<Recipe>();
		while(rs.next()) {
			Recipe r = new Recipe(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			listRecipe.add(r);
		}
		return listRecipe;	
	}
	/*
	void approvalOperation() throws ClassNotFoundException, SQLException{
		ArrayList<Recipe> list= getListFromNeedApproval();
		Scanner sc = new Scanner(System.in);
		for(Recipe r : list) {
			System.out.println("Press 1 for Approve and 2 for Reject : ");
			int flag = sc.nextInt();
			if (flag == 1) {
				//add r to the recipe table
				addRecipeTorecepiTable(r);
				//delete r from need approval table
				deleteRecipeFromNeedApprovalTable(r);
			}
			else {
				//delete r from need approval table
				deleteRecipeFromNeedApprovalTable(r);
			}
				
		}
		
	}*/
	
	
	
	
	
}
