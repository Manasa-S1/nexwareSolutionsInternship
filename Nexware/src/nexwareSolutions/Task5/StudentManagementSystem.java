    package nexwareSolutions.Task5;
	import java.io.*;
	import java.util.*;

	public class StudentManagementSystem {
	    private List<Student> students;
	    private final String FILE_NAME = "students.txt";

	    public StudentManagementSystem() {
	        students = new ArrayList<>();
	        loadStudents();
	    }

	    private void loadStudents() {
	        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 3) {
	                    students.add(new Student(parts[0], parts[1], parts[2]));
	                }
	            }
	        } catch (IOException e) {
	            // File not found, start with an empty list
	        }
	    }

	    private void saveStudents() {
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
	            for (Student student : students) {
	                bw.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
	                bw.newLine();
	            }
	        } catch (IOException e) {
	            System.out.println("Error saving students: " + e.getMessage());
	        }
	    }

	    public boolean addStudent(String name, String rollNumber, String grade) {
	        for (Student student : students) {
	            if (student.getRollNumber().equals(rollNumber)) {
	                System.out.println("A student with this roll number already exists.");
	                return false;
	            }
	        }
	        students.add(new Student(name, rollNumber, grade));
	        saveStudents();
	        return true;
	    }

	    public boolean removeStudent(String rollNumber) {
	        for (Student student : students) {
	            if (student.getRollNumber().equals(rollNumber)) {
	                students.remove(student);
	                saveStudents();
	                return true;
	            }
	        }
	        return false;
	    }

	    public Student searchStudent(String rollNumber) {
	        for (Student student : students) {
	            if (student.getRollNumber().equals(rollNumber)) {
	                return student;
	            }
	        }
	        return null;
	    }

	    public void displayStudents() {
	        if (students.isEmpty()) {
	            System.out.println("No students found.");
	        } else {
	            for (Student student : students) {
	                System.out.println(student);
	            }
	        }
	    }
	}

