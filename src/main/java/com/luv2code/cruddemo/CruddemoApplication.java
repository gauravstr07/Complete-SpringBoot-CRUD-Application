package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudent(studentDAO);

			// queryForStudentByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted rows count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 4;

		System.out.println("Deleting student Id: " + studentId);

		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 2;
		System.out.println("Getting student with id: " + studentId);

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student ...");
		myStudent.setFirstName("AkshuWifeeee");

		studentDAO.update(myStudent);

		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Gugale");

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// creating a new student
		System.out.println("Creating a new student object");
		Student tempStudent = new Student("Hardwell", "Hard Str", "hardstr26@");

		System.out.println("Saving the  student into database ... ");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated Id: " + theId);

		System.out.println("Retriving student with id " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student: " + myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 new student object ... ");
		Student tempStudent1 = new Student("Gaurav", "Sutar", "gauravstr05@");
		Student tempStudent2 = new Student("Akshu", "Gugale", "akshugug07@");
		Student tempStudent3 = new Student("Hema", "Gugale", "hemagug@06");

		System.out.println("Saving the 3 student into database ... ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("Saved student. Generated Id: " + tempStudent1.getId());
		System.out.println("Saved student. Generated Id: " + tempStudent2.getId());
		System.out.println("Saved student. Generated Id: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object ... ");
		Student tempStudent = new Student("Gaurav", "Sutar", "gauravstr05@");

		System.out.println("Saving the student into database ... ");
		studentDAO.save(tempStudent);

		System.out.println("Saved student. Generated Id: " + tempStudent.getId());
	}

}
