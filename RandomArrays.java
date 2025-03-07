/*
 * James Ma
 * CSE007
 * Create random arrays w/ command line args 
 */

import java.util.Random;

public class RandomArrays {
    public static void main(String[] args) {
        // assume user inputs int 

        int i;  //index

        double max = 0;     
        int maxI = 0;

        double min = 100; // BETTER TO USE double min = random[0] in the future.
                            //iterate thru index. This way, no need to worry about min value being out of range.
        int minI = 0;

        double sum = 0, avg;    // declare sum and avg w/ COMMA

        // NO NEED TO DECLARE ARGS
        //String arg1 = args[0];
        //String arg2 = args[1]; //iterate over both arguments 
        
        if(args.length < 2){    // checks if there are fewer than 2 args
            System.out.println("Error! Missing command line argument(s)");
            return;
        }else if(args.length > 2){  // checks if there's over 2 args
            System.out.println("Error! Only enter 2 command line args");
            return;
        }else if(Integer.parseInt(args[0]) <= 0){   // checks if args[0] (determines length of array) is > 0
            System.out.println("Error! Length must be > 0.");
            return;
        }

        Random r = new Random(Integer.parseInt(args[1])); // 2nd arg determines random
        double[] random = new double[Integer.parseInt(args[0])];    //1st arg determines array length

        for(i =0; i<random.length; i++){    //generates random doubles in [12.5, 62.5]
            random[i] = r.nextDouble()*63.5+12.5;
        }

        for(i =0; i<random.length; i++){    //prints Element [index]: [number to 4 DC]
            System.out.printf("Element %d: %.4f \n",i, random[i]);
        }System.out.println();

        for(i =0; i<random.length; i++){ // code for determining max, min, and avg
            sum += random[i];

            if(random[i] > max){
                max = random[i];
                maxI = i;
            }

            if(random[i] < min){
                min = random[i]; 
                minI = i;
            }
        }System.out.printf("Max is %.4f at index %d; min is %.4f at index %d. \n", max, maxI, min, minI);
        System.out.println("Avg is " + (sum/Integer.parseInt(args[0])));
        
    }
}
