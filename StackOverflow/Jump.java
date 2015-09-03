import java.text.DecimalFormat;
import java.util.*;

public class Jump {

	public static void main(String[] args){
		String continueRunning = "Y";
		while(continueRunning.equals("Y")){
		double max = 0.0;
		double n;
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter an integer value for n in the equation 2^(5n)(1-6): ");
		n = userInput.nextInt();
		while(n < 1 || n > 6){
			System.out.print("Please re-enter a value for n (1-6): ");
			n = userInput.nextInt();
		}
		System.out.println("For n equal to: " + n);
		int iter = (int) Math.pow(2, (5*n));
		double jump1 = Math.pow(iter, 0.33);
		double jump2 = Math.pow(iter, 0.5);
		double jump3 = Math.pow(iter, 0.75);
		System.out.println("Number of iterations: " + iter);
		int A[] = new int[iter];
		for(int i = 0; i < iter; i++){
			A[i] = randomGen();
		}
		long startTime1 = System.currentTimeMillis();
		for(double i = 0; i < iter; i = i + jump1){
			if(max < A[(int) i]){
				max = A[(int) i];
			}
		}
		long totalTime1 = System.currentTimeMillis() - startTime1;
		long startTime2 = System.currentTimeMillis();
		for(double i = 0; i < iter; i = i + jump2){
			if(max < A[(int) i]){
				max = A[(int) i];
			}
		}
		long totalTime2 = System.currentTimeMillis() - startTime2;
		long startTime3 = System.currentTimeMillis();
		for(double i = 0; i < iter; i = i + jump3){
			if(max < A[(int) i]){
				max = A[(int) i];
			}
		}
		long totalTime3 = System.currentTimeMillis() - startTime3;
		double seconds1 = (double)totalTime1/1000.0;
		double seconds2 = (double)totalTime2/1000.0;
		double seconds3 = (double)totalTime3/1000.0;
		System.out.println("The max number is: " + max);
		System.out.println("The value for jump size n^(1/3) is: " + jump1);
		System.out.println("The value for jump size n^(1/2) is: " + jump2);
		System.out.println("The value for jump size n^(3/4) is: " + jump3);
		DecimalFormat df = new DecimalFormat("#0.000000000");
		System.out.println("Elapsed time for jump size n^(1/3): %f seconds " + df.format(seconds1));
		System.out.println("Elapsed time for jump size n^(1/2): %f seconds " + df.format(seconds2));
		System.out.println("Elapsed time for jump size n^(3/4): %f seconds " + df.format(seconds3));
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