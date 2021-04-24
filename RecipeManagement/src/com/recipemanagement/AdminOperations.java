package com.recipemanagement;



public class AdminOperations extends Operations {
	String password = "Kul_21513";
	boolean accessGranter;
	
	
	boolean checkAdmin( String pass) {
		if (this.password.equals(pass)){
			return true;
		}
		else 
			return false;
	}
}
