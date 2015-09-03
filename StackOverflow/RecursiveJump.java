import java.util.*;

public class RecursiveJump {
	
	public static void main(String[] args){
		String continueRunning = "Y";
		while(continueRunning.equals("Y")){
		double max = 0;
		double n,k;
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter an integer value for n in the equation 2^(5n)(1-6): ");
		n = userInput.nextInt();
		while(n < 1 || n > 6){
			System.out.print("Please re-enter a value for n (1-6): ");
			n = userInput.nextInt();
		}
		System.out.print("Enter an integer value for partition k (2-4): ");
		k = userInput.nextInt();
		while(k < 2 || k > 4){
			System.out.print("Please re-enter a value for k (2-4): ");
			k = userInput.nextInt();
		}
		System.out.println("For n equal to: " + n);
		double iter =  Math.pow(2, (5*n));
		double jump1 =  Math.pow(iter, 0.33);
		double jump2 =  Math.pow(iter, 0.5);
		double jump3 =  Math.pow(iter, 0.75);
		System.out.println("Number of iterations: " + (int)(iter/k));
		double A[] = new double [(int) (iter/k)];
		for(int i = 0; i < (int)(iter/k); i++){
			A[i] = randomGen();
		}
		
		
		long startTime1 = System.currentTimeMillis();
		int len = A.length -1;
		max = search(len, jump1, A, max);
		long totalTime1 = System.currentTimeMillis() - startTime1;
		
		long startTime2 = System.currentTimeMillis();
		max = search(len, jump2, A, max);
		long totalTime2 = System.currentTimeMillis() - startTime2;
		
		long startTime3 = System.currentTimeMillis();
		max = search(len, jump3, A, max);
		long totalTime3 = System.currentTimeMillis() - startTime3;
		
		double seconds1 = (double)totalTime1/1000.0;
		double seconds2 = (double)totalTime2/1000.0;
		double seconds3 = (double)totalTime3/1000.0;
		System.out.println("The max number is: " + max);
		System.out.println("The value for jump size n^(1/3) is: " + jump1);
		System.out.println("The value for jump size n^(1/2) is: " + jump2);
		System.out.println("The value for jump size n^(3/4) is: " + jump3);
		System.out.format("Elapsed time for jump size n^(1/3): %f seconds", seconds1);
		System.out.println();
		System.out.format("Elapsed time for jump size n^(1/2): %f seconds", seconds2);
		System.out.println();
		System.out.format("Elapsed time for jump size n^(3/4): %f seconds", seconds3);
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
	
	public static double search(double array_length, double jump, double[] array, double max)
	{
		if (!(array_length < 0)){
			if (array[(int) array_length] >= max)
			{
				max = array[(int) array_length];
				return search(array_length-jump, jump, array, max);
			}else if (!(array[(int) array_length] >= max) || jump < array_length){
				return search(array_length-jump, jump, array, max);
			}
			}else if(jump > array_length){
				return max;
			}
		return max;
		}
		
	
	
	
	public static int randomGen(){
		Random r = new Random();
		int k = r.nextInt(999)+1;
		return k;
	}

}