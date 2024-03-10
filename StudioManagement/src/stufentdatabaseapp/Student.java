package stufentdatabaseapp;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String lastName;
	private int gradeYear;
	private String studentID;
	private static int id=1000;
	private String courses ="";
	private int tutionBalance =0;
	private static int costOfCourse=600;
	
//	Construct prompt user to add student's name and user
	public Student() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter first name: ");
		this.firstName= in.nextLine();
		
		System.out.println("Enter last name: ");
		this.lastName=in.nextLine();
		
		System.out.println("1-Fresher\n2-Sophmore\n3-Junior\n4-Senior\nEnter student class level: ");
		this.gradeYear= in.nextInt();
		
		setstudentID();
//		System.out.println(firstName + " " + lastName + " " + " " + gradeYear + " " + studentID);
		
		
	}
//	Generate an ID
	private void setstudentID() {
//		Grade year + ID
		id++;
		this.studentID= gradeYear + "" + id;
	} 
//	enroll in courses
	public void enroll() {
		do {
		System.out.println("Enter your course(Q to Quit): ");
		Scanner in= new Scanner(System.in);
		String course = in.nextLine();
		
		if(!course.equals("Q")) {
			courses = courses + "\n" + course;
			tutionBalance = tutionBalance + costOfCourse;
		}else {
			System.out.println("BREAK! ");
			break;
			}
	}while(1 != 0);
		
		System.out.println("ENROLLED IN: " + courses);
//		System.out.println("Tution Balance: " + tutionBalance);
	}
	
//	View balance
	public void viewbalance() {
		System.out.println("Your Balance: " + tutionBalance + "rs");
	}
//	pay tution
	public void payTution() {
		viewbalance();
		System.out.println("Your payment is " );
		Scanner in= new Scanner(System.in);
		int payment = in.nextInt();
		tutionBalance = tutionBalance - payment;
		System.out.println("thank you for the payment of " + payment +"rs");
		viewbalance();
	}
	
	public String toString() {
		return "Name: " + firstName + " " +lastName +
				"\nGrade Level: " + gradeYear +
				"\nStudentID: " + studentID +
				"\nEnrolled in courses: " + courses +
				"\nBalance is " + tutionBalance;
	}
	
	
	

}
