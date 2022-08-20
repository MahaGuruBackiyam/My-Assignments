package Week3.day1;

public class Students {
	public void getStudentInfo(int id) {
		System.out.println("Id of the student: " + id);
	}

	public void getStudentInfo(int id, String name) {
		System.out.println("Id of the student: " + id+ ",  "
				+ " Name of the student: " + name);
	}

	public void getStudentInfo(String email, long phoneNumber) {

		System.out.println("Email of the student: " + email + ",  "
				+ " Phone number of the Student: " + phoneNumber);
	}

	public static void main(String[] args) {
		Students student = new Students();
		student.getStudentInfo(17020);
		student.getStudentInfo(17020, "Maha");
		student.getStudentInfo("17ee020@ritrjpm.ac.in", 9785621300l);

	}

}
