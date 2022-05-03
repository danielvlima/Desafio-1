package application;

import java.util.Scanner;

import entities.Student;
import util.EmailGenerator;
import util.HandleCSV;


public class Program {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int enrollment;
		
		HandleCSV handleCSV = new HandleCSV();
		
		
	
		System.out.println("Digite sua matricula: ");
		enrollment = read.nextInt();
		
		Student student = handleCSV.getStudentByEnrollment(enrollment);
		
		if (student != null && student.getUffmail() == "") {	
			String firstName = student.getArrayName()[0];
			
			System.out.println( firstName + ", por favor escolha uma das opções abaixo para o seu UFFmail");
		
			String[] uffmailsArray = EmailGenerator.getUffmailSuggestions(student);
			
			for (int i = 0; i < uffmailsArray.length; i++ ) {
				System.out.println(i+1 + " - " + uffmailsArray[i]);
			}
		} else if (student.getUffmail() != ""){
			System.out.println("Aluno já possui um email da UFF: " + student.getUffmail());
		} else {
			System.out.println("Matrícula não encontrada.");
		}
		
		
	}
}