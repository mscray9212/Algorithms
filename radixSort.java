package radix;

import java.util.Random;
import java.util.Scanner;

public class radixSort {

	public int [] radixSorting(int[] input, int base){
        
        int t = maxValue(input);
        //System.out.println(t);
        int length = (int)(Math.log10(t)+1);
        //base = length * 10;
        base = (int) Math.ceil(length * 10);
        //System.out.println(length);
        //System.out.println(base);
        //System.out.print(t);

       // Largest place for a 32-bit integer is the 1 billion's place
       for(int place=base; place <= 100000; place += base){
           // Use counting sort at each digit's place
           input = countingSortRadix(input, place);
       }

       return input;
   }
	
    // minValue(int[]array) returns the minValue value for int[] array 
    private int minValue(int[] array){
        int minValue = array[0];  
        
        for (int i =0; i < array.length ; i++){
            if (array[i] < minValue){
                minValue = array[i]; 
                }
        }
        
        return minValue;
    }
    
    
    // maxValue(int[]array) returns the maxValue value for int[] array 
    private int maxValue(int[] array){
        int maxValue = array[0];  
        
        for (int i =0; i < array.length ; i++){
            if (array[i] > maxValue){
                maxValue = array[i]; 
                }
        }
        return maxValue;
    }
    private void print(int[] array) {
        
        for (int i = 0 ; i < array.length ; i++){
           System.out.print(array[i]+" ");
        }
        System.out.println("");
    }
    
    private int[] countingSortRadix(int[] input, int place){
        int[] out = new int[input.length];
 
        int[] count = new int[10];
 
        for(int i=0; i < input.length; i++){
            int digit = getDigit(input[i], place);
            count[digit] += 1;
        }
 
        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }
 
        for(int i = input.length-1; i >= 0; i--){
            int digit = getDigit(input[i], place);
 
            out[count[digit]-1] = input[i];
            count[digit]--;
        }
 
        return out;
 
    }
    
    private static int getDigit(int value, int digitPlace){
        return ((value/digitPlace)%10);
    }
    
    private int[] generateRandomArray (int n){
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++) {
            Random rnd = new Random();
            int value = rnd.nextInt(20000)+1;
            array [i] = value;     
            //System.out.println(array[i]);
        }
        return array;
    }
    
    private int[] copyArray(int[] array) {
        int [] copy = new int [array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
	
	public void execute(int l,int size, int base){
		long endTime = 0;
		int [] array ; int [] s = new int[size];
		int num = 20;
		int loop = l;
		
        if(loop < 9){
        	num = 100;
        }
		
        array = generateRandomArray(size);
        System.out.println("Random Array (size " + size + "):");
        //print(array);
        
        long startTime = System.nanoTime();
        s = copyArray(array);
        for(int i = 1; i <= num; i++){
        s = radixSorting(s, base);
        //System.out.println("");
        }
        endTime = (System.nanoTime() - startTime)/num;
        System.out.println("Sorted Array - Radix Sort");
        //print(s);
        System.out.println("Execution Time with base " + base + " is: " + endTime + " nanoseconds");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n,b;
    	boolean cont = true;
    	while(cont == true){
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        System.out.print("Enter a value for which to calculate for n with (2^n): ");
        n = input.nextInt();
        System.out.print("Enter a base value for radix sort: ");
        b = input.nextInt();
        int calc = (int) Math.pow(2, n); 
        System.out.println("");
        System.out.println("Array Size - "+ calc);
        System.out.println("");
        radixSort array = new radixSort();
        array.execute(n,calc,b);
        System.out.println();
    	}
	}
}