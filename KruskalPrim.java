import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class KruskalPrim {
	long startTime;
	long endTime = 0;
    static int path[];
   
    public static void main (String args[]) throws IOException {
    	boolean cont = true;
    	while(cont = true){
        KruskalPrim n = new KruskalPrim();
        System.out.print("Please enter desired number of vertices: ");
        @SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
        int num = userInput.nextInt();
        System.out.println();
        n.executeKruskal(num);
	    System.out.println();
	    
	    n.executePrim(num);
	    System.out.println();
		}
       
    } 
    
    public void executeKruskal(int n){
        int[][] a = generateRG(n);
        //printDouble(a);
        startTime = System.nanoTime();
        long endTime = 0;
        int maxEdges = ((n*(n-1))/2);
        Edge [] e = createEdge(a, maxEdges);
        //printGraph(e,max_edges);
        kruskal(e,maxEdges);
        endTime = (System.nanoTime()-startTime);
        System.out.println();
        System.out.println("Total time for Kruskal is: " +endTime+ " nanoseconds");
    }
    
    public void executePrim(int n){
    	startTime = System.nanoTime();
		if(n == 0){
			System.out.println("The returning set is empty.");
			return;
		}
		int[][] a = generateRG(n);
		//printDouble(a);
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
	     
	    while ( nv != v ) { 
	    // Processing the adjacent vertices 
	      for (i=1; i<=v; i++) 
	        if (adj[current][i] != 0) 
	          if(visited[i] != true) 
	            if(distance[i] > adj[current][i]) { 
	            	distance[i] = adj[current][i]; 
	                path[i] = current ; 
	            } 

	       // Finding the closest vertex 
	       min = INF ; 
	       for (i = 1; i <= v; i++) 
	         if(visited[i] != true) 
	           if(distance[i] < min) { 
	        	   min = distance[i]; 
	               current = i; 
	           } 

	      visited[current] = true; 
	      nv = nv + 1; 
	    } 
	     
	    c=0; 
	    for (i=2; i<=v; i++) { 
	       c = c + distance[i]; 
	       //System.out.println("Vertex " + i + " is connected to Vertex " + path[i]); 
	    } 
	    System.out.println();
	    System.out.println("Minimum cost for Prim is: " + c); 
        endTime = (System.nanoTime()-startTime);
	    System.out.println("Total time for Prim is: " +endTime+ " nanoseconds");
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
   
    public Edge[] createEdge(int [][] a, int edges){
        
        int size = a.length;
        int n = edges; 
        Edge[] e = new Edge[n];
        
        int c = 0;
        
        for (int j =0; j < size; j++) {
            for (int k = 0; k < size; k++){
                
                if (j < k){
                    e[c] = new Edge();
                    e[c].u = j;
                    e[c].v = k;
                    //System.out.print(j+" "+k);
                    e[c].wt = a[j][k];
                    //System.out.println("v1 "+e[c].u+" v2 "+e[c].v+" wt "+e[c].wt);
                    c++;
                }
            }
        } 
    return e;  
    }
         
   
    
    public void printGraph(Edge e[],int n){
        for (int i =0; i < n; i++){
           
                System.out.println("Vertice ("+e[i].u+","+e[i].v +") has weight: "+ e[i].wt);
            
        }
    }
    
    public void printArray(int [] a) {
        for (int i =0; i < a.length; i++){
            System.out.print(a[i]+", ");
        }
    }
       
    public void kruskal(Edge e[], int n){
        
        int min = 0;
        path = new int[n+1];
     
        Edge t = new Edge();
     
        // Sorting the edges in ascending order of weights
        for (int i =0; i<=n-1; i++) {
            for (int j =0; j<n-i-1; j++) {
                if (e[j].wt > e[j+1].wt) {
                    t = e[j];
                    e[j] = e[j+1];
                    e[j+1] = t;
         }
       }
     }
     
    // Initializing the path array
    for (int i = 1; i<=n; i++) {
        path[i] = 0;
    }
     
    //Edges selected in the tree
    int i = 0;
     
    //Edges selected or discarded
    int j = 0;
  
    while ((i!=n-1) && (j!=n)) {
        /*System.out.print("Edge ("
        + e[j].u + ", " + e[j].v + ") "
        + "with weight " + e[j].wt + " ");*/
        if (checkCycle(e[j])) {
            min += e[j].wt;
            i++;
            //System.out.println("is selected");
        } 
        else {
            //System.out.println("is discarded");
        }
        j++;
        //n++;
    }
    if (j!=n) {
       System.out.println("MST cannot be formed ");
    }
    System.out.println("Minimum cost for Kruskal is: " + min);
    //print_array(path);
    
    }
   
    public static boolean checkCycle(Edge e) {
        int u = e.u, v = e.v;
     
        while (path[u] > 0)
            u = path[u];
     
        while (path[v] > 0)
            v = path[v];
     
        if (u != v) {
            path[u] = v;
        return true;
        }
    return false;
    }
   
   
    static class Edge {
       int u, v, wt;
    }
}