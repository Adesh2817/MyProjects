package EmailProject;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastName;
	private String password;
	private int defaultpasswordLength = 10;
	private String email;
	private String CompanySuffix = "aeycompany.com";
	private String department;
	private int EmailCapacity = 500;
	private String AlternateEmails;
	
	public Email(String firstname, String lastName) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
//		System.out.println("EMAIL CREATED: " + this.firstname + " " + this.lastName);
	
//		Call a method asking for a department to return the department
		this.department= setDepartment();
		System.out.println("Department selected : " + this.department);
		
//		Call a method to return a random password
		this.password = randomPassword(defaultpasswordLength);
		System.out.println("Your Password is " + this.password);
		
//		Combine elements to genetrate email
		email= firstname.toLowerCase() + "." + lastName.toLowerCase() + "@" + department.toLowerCase()+"." + CompanySuffix;
//		System.out.println("Your email is " + email);
	}
	
//	Ask the department
	
	private String setDepartment() {
		System.out.println("Department Codes:\nEnter your department:\n1:Sales\n2:Developers\n3:Accountant\n4:none\nEnter your Department:");
		Scanner in=new Scanner(System.in);
		 int deptChoice = in.nextInt();
		if(deptChoice == 1) {return "Sales";}
		else if(deptChoice == 2) {return "Developers";}
		else if(deptChoice == 3){return "Accountant";}
		else{return " ";}
		
	}
	
	private String randomPassword(int length) {
		String PasswordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^";
		char[] password = new char[length];
		for(int i=0;i<length; i++) {
			int rand=(int) (Math.random() * PasswordSet.length());
			password[i] = PasswordSet.charAt(rand);
		}
		return new String(password);
	}
	
//	Set the mailbox capacity
	public void setMailboxcapacity(int capacity) {
		this.EmailCapacity= capacity;
		
	}
	
	public void setAlternateEmail(String AltEmail) {
		this.AlternateEmails = AltEmail ;
		
	}
	
	public void ChangePassWord(String password) {
		this.password = password ;
		
	}
	
	public int getCheckMailboxcapacity() {return EmailCapacity;}
	public String getAlternateEmails() {return AlternateEmails;}
	public String getPassword() {return password;}
	
	public String ShowInfo() {
		return "YOUR NAME: " + firstname + " " + lastName + 
				"COMPANY EMAIL: " + email +
				"\nMAIL CAPACITY: " +
				EmailCapacity + "MB";
	}

	
	
	
	
	
	

}
