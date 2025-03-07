/*
 * James Ma
 * CSE007
 * Create text-based RPG
 */


import java.util.Scanner;
import java.util.Random;

public class RPG {

    public static void main (String[] args){
        int[] enemies = {3, 5, 8, 10, 15};
        int enemyIndex = 0;
        final int MAX_HEALTH = 25;
        int currHealth = MAX_HEALTH;
        int gold = 0;
        Random r = new Random(); // need capital R in Random
        boolean validInput = false;
        boolean flee = false;

        Scanner s = new Scanner(System.in);


        System.out.println("The player has entered the dungeon!");
        while(currHealth>0 && enemyIndex < enemies.length){
            
            enemyIndex=0; // set enemy index back to 0 to avoid out of bounds error at Line 27

            while(enemyIndex < enemies.length && enemies[enemyIndex]> 0 && flee == false){
                System.out.println("Player health:" +currHealth);
                System.out.println("Gold: "+gold +"\n");
                System.out.println("Enemy HP: " + enemies[enemyIndex]);
                
                System.out.println("What do you want to do? (Attack, Heal, Flee)"); //prompt player input

                String input = s.nextLine();

                    
            while(validInput == false){
                switch(input){
                    case "Attack":
                        System.out.println("PLAYER ATTACKED!");
                        System.out.println("Player hit for 5 damage!");
                        if(5 >= enemies[enemyIndex]){
                            System.out.println("Player defeated enemy!");
                            switch(enemyIndex){ //determines gold enemies drop
                                case 0: gold = gold + 10;break;
                                case 1: gold = gold + 12;break;
                                case 2: gold = gold + 14;break;
                                case 3: gold = gold + 16;break;
                                case 4: gold = gold + 18;break;
                            }
                            enemyIndex = enemyIndex + 1;
                        }else{
                            int x = r.nextInt(2)+2;
                            currHealth = currHealth - x;
                            System.out.println("Enemy survived! ");
                            System.out.println("Player was attacked for "+x+" HP!");
                            enemies[enemyIndex] = enemies[enemyIndex] - 5;
                        }
                        validInput = true;
                        break;
                    
                    case "Heal":
                        int y = r.nextInt(5)+2;//healing 
                        int z = r.nextInt(2)+2;//enemy attack
                        currHealth = currHealth + y;
                        if(currHealth > MAX_HEALTH){
                            currHealth = currHealth - (currHealth-MAX_HEALTH);
                        }
                        System.out.printf("Player healed by %d to %d.", y, currHealth);
                        System.out.println("Enemy hit for "+z+" dmg!");
                        validInput = true;
                        break;

                    case "Flee": 
                        System.out.println((5-enemyIndex)+" enemies remaining.");//displays #enemies remaining 
                        System.out.println("Player escaped with " +gold+ " gold!");
                        flee = true;
                        validInput = true;
                        break;
                            
                    default: 
                        
                        System.out.println("Enter a valid input!"); 
                        input = s.nextLine();
                        
                        break;
                        
                    }
                
            }
                validInput=false;
                if(currHealth<0){
                    gold = gold/2; //halves gold once player dies 
                    flee = true;
                    System.out.println("Gold left: "+gold); //prints gold left 
                }
            }
            System.out.println("You win!");

        }
    }
}