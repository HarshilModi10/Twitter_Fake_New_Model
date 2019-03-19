package graph;
 
import java.util.*; 
  
// This class represents a directed graph using adjacency list 
// representation 
public class BreadthFirstSearch { 
	
	// We need to have this look at the global list instead of initializing a new one every time.
	// Also need to add another parameter that represents the length of time of iterations
	
	
	
    // prints BFS traversal from a given source s 
    public static void BFS(int s, int n, TwitterUserDiGraph G) {
    	
        // Mark all the vertices as not visited(By default 
        // set as false)
    	boolean[] marked = new boolean[n+1];
    	Arrays.fill(marked, false);
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        marked[s] = true; 
        queue.add(s); 
  
        while (queue.size() != 0) { 
        	
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s + " "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            List<Integer> temp = G.getAdjacentNodes(s);
            int i = 0;
            // Every time a node is marked we also have to add it to the text file
            while (i < G.outDegree(s)) { 
                int j = temp.get(i);
                i++;
                if (!marked[j]) { 
                    marked[j] =  true; 
                    queue.add(j); 
                } 
            } 
        } 
    }
}
  
