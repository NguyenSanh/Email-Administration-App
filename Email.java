package emailapp;

import java.util.Scanner;

public class Email {
	// Private class fields
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private int defaultPasswordLength = 10;
	private String department;
	private int mailboxCapacity = 500;
	private String emailAlternate;
	private String companySuffix = "company.com";

	
	
	// Constructor receives first and last name inputs
	public Email(String firstName, String lastName) {
		// Set class level variable to local variable argument
		this.firstName = firstName;
		this.lastName = lastName;
				
		// Call a method asking for the department - return department
		this.department = setDepartment();
		
		// Call a method returning random password
		this.password = generatePassword(defaultPasswordLength);
		System.out.println("Your password is " + this.password);
		
		// Generate email address
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	
	// Request and fetch department data
	private String setDepartment() {
		System.out.println("New employee: " + firstName + "\nDepartment Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
		Scanner in = new Scanner(System.in);  // Prompt user input from the console
		int depChoice = in.nextInt();	// User enters 1,2,3, or 0
		
		// Check for each department response
		if (depChoice == 1) {return "sales";}
		else if (depChoice == 2) {return "dev";}
		else if (depChoice == 3) {return "acct";}
		else {return "";}
	}
	
	// Generate random password
	private String generatePassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&()";
		char[] pass = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			pass[i] = passwordSet.charAt(rand);
		}
		
		return new String(pass);
	}
	
	// Set mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
		
	}
	
	// Set the alternate email
	public void setEmailAlternate(String emailAlt) {
		this.emailAlternate = emailAlt;
	}
	
	// Change password
	public void editPassword(String newPass) {
		this.password = newPass;
	}
	
	// Getter methods
	public int getMailboxCapacity() {return mailboxCapacity;}
	public String getEmailAlternate() {return emailAlternate;}
	public String getPassword() {return password;}
	
	
	public String showUserInfo() {
		return "Display Name: " + firstName + " " + lastName + 
				"\nCompany Email: " + email +
				"\nMailbox Capacity: " + mailboxCapacity + " megabytes";
		
	}
	
	
}
