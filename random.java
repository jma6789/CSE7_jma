/*
 * James Ma 
 * CSE 007
 * 
 * Write a program that prompts the user to guess number between 1-20.
 * Continously reprompts user on whether the number they guessed is higher or lower.
 * Displays no. of guesses.
 */

import java.util.Random;
import java.util.Scanner;

public class random {
    public static void main(String[] args) {
        Random r = new Random();

        int x = r.nextInt(20)+1; // sets the bounds of the random integer to be 20.
        // +1 to shift the set of numbers. Used to be 0-19, now 1-20.
        

        Scanner in = new Scanner(System.in); // declare scanner, booleans for input validation, and var for no. of guesses.
        boolean validInput = false;
        int guesses = 0;
        boolean rightGuess = false;

        do {
            System.out.println("Guess an integer from 1-20.");//prompt user to enter no.s; continuously reprompt if entry is bad.

            if (in.hasNextInt()) {
                int num = in.nextInt();
                if(num > 0 && num < 21){
                    do {
                        if(num > x){
                            guesses+=1;
                            String junk = in.nextLine();//string junk deletes what the user entered to avoid infinite loops.
                            System.out.printf("Your guess is greater than the actual number. \t Guesses: %d \n", guesses);
                            num = in.nextInt();//prompt user to enter num again. This way, the elseif loop actually works.
                            //otherwise, the elseif loop would only display the SOP string that matches the value of the first guess.
                        }else if(num<x){
                            guesses+=1;
                            String junk = in.nextLine();
                            System.out.printf("Your guess is smaller than the actual number. \t Guesses: %d \n", guesses);
                            num = in.nextInt();
                        }else{
                            System.out.printf("You guessed right! \t Guesses: %d \n", guesses);
                            rightGuess = true;
                        }
                    } while (rightGuess == false);//previously declared boolean keeps dowhile loop running.
                    
                    
                    validInput = true;
                }else{
                    System.out.println("Enter an int from 1-20.");
                }
            }else{
                String junk = in.nextLine();
                System.out.println("Enter an integer.");
            }
            
        } while (validInput == false);

    }
}
