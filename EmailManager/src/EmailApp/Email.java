package EmailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity;
	private int defualtPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "mycompany.com";
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		
		this.password = randomPassword(defualtPasswordLength);
		
		email = this.firstName.toLowerCase() + this.lastName.toLowerCase() + "@" + department + "." + companySuffix; 
	}
	
	private String setDepartment() {
		
		System.out.print("1 for Sales\n2 for development\n3 for accounting\n0 for nothing\nEnter the department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt();
		
		if (depChoice == 1) {return "sales";} 
		else if (depChoice == 2) {return "dev";}
		else if (depChoice == 3) {return "acct";}
		else {return "";}
	
	}	
	
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	public void setMailCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	public void setAlternatEMail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() {return this.mailboxCapacity;}
	public String getAlternateEmail() {return this.alternateEmail;}
	public String getPassword() {return this.password;}	
	
	public String showInfo() {
		return "DISPLAY NAME: " + this.firstName + " " + this.lastName +
			   "\nCOMPANY EMAIL: " + email +
			   "\nPASSWORD: " + this.password +
			   "\nMAILBOX CAPACITY: " + this.mailboxCapacity + "mb";
	}
	
	
	
}	