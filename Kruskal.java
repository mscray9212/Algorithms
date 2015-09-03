import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Kruskal {

    static int path[];
    //static int n, m, mincost, i, j;
   
    public static void main (String args[]) throws IOException {
    	boolean cont = true;
    	while(cont = true){
        Kruskal n = new Kruskal();
        System.out.print("Please enter desired number of vertices: ");
        @SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
        int num = userInput.nextInt();
        System.out.println();
        n.executeKruskal(num);
    	}
       
    } 
    
    public void executeKruskal(int n){
        int[][] a = generate_random_graph(n);
        print_double_array(a);
        long startTime = System.nanoTime();
        long endTime = 0;
        int max_edges = ((n*(n-1))/2);
        Edge [] e = create_edge_graph(a, max_edges);
        print_graph(e,max_edges);
        kruskal(e,max_edges);
        endTime = (System.nanoTime()-startTime);
        System.out.println();
        System.out.println("Total time is: " +endTime+ " nanoseconds");
    }
    
    public void print_double_array(int[][] a){
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
    
    
        public int[][] generate_random_graph(int size){
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
   
    public Edge[] create_edge_graph(int [][] a, int max_edges){
        
        int size = a.length;
        int n = max_edges; 
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
                    System.out.println("v1 "+e[c].u+" v2 "+e[c].v+" wt "+e[c].wt);
                    c++;
                }
                //System.out.println("v1 "+e[c].u+" v2 "+e[c].v+" wt "+e[c].wt);
                //c++;
            }
        } 
    return e;  
    }
         
   
    
    public void print_graph(Edge e[],int n){
        for (int i =0; i < n; i++){
           
                System.out.println("Vertice ("+e[i].u+","+e[i].v +") has weight: "+ e[i].wt);
            
        }
    }
    
    public void print_array(int [] a) {
        for (int i =0; i < a.length; i++){
            System.out.print(a[i]+", ");
        }
    }
       
    public void kruskal(Edge e[], int n){
        
        //int path[];
        int mincost = 0;
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
     
    // Counts the number of edges selected in the tree
    int i = 0;
     
    // Counts the number of edges selected or discarded
    int j = 0;
  
    System.out.println();
    while ((i!=n-1) && (j!=n)) {
        System.out.print("Edge ("
        + e[j].u + ", " + e[j].v + ") "
        + "with weight " + e[j].wt + " ");
        if (checkCycle(e[j])) {
            mincost = mincost + e[j].wt;
            i++;
            System.out.println("is selected");
        } else {
            System.out.println("is discarded");
        }
        j++;
        //n++;
    }
    //System.out.print(i+"j"+j+" "+n);
    if (j!=n) {
       System.out.println("MST cannot be formed.");
    }
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