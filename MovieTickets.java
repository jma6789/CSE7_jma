/*
CSE 007: HW1
James Ma
Write a program that outputs the price of a movie ticket based on age and time of showing
 */

import java.util.Scanner;

public class MovieTickets {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in); 
        double SALES_TAX = 0.06;

        System.out.println("Enter movie showing time (Morning, Matinee, Evening) and your age (>0).");
            String movie = input.next();
            int age = input.nextInt();
            input.close();

            switch (movie){
                case "Morning":
                    if (age > 0 && age < 11){
                        System.out.printf("You are %d years-old ", age, "watching a Morning show.");
                        System.out.println("Your ticket price is $0.00.");
                    } else if (age >= 10){
                        System.out.printf("You are %s years-old watching a Morning show.", age);
                        System.out.printf("Your ticket price is $%.2f.\n", 7.00 + (7.00 * SALES_TAX));
                    } else{
                        System.out.println("Invalid age. Must be >0.");
                    }
                    break;
                case "Matinee":
                if (age > 0 && age < 4){
                    System.out.printf("You are %d years-old ", age, "watching a Matinee show.");
                    System.out.println("Your ticket price is $0.00.");
                } else if (age >= 4){
                    System.out.printf("You are %s years-old watching a Morning show.", age);
                    System.out.printf("Your ticket price is $%.2f.\n", 10.00 + (10.00 * SALES_TAX));
                } else{
                    System.out.println("Invalid age. Must be >0.");
                }
                break;

                case "Evening":
                if (age > 0 && age < 4){
                    System.out.printf("You are %d years-old ", age, "watching a Matinee show.");
                    System.out.println("Your ticket price is $0.00.");
                } else if (age >= 4 && age < 17){
                    System.out.printf("You are %s years-old watching a Morning show.", age);
                    System.out.printf("Your ticket price is $%.2f.\n", 14.00 + (14.00 * SALES_TAX));
                } else if (age >= 17 && age < 55){
                    System.out.printf("You are %s years-old watching a Morning show.", age);
                    System.out.printf("Your ticket price is $%.2f.\n", 20.00 + (20.00 * SALES_TAX));
                } else if (age >= 55){
                    System.out.printf("You are %s years-old watching a Morning show.", age);
                    System.out.printf("Your ticket price is $%.2f.\n", 15.00 + (15.00 * SALES_TAX));
                } else{
                    System.out.println("Invalid age. Must be >0.");
                }
                break;
                default: System.out.println("Time not found. Must be Morning, Matinee, or Evening.");
                
            }
                
            }
        }
