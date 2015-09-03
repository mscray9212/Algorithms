
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Package imports 
import java.util.Random;
import java.util.Scanner;



/**
 * @author AndresBurden
 */

public class Sorting {


    
    // countSort(int[] array,int maxValue,int minValue) sorts int[] array by using counting sort method
    // A(n)
    private void countSort(int[] array,int maxValue,int minValue){
        
        int [] count = new int[(maxValue-minValue) + 1];
        int current = 0;
        
        for (int i : array){
            count [i - minValue]++;
        }
    
        for (int j = minValue; j <= maxValue ; j++){
            while (count[j-minValue]>0){
                array[current] = j;
                current++;
                count[j-minValue] = count[j-minValue] -1;
            }
        } 
    }
    
    // insertionSort(int[] array) sorts int[] array by using insertion sort method
    // A(n^2)
    private void insertionSort(int[] array) {
         
        for (int i = 1; i < array.length; i++){
            int value = array[i];
            
            int j = i;
            
            while ( j > 0 && array [j-1] > value){
                array [j] = array[j-1];
                j--;
            }
            array[j] = value;   
        }
    }
    
    // standard quicksort algorithm 
    private void quickSort(int[]array, int lowIndex, int highIndex){
        int index = partition(array,lowIndex,highIndex);
        
        if(lowIndex<index-1){
            quickSort(array,lowIndex,index-1);
        }
        else if (highIndex>index){
            quickSort(array,index,highIndex);
        }
    }
    
    
    private void randomQuickSort(int[]array, int lowIndex, int highIndex){

        int index = randomPartition(array,lowIndex,highIndex);
        
        if(lowIndex<index-1){
            quickSort(array,lowIndex,index-1);
        }
        if (highIndex>index){
            quickSort(array,index,highIndex);
        }
    }
    
    public void recQuickSort(int[] array, int lowIndex, int highIndex) {
       
        int index = medianOfThree(array,lowIndex,highIndex);
     
        if(lowIndex<index-1){
            quickSort(array,lowIndex,index-1);
        }
        if (highIndex>index){
            quickSort(array,index,highIndex);
        }
    }

    
    private int partition(int array[], int lowIndex, int highIndex){
         int pivot = array[lowIndex]; // taking first element as pivot

        while (lowIndex <= highIndex) {
            //searching number which is greater than pivot, bottom up
            while (array[lowIndex] < pivot) {
                lowIndex++;
            }
            //searching number which is less than pivot, top down
            while (array[highIndex] > pivot) {
                highIndex--;
            }

            // swap the values
            if (lowIndex <= highIndex) {
                int tmp = array[lowIndex];
                array[lowIndex] = array[highIndex];
                array[highIndex] = tmp;

                //increment lowIndex index and decrement highIndex index
                lowIndex++;
                highIndex--;
            }
        }
        return lowIndex;
    }
    
    private int medianOfThree(int array[], int lowIndex, int highIndex){
        int middle = (lowIndex + highIndex) / 2; // taking first element as pivot
        
        if(array[middle] < array[lowIndex]){
            swap(array, lowIndex, middle);
        }
        if(array[highIndex] < array[lowIndex]){
            swap(array, lowIndex, highIndex);
        }   
        if(array[highIndex] < array[middle]){
            swap(array, highIndex, middle);
        }   
        
        swap(array, middle, highIndex - 1);
        return partition(array,lowIndex,highIndex);
    }

    
    private int randomPartition(int[] array, int lowIndex, int highIndex){
        
        //Random rnd = new Random();
        //int rnNumber = rnd.nextInt((highIndex-lowIndex)+1)+lowIndex;
        int rnNumber = array.length /2;
        //System.out.println(array[rnNumber]);
  
        swap(array,highIndex,rnNumber);
        //System.out.println(array[highIndex]);
        return partition(array,lowIndex,highIndex);
    }
    
    
    private void quickSortPartTwo(int[] array, int lowerindex, int higherindex) {
        if(lowerindex<higherindex){

            int pivotIndex = lowerindex;
            int i=pivotIndex+1;
            int j=i;

            while(j<=higherindex){
		if(array[j]<array[pivotIndex]){
                    swap(array, i, j);
			i++;
			j++;
		}
                else {
                    j++;
		}
            }
            swap(array, pivotIndex, i-1);
            quickSortPartTwo(array, pivotIndex, i-1);
            quickSortPartTwo(array,i, higherindex);
	}
    }
    
