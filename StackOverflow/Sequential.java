import java.text.DecimalFormat;
import java.util.*;

public class Sequential{
	
public static void main(String[] args){
	String continueRunning = "Y";
	while(continueRunning.equals("Y")){
	int max = 0;
	int n;
	Scanner userInput = new Scanner(System.in);
	System.out.print("Enter an integer value (1-6) for n in the equation 2^(5n): ");
	n = userInput.nextInt();
	while(n < 1 || n > 6){
		System.out.print("Please re-enter a value for n (1-6): ");
		n = userInput.nextInt();
	}
	System.out.println("For n equal to: " + n);
	int iter = (int) Math.pow(2, (5*n));
	System.out.println("Number of iterations: " + iter);
	int A[] = new int[iter];
	for(int i = 0; i < iter; i++){
		A[i] = randomGen();
	}
	long startTime = System.currentTimeMillis();
	for(int i = 0; i < iter; i++){
		if(max < A[i]){
			max = A[i];
		}
	}
	long totalTime = System.currentTimeMillis() - startTime;
	double seconds = (double)totalTime/1000.0;
	System.out.println("The max number is: " + max);
	DecimalFormat df = new DecimalFormat("#0.000000000");
	System.out.println("Elapsed time is: " + df.format(seconds));
	System.out.println();
	Scanner r = new Scanner(System.in);
	System.out.print("Do you wish to continue? (y/n) ");
	continueRunning = userInput.next().toUpperCase(); 
	while(!(continueRunning.equals("N") || (continueRunning.equals("Y")))){
		System.out.print("Invalid input. Would you like to continue? (y = yes, n = no)");
		continueRunning = userInput.next();
		continueRunning = continueRunning.toUpperCase();
	}
	if(continueRunning.equals("Y")){
    	continue;
    }
	if(continueRunning.equals("N")){
    	System.out.println("Okay, have a great day!");
    	break;
	}
	}
}
public static int randomGen(){
	Random r = new Random();
	int k = r.nextInt(999)+1;
	return k;
}
}