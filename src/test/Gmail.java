package test;

public class Gmail {
	String username;
	String password;

	Gmail(String username, String password) {
		System.out.println("Running arg constructor");
		this.username = username;
		this.password = password;
	}

	public void details() {
		System.out.println("Username is: " + username);
		System.out.println("Password is: " + password);
	}

}
