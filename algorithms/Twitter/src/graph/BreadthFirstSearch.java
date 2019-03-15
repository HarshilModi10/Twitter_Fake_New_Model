package graph;
 
import java.util.*; 
  
// This class represents a directed graph using adjacency list 
// representation 
public class BreadthFirstSearch
{ 
    // prints BFS traversal from a given source s 
    public static void BFS(int s, int n, TwitterUserDiGraph G) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false)
    	boolean[] visited = new boolean[20];
    	Arrays.fill(visited, false);
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s] = true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s + " "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            List<Integer> temp = G.getAdjacentNodes(s);
            int i = 0;
            while (i < G.outDegree(s)) 
            { 
                int j = temp.get(i);
                i++;
                if (!visited[j]) 
                { 
                    visited[j] =  true; 
                    queue.add(j); 
                } 
            } 
        } 
    }
}
  
