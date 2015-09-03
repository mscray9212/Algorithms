import java.util.Random;
import java.util.Scanner; 


	public class Prim { 

	   public static void main(String args[]) throws Exception { 
		 boolean cont = true;
		 while(cont == true){
	     Prim n = new Prim();
	     System.out.print("Please enter desired number of vertices: ");
	     @SuppressWarnings("resource")
	     Scanner userInput = new Scanner(System.in);
	     int num = userInput.nextInt();
	     System.out.println();
	     
		 long startTime = System.nanoTime();
		 long endTime = 0;
	     n.executePrim(num);
	     endTime = (System.nanoTime()-startTime);
	     System.out.println("Total time is: " +endTime+ " nanoseconds");
	     System.out.println();
		 }
	   }
	   
	   public void executePrim(int n){
		 if(n == 0){
			 return;
		 }
		 int[][] a = generateRG(n);
		 printDouble(a);
		 Random rand = new Random();
		 int randomNum = rand.nextInt(100);
		 
	     int v, i, j, min, c, current, nv; 
	     int INF = 1000; 							// Assume maximum wt. as 1000 
	     
	     // Create graph of v vertices 
	     //System.out.print("Enter the number of vertices in the graph: "); 
	     v = n; 
	     
	     int adj[][] = new int[v+1][v+1]; 
	     for (i=1; i<=v; i++) { 
	       for (j=1; j<=v; j++) { 
	         adj[i][j] = -1; 
	       } 
	     } 
	     boolean visited[] = new boolean[v+1]; 
	     int path[] = new int[v+1]; 
	     int distance[] = new int[v+1]; 
	     
	     for (i=1; i<=v; i++) { 
	       for (j=1; j<=v; j++) { 
	         if (j==i) { 
	           adj[i][j] = 0; 
	         } else { 
	           if (adj[i][j] >= 0) { 
	             // do nothing 
	           } else { 
	             //System.out.println("If vertex " + i + " is adjacent to vertex " + j); 
	             //System.out.print("Enter weight of edge, else enter 0: "); 
	             adj[i][j] = randomNum; 
	             adj[j][i] = adj[i][j]; 
	             
	           } 
	         } 
	       } 
	     } 
	     
	     // Initializing the 3 arrays 
	     for (i=1; i<=v; i++) { 
	       visited[i] = false; 
	       path[i] = 0; 
	       distance[i] = INF; 
	     } 
	     current = 1; 
	     visited[current] = true; 
	     nv = 1; 
	     
	     while ( nv != v ) 
	     { 
	       // Processing the adjacent vertices 
	       for (i=1; i<=v; i++) 
	         if (adj[current][i] != 0) 
	           if(visited[i] != true) 
	             if(distance[i] > adj[current][i]) 
	             { 
	               distance[i] = adj[current][i]; 
	               path[i] = current ; 
	             } 

	       // Finding the closest vertex 
	       min = INF ; 
	       for (i = 1; i <= v; i++) 
	         if(visited[i] != true) 
	           if(distance[i] < min) 
	           { 
	             min = distance[i]; 
	             current = i; 
	           } 

	       visited[current] = true; 
	       nv = nv + 1; 
	     } 
	     
	     c=0; 
	     for (i=2; i<=v; i++) { 
	       c = c + distance[i]; 
	       System.out.println("Vertex " + i + " is connected to Vertex " + path[i]); 
	     } 
	     System.out.println();
	     System.out.println("Minimum cost is " + c); 
	   } 
	   
       public int[][] generateRG(int size){
       int[][] a = new int[size][size];
       
       for(int i = 0; i < size; i++){
           for(int j = 0; j < size; j++){
               if(i < j){
                   Random rand = new Random();
                   int randomNum = rand.nextInt(100);
                   if (randomNum ==0){
                       a[i][j] = 1000;
                   }
                   else a[i][j] = randomNum;
               }
               if(i==j){
                   a[i][j] = 0;
               }
               else {
                   a[j][i] = a[i][j];
               }
           }
       }
       return a;
       }
       public void printDouble(int[][] a){
           for(int i = 0; i < a.length; i++){
               for(int j = 0; j < a.length; j++){
                   System.out.print(a[i][j]+" ");
                   //System.out.print(a.length);
                   if (j == a.length-1) {
                       System.out.println("");
                   }
               }
       }
       System.out.println();
     }
	   public void printArray(int [] a) {
	        for (int i =0; i < a.length; i++){
	            System.out.print(a[i]+", ");
	        }
	    }
	} 
