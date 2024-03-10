package stufentdatabaseapp;

import java.util.Scanner;

public class StudentDatabaseApp {

	public static void main(String[] args) {
//		Student stud2=new Student();
//		stud2.enroll();
//		stud2.payTution();
//		System.out.println(stud2.toString());
//		
//		Student stud3=new Student();
//		stud3.enroll();
//		stud3.payTution();
//		System.out.println(stud3.toString());
		
		// Ask how many new users we want
		System.out.println("Enter number of Students to be enrolled: ");
		Scanner in =new Scanner(System.in);
		int numOfStudent = in.nextInt();
		Student[] students = new Student[numOfStudent];
		
//		Create n number of new students
		for(int n=0;n<numOfStudent;n++) {
			students[n] = new Student();
			students[n].enroll();
			students[n].payTution();
			System.out.println(students[n].toString());
		}
		
		

	}

}
