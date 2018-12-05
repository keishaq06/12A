import java.util.Scanner;

public class GuessingGame {
/*GuessingGame.java
 * Keisha Quirimit
 * kquirimi
 * Program 2
 * generates a random number and user gets 3 guesses to guess the randomly generated number
 */
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the number guessing game. What is your name?");
		String userName = input.next(); //user-input name stored as variable 
		System.out.println();
		
		int randomNum = (int)(Math.random()*10) + 1; //random number is generated
		System.out.println("I’m thinking of an integer between 1 and 10. You have 3 guesses.");	
		System.out.println();
		
		int userGuess =0; //variable to store user-input guess
		int tryNum = 0; //variable to track guess number
		int i = 1; 
		while(i<=3 && userGuess!= randomNum) //if user still has guesses left and hasn't guessed the number
		{
			switch(i) //checks which guess number user is on
			{
			case 1:
				System.out.println("Your first guess: ");
				break;
			case 2:
				System.out.println("Your second guess: ");
				break;
			case 3:
				System.out.println("Your third guess: ");
				default:
					break;
			}
			
			userGuess = input.nextInt(); //user-input integer guess is saved as userGuess
			if(userGuess < randomNum) //checks if guess is less than the generated random number
			{
				System.out.println("Too low, guess higher.");
			}
				if( userGuess > randomNum) //checks if guess is greater than the generated random number
			{
				System.out.println("Too high, guess lower.");
			}
				System.out.println();
				tryNum = i; //updates and keeps track of number of attempts
				i++;
		}
		
		if(userGuess == randomNum) //if guess is correct
		{
			System.out.println("Congratulations " + userName + "! You won in " + tryNum + " guess(es).");
		}
		else //userGuess doesn't equal randomNum after 3 guesses
			System.out.println("Game over " + userName + ", you lose.");
		
		
		
	
	}
	}


