/*
 * James Ma
 * CSE 007
 * Write program that converts between binary, octal, and hexadecimal numbers. 
 */

import java.util.Scanner; 
public class numberConversions {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);//declare everything beforehand so you can reuse vars in separate loops.
        String binary;
        String octal;
        String hex;
        String type;
        boolean isType = false;
        char digit;
        int digitNum = 0;
        int decimal = 0;
        boolean isBinary = false;
        boolean isOctal = false;
        boolean isHex = false;


        do {
            System.out.println("Enter a number type: Binary, Octal, or Hex.");//dowhile to prompt user to enter # type; repeatedly reprompt if entry invalid.
            type = in.nextLine();

            switch (type) { // switch statement selects different cases based on the user's entry. 
                case "Binary":
                do { // dowhile loop validates user input. 
                    System.out.println("Enter num w/ 8 digits; each digit 0 or 1.");
                    binary = in.nextLine(); // use scanner to input string into the "binary" var. 
                    if(binary.length() == 8){
                        for(int i = 0; i < 8; i++){ // use a for loop to increment through the chars of the entered value.
                            digit = binary.charAt(i); // assign every char to a var called "digit"
                            digitNum = digit - '0'; // use digit - '0' to convert the individual char to int.

                            if(digitNum == 0 || digitNum == 1){
                                decimal += (int)(digitNum * Math.pow(2, 7-i)); // converts int to decimal no.
                                // -i to assign proper power based on index. Ex.) 2^(7-0) for the first digit because 
                            }else{
                                String junk = in.nextLine();
                                System.out.println("Invalid digit: " + digit);
                            }
                        }
                        isBinary = true;
                    } else{
                        System.out.print("Invalid input! ");
                    }
                    
                }while(isBinary==false);
                isType = true;
                    
                System.out.printf("Binary %s has decimal value of %d\n", binary, decimal);
                break;


            
                case "Octal":
                    
                    do {
                        System.out.println("Enter num w/ 6 digits; each digit 0-7.");
                        octal = in.nextLine();
                        if(octal.length() == 6){
                            for(int i = 0; i < 6; i++){
                                digit = octal.charAt(i);
                                digitNum = digit - '0';
    
                                if(digitNum >= 0 && digitNum < 8){
                                    decimal += (int)(digitNum * Math.pow(8, 5-i));
                                }else{
                                    String junk = in.nextLine();
                                    System.out.println("Invalid digit: " + digit);
                                }
                            }
                            isOctal = true;
                        } else{
                            System.out.print("Invalid input! ");
                        }
                        
                    }while(isOctal==false);
                    isType = true;
                        
                    System.out.printf("Octal %s has decimal value of %d\n", octal, decimal);
                    break;

                case "Hex":
                do {
                    System.out.println("Enter num w/ 4 digits; each digit 0-9, A-F for final.");
                    hex = in.nextLine();
                    if(hex.length() == 4){
                        for(int i = 0; i < 4; i++){
                            digit = hex.charAt(i);
                            if(digit >= '0' && digit <= '9'){
                                digitNum = digit - '0';
                            }else if(digit >= 'A' && digit <= 'F'){
                                digitNum = digit - 'A' + 10; // +10 BECAUSE ...
                                
                            }else{
                                System.out.println("Invalid digit: " + digit);
                            }
                            /*if(i <= 3){
                                digitNum = digit - '0';
                                decimal += (int)(digitNum * Math.pow(16,3-i));
                            }else if (i == 4){
                                digitNum = digit - 'A' + 10;
                            }else{
                                System.out.println("Invalid digit: " + digit);
                            }*/

                            decimal += (int)(digitNum * Math.pow(16,3-i));
                            }
                        
                        isHex = true;
                    } else{
                        System.out.print("Invalid input! ");
                    }
                    
                }while(isHex==false);
                isType = true;
                    
                System.out.printf("Hexadecimal %s has decimal value of %d\n", hex, decimal);
                    break;

                default:
                    System.out.print("Wrong type! ");
                    break;
            }
        } while (isType == false);
        /*do {
            System.out.println("Enter num w/ 6 digits; each digit 0-7.");
            octal = in.nextLine();
            if(octal.length() == 6){
                isOctal = true;
            } else{
                String junk = in.nextLine();
                System.out.print("Invalid input! ");
            }
        }while(isOctal==false);

            for(int i = 0; i < 6; i++){
                digit = octal.charAt(i);
                digitNum = digit - '0';

                if(digitNum >= 0 && digitNum < 8){
                    decimal = (int)(digitNum * Math.pow(8, 6-i));
                }else{
                    String junk = in.nextLine();
                    System.out.println("Invalid digit: " + digit);
                }
            }*/

    in.close();
    }
}