    private void swap(int[]array , int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
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
    
    
    // generateRandomArray (int n) generates array random array of size n
    private int[] generateRandomArray (int n){
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++) {
            Random rnd = new Random();
            int value = rnd.nextInt(10000)+1;
            array [i] = value;     
            //System.out.println(array[i]);
        }
        return array;
    }
 
    
    // print(int[] array) pritns int[] array sequentially
    private void print(int[] array) {
    
        for (int i = 0 ; i < array.length ; i++){
           System.out.print(array[i]+" ");
        }
        System.out.println("");
    }
    

    // copyArray(int[] array) generates array copy of array int[] array
    private int[] copyArray(int[] array) {
        int [] copy = new int [array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }
    
    
    private void execute(int a, int number){
        
        int num = 20;
        int loop = number;

        // declares int [] array and s1,s2,s3 
        int [] array ;
        int [] s1 = null; int [] s2 = null; int [] s3 = null; 
        int [] s4 = null; int [] s5 = null; int [] s6 = null;
        long countSortTime = 0;
        long quickSort = 0;
        long randomQuickSort = 0;
        long partIIQuickSort = 0;
        long medianOfThree = 0;
        long insertionSort = 0;
        
        if(loop < 9){
        	num = 100;
        }
        System.out.println();
        System.out.println("Number of loops: " + num);
        System.out.println("Array size: (" + a + ")");
        System.out.println();
        for(int i=0;i<num;i++){
        array = generateRandomArray(a);
        //System.out.println();
        //System.out.println("Random Array (size " + a + "):");
        //print(array);
        
        long startTime = System.nanoTime();
        s1 = copyArray(array);

        insertionSort(s1);

        insertionSort += (System.nanoTime() - startTime);
        //System.out.println("");
        //System.out.println("Sorted Array - Insertion Sort:");
        //print(s1);
        //System.out.println("Execution Time: "+ endTime +" nanoseconds");
        
        startTime = System.nanoTime();
        s2 = copyArray(array);
        int maxValue = maxValue(s2);
        int minValue = minValue(s2);

        countSort(s2,maxValue,minValue);
        countSortTime += (System.nanoTime() - startTime);
        //System.out.println("");
        //System.out.println("Sorted Array - Counting Sort:");
        //print(s2);
        //System.out.println("Execution Time: " + endTime + " nanoseconds");
        
        startTime = System.nanoTime();
        s3 = copyArray(array);

        quickSort(s3,0,s3.length-1);
        quickSort += (System.nanoTime() - startTime);
        //System.out.println("");
        //System.out.println("Sorted Array - Quick Sort (Partition I):");
        //print(s3);
        //System.out.println("Execution Time: "+ endTime +" nanoseconds");
        
        startTime = System.nanoTime();

        s4 = copyArray(array);

        randomQuickSort(s4,0,s4.length-1);
        randomQuickSort += (System.nanoTime() - startTime);
        //System.out.println("");
        //System.out.println("Sorted Array - Randomized Quick Sort");
        //print(s4);
        //System.out.println("Execution Time: "+ endTime +" nanoseconds");
        
        startTime = System.nanoTime();

        s5 = copyArray(array);

        quickSortPartTwo(s5,0,s5.length-1);
        partIIQuickSort += (System.nanoTime() - startTime);
        //System.out.println("");
        //System.out.println("Sorted Array - Quicksort Partition II");
        //print(s5);
        //System.out.println("Execution Time: "+ endTime +" nanoseconds");
    

        s6 = copyArray(array);

        recQuickSort(s6,0,s6.length-1);
        medianOfThree += (System.nanoTime() - startTime);
        //System.out.println("");
        //System.out.println("Sorted Array - Quicksort Median of Three");
        //print(s6);
        //System.out.println("Execution Time: "+ endTime +" nanoseconds");
        }
        
        System.out.println("Insertion Sort: "+insertionSort/num);
        System.out.println("");
        System.out.println("Counting Sort: "+countSortTime/num);
        System.out.println("");
        System.out.println("Pure Quick Sort: "+quickSort/num);
        System.out.println("");
        System.out.println("Random Quick Sort: "+randomQuickSort/num);
        System.out.println("");
        System.out.println("Partition II Quick Sort: "+partIIQuickSort/num);
        System.out.println("");
        System.out.println("Median of Three Quick Sort: "+medianOfThree/num);
    
    }
    
    
/*    public static void main(String[] args) {
 
        Sorting array = new Sorting();
        array.execute(2000);
    }
    
}*/
    
    
    public static void main(String[] args) {
    	boolean cont = true;
    	while(cont == true){
        Sorting a = new Sorting();
        System.out.print("Enter a value for which to calculate for n with (2^n): ");
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        while(!(input.hasNextInt())){
        	System.out.print("Please enter an integer value: ");
        	input = new Scanner(System.in);
        }
        int n = input.nextInt();
        int calc = (int) Math.pow(2, n);
        a.execute(calc, n);

    	}
    	}
    
}