package entities;

public class Student {
	private Integer enrollment;
	private String name;
	private String telephone;
	private String email;
	private String uffmail;
	private String status;
	private String firstName;
	
	public Student(int enrollment, String name, String telephone, String email, String uffmail, String status) {
		this.enrollment = enrollment;
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.uffmail = uffmail;
		this.status = status;
	}

	public Integer getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(int enrollment) {
		this.enrollment = enrollment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUffmail() {
		return uffmail;
	}

	public void setUffmail(String uffmail) {
		this.uffmail = uffmail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String[] getArrayName() {
		String [] vect = name.split(" ");
		return vect;
	}
	
}