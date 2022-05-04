package application;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

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
		String[] uffmailsArray = new String[5];
		if (student != null && student.getUffmail() == "") {	
			String firstName = student.getArrayName()[0];
			
			System.out.println( firstName + ", por favor escolha uma das opções abaixo para o seu UFFmail");
		
			uffmailsArray = EmailGenerator.getUffmailSuggestions(student);
			
			for (int i = 0; i < uffmailsArray.length; i++ ) {
				System.out.println(i+1 + " - " + uffmailsArray[i]);
			}
		}
		
		else if(student != null && student.getStatus().equals("Inativo")) {
			System.out.println("Alunos inativos não podem um email UFF.");
		}
		else if (student != null && student.getUffmail() != ""){
			System.out.println("Aluno já possui um email da UFF: " + student.getUffmail());
		} 
		else {
			System.out.println("Matrícula não encontrada.");
		}
		
		Integer emailChoice;
		System.out.println("");
		emailChoice = read.nextInt();
		
		System.out.println("");
		try {
			
			student.setUffmail(uffmailsArray[emailChoice - 1]);
			handleCSV.setUffmailCSV(student.getEnrollment(), student.getUffmail());
		} catch (Exception e) {
			System.out.println("Valor informado inválido");
		}
		
		System.out.println("A criação de seu e-mail " + student.getUffmail() + " será feita nos próximos minutos.");
		System.out.println("Um SMS foi enviado para " + student.getTelephone() + " com a sua senha de acesso.");
		
	}
}