package org.student;

import org.department.Department;

public class Student extends Department {
	public void studentName() {
		System.out.println("Name of the student: Maha");
	}

	public void studentDept() {
		System.out.println("Department of the student: EEE");
	}

	public void studentId() {
		System.out.println("Student ID: 17ee020");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.collegeName();
		student.collegeCode();
		student.collegeRank();
		student.deptName();
		student.studentName();
		student.studentDept();
		student.studentId();

	}

}
