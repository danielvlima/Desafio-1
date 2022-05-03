package util;

import entities.Student;

public class EmailGenerator {
	
	
	public static String[] getUffmailSuggestions(Student student) {
		
		String[] emails = new String[5];
		String[] arrayName= student.getArrayName();
		
		for (int i = 0; i < 5; i++) {
			
			int count = 1;
			switch (i) {
			
			case 0:
				emails[i] = (arrayName[0] + "_" + arrayName[1] + "@id.uff.br").toLowerCase();
				while(checkUffmailAvailability(emails[i]) != true) {
					emails[i] = (arrayName[0] + "_" + arrayName[1] + count + "@id.uff.br").toLowerCase();
					count++;
				};
				count = 1;
				
				break;
				
			case 1:
				String firstCharSurname = "";
				for (int j = 1; j < arrayName.length; j++) {
					firstCharSurname += Character.toString(arrayName[j].charAt(0));
				}
			
				emails[i] = (arrayName[0] + firstCharSurname + "@id.uff.br").toLowerCase();
				while(checkUffmailAvailability(emails[i]) != true) {
					
					
					emails[i] = (arrayName[0] + firstCharSurname + count + "@id.uff.br").toLowerCase();
					count++;
				};
				count = 1;
				
				
				break;
				
			case 2:
				emails[i] = (arrayName[0] + arrayName[arrayName.length - 1] + "@id.uff.br").toLowerCase();
				while(checkUffmailAvailability(emails[i]) != true) {
					emails[i] = (arrayName[0] + arrayName[arrayName.length - 1] + count + "@id.uff.br").toLowerCase();
					count++;
				};
				count = 1;
				
				break;
				
			case 3:
				emails[i] = (Character.toString(arrayName[0].charAt(0)) + arrayName[arrayName.length - 1] + "@id.uff.br").toLowerCase();
				while(checkUffmailAvailability(emails[i]) != true) {
					emails[i] = (Character.toString(arrayName[0].charAt(0)) + arrayName[arrayName.length - 1] + count + "@id.uff.br").toLowerCase();
					count++;
				};
				count = 1;
				
				break;
				
			case 4:
				emails[i] = (Character.toString(arrayName[0].charAt(0)) + arrayName[1] + arrayName[2] + "@id.uff.br").toLowerCase();
				while(checkUffmailAvailability(emails[i]) != true) {
					emails[i] = (Character.toString(arrayName[0].charAt(0)) + arrayName[1] + arrayName[2] + count + "@id.uff.br").toLowerCase();
					count++;
				};
				count = 1;
				
				break;
			}	
		}

		
		return emails;
	}
	
	public static Boolean checkUffmailAvailability(String email) {
		Boolean availability = false;
		Student student = new HandleCSV().getStudentByUffmail(email);
		if (student == null) {
			availability = true;
		}
		return availability;
	}
}
