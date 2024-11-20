package nexwareSolutions.Task1;

import java.util.Random;
import java.util.Scanner;

public class NumberGame {
	
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int score = 0;
	        int roundsPlayed = 0;
	        
	        System.out.println("Welcome to the Number Game!");
	        
	        while (true) {
	            int targetNumber = random.nextInt(100) + 1;  // Generate a number between 1 and 100
	            int maxAttempts = 10;
	            int attempts = 0;
	            boolean guessedCorrectly = false;

	            System.out.println("\nNew round! Guess the number between 1 and 100.");
	            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

	            while (attempts < maxAttempts) {
	                System.out.print("Enter your guess: ");
	                
	                try {
	                    int guess = Integer.parseInt(scanner.nextLine());
	                    attempts++;
	                    
	                    if (guess < targetNumber) {
	                        System.out.println("Too low!");
	                    } else if (guess > targetNumber) {
	                        System.out.println("Too high!");
	                    } else {
	                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
	                        score += maxAttempts - attempts + 1;  // Score based on attempts
	                        guessedCorrectly = true;
	                        break;
	                    }
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid input. Please enter a number.");
	                }
	            }

	            if (!guessedCorrectly) {
	                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + targetNumber + ".");
	            }

	            roundsPlayed++;

	            System.out.print("Do you want to play another round? (yes/no): ");
	            String playAgain = scanner.nextLine().trim().toLowerCase();
	            if (!playAgain.equals("yes")) {
	                System.out.println("\nGame over!");
	                System.out.println("Total rounds played: " + roundsPlayed);
	                System.out.println("Your final score: " + score);
	                break;
	            }
	        }

	        scanner.close();
	    }
	}

