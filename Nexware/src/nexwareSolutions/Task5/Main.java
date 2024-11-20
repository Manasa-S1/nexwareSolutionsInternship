package nexwareSolutions.Task5;
	import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {
	        StudentManagementSystem system = new StudentManagementSystem();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nStudent Management System");
	            System.out.println("1. Add Student");
	            System.out.println("2. Remove Student");
	            System.out.println("3. Search Student");
	            System.out.println("4. Display All Students");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");

	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    System.out.print("Enter student's name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter student's roll number: ");
	                    String rollNumber = scanner.nextLine();
	                    System.out.print("Enter student's grade: ");
	                    String grade = scanner.nextLine();

	                    if (!name.isEmpty() && !rollNumber.isEmpty() && !grade.isEmpty()) {
	                        if (system.addStudent(name, rollNumber, grade)) {
	                            System.out.println("Student added successfully.");
	                        }
	                    } else {
	                        System.out.println("All fields are required.");
	                    }
	                    break;

	                case "2":
	                    System.out.print("Enter roll number to remove: ");
	                    rollNumber = scanner.nextLine();
	                    if (system.removeStudent(rollNumber)) {
	                        System.out.println("Student removed successfully.");
	                    } else {
	                        System.out.println("Student not found.");
	                    }
	                    break;

	                case "3":
	                    System.out.print("Enter roll number to search: ");
	                    rollNumber = scanner.nextLine();
	                    Student student = system.searchStudent(rollNumber);
	                    if (student != null) {
	                        System.out.println(student);
	                    } else {
	                        System.out.println("Student not found.");
	                    }
	                    break;

	                case "4":
	                    System.out.println("\nAll Students:");
	                    system.displayStudents();
	                    break;

	                case "5":
	                    System.out.println("Exiting the program.");
	                    scanner.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice.");
}
	        }
	    }
	}
	        
