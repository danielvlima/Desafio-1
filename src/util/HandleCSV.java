package util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import entities.Student;
 
 
public class HandleCSV {
	
	private Student student;
	private String path = "src\\dataset\\students.csv";
	
	
	public Student getStudent() {
		return student;
	}
	

	
	
	public Student getStudentByEnrollment(Integer enrollmentConsult){
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null ) {
				
				String [] vect = line.split(",");
				String name = vect[0];
				int enrollment = Integer.parseInt(vect[1]);
				String telephone = vect [2];
				String email = vect [3];
				String uffmail = vect [4];
				String status = vect [5];
				
				
				if (enrollmentConsult == enrollment) {
					student = new Student(enrollment, name, telephone, email, uffmail, status);

					
				}
				line = br.readLine();
				
			}
		
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return student;
		
	}
	
	
	public Student getStudentByUffmail(String uffmailConsult) {
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			line = br.readLine();
			while (line != null ) {
				
				String [] vect = line.split(",");
				String name = vect[0];
				int enrollment = Integer.parseInt(vect[1]);
				String telephone = vect [2];
				String email = vect [3];
				String uffmail = vect [4];
				String status = vect [5];
				
			
				if (uffmailConsult.equals(uffmail)) {
					student = new Student(enrollment, name, telephone, email, uffmail, status);

					
				}
				line = br.readLine();
				
			}
		
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		return student;
		
	}
}
