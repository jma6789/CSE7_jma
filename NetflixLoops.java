import java.util.Scanner;
public class NetflixLoops {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in); 
        int random = (int) (Math.random() * 9) + 2; // 2-10

        String name = "";
        double sum = 0;
        double average = 0;

        for(int count = 0; count < random; count++){
            System.out.println("Type movie title.");
            name += keyboard.nextLine() + "\n";
            
            boolean flag=true;
            do{
            System.out.println("Enter a rating 1-5.");
            boolean correct = keyboard.hasNextInt();
            if(correct){
            int val = keyboard.nextInt();
            keyboard.nextLine(); // *** NEED TO CLEAR SCANNER ***
            if(val >= 1 && val <= 5){
                sum += val;
                flag = false;
            }else{
                System.out.println("Error: rating must be 1-5.");
            }

            }else{
            System.out.println(" invalid input");
            String junk = keyboard.nextLine(); // *** NEED TO USE NEXTLINE TO CLEAR SCANNER ***
            }
            } while(flag == true);
        }
        keyboard.close();
        System.out.printf("You entered the following movies: %s \n", name);
        System.out.printf("Average rating of movies: %.4f\n", average = sum / random);
        
    }
}
