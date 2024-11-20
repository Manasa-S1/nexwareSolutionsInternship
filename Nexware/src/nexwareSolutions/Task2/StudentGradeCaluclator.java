package nexwareSolutions.Task2;

import java.util.Scanner;

public class StudentGradeCaluclator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of subjects:");
		int subject = s.nextInt();
		int arr[] = new int[subject];
		int marks=0;
		for(int i=0;i<arr.length;i++) {
			arr[i]=s.nextInt();
			marks += arr[i];
		}
		System.out.println("Total marks:"+marks);
	    double avg = (double)marks/subject;
	    System.out.println("Average marks:"+avg);
	    if(avg>=90&&avg<100) {
	    	System.out.println("A Grade");
	    } else if(avg>=75&&avg<90) {
	    	System.out.println("B Grade");
	    } else if (avg >=60 && avg<75) {
	    	System.out.println("C Grade");
	    } else if(avg >=35 && avg <60) {
	    	System.out.println("D Grade");
	    	
	    }else {
	    	System.out.println("FAIL");
	    }
	}
	}


