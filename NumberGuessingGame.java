package NumGuessGame;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        Random r = new Random();
        boolean playAgain = true;
        int totScore = 0;
        int rounds = 0;
        System.out.println("Welcome to the Number Guessing Game"+"\n");
    while (playAgain) {
    	int randomNum = r.nextInt(100) + 1;
        int attempts = 0;
        boolean correctGuess = false;
        rounds++;
        System.out.println("Round " + rounds + ": Guess the number between 1 and 100.");
        System.out.println("Note : You have 10 attempts.");
        while (attempts < 10 && !correctGuess) {
        	System.out.print("Enter your guess: ");
        	if (s.hasNextInt()) {
            	int userGuess = s.nextInt();
                attempts++;
                if (userGuess == randomNum) {
                    System.out.println("Congratulations! You have guessed the correct number in " + attempts + " attempts.");
                    correctGuess = true;
                    totScore += 10 - attempts; 
                }
                else if (userGuess < randomNum) {
                    System.out.println("Too low! Try again."+"\n");
                }
                else if(userGuess > randomNum && userGuess<100){
                    System.out.println("Too high! Try again."+"\n");
                }
                else if(userGuess>100) {
                	System.out.println("The guessed number is Out of Limit"+"\n");
                }
        	}
        	else {
                System.out.println("Invalid input. Please enter an integer between 1 and 100.");
                s.next(); 
                 }
        }
        	if (!correctGuess) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + randomNum + "."+"\n");
            }
            System.out.print("\n"+"Do you want to play another round? (yes/no): ");
            String response = s.next();
            playAgain = response.equalsIgnoreCase("yes");
            if(response.equalsIgnoreCase("yes")) {
            System.out.println("\n"+"Welcome Back !!!"+"\n");
        }
    }
        System.out.println("Game Over. Your total score is " + totScore + ".");
        s.close();
    }
}

	    




