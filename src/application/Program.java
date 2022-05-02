package application;

import java.util.Scanner;

import entities.Student;
import util.HandleCSV;


public class Program {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int enrollment = 105457;
		
		HandleCSV handleCSV = new HandleCSV();
		
		
	
		System.out.println("Digite sua matricula: ");
		enrollment = read.nextInt();
		
		Student student = handleCSV.getNameByEnrollment(enrollment);
		
		System.out.println(student.getFirstName() + ", por favor escolha uma das opções abaixo para o seu UFFmail");
		
		
		System.out.println(student.getTelephone());
	}
}