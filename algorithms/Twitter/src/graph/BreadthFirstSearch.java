package graph;

import java.io.File;
import java.io.IOException;
import java.util.*; 

/**
 * This class contains the implementation of Breadth First Search
 * @author Justin Rosner and Justin Prez
 * @since 03/27/2019
 */
public class BreadthFirstSearch {
	
	private static boolean[] marked;

    /**
     * This function performs a breadth first search on the twitter user digraph
     * @param source - An integer representing the starting vertex (source of the fake news) in the graph
     * @param size - An integer representing the number of vertices (twitter users) in the graph
     * @param G - A digraph representing the twitter population
     * @param retweeted - A boolean array denoting if a given user has retweeted a fake news tweet yet
     * @param curTime - An integer representing the current time (Remember that we monitor a tweet for a day to see the impact it has)
     * @param printArray - A vector of Integers representing the twitter users that retweeted the tweet on that specific iteration
     * @param timeElapsed - An integer representing the amount of time passed from when the tweet originated from
     */
    BreadthFirstSearch(int source, int size, TwitterUserDiGraph G, boolean[] retweeted, int curTime, int timeElapsed, Vector<Integer> printArray) {
        // Mark all the vertices as not visited(By default
        // set as false)
    	marked = new boolean[size+1];
    	Arrays.fill(marked, false);

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        marked[source] = true;
        retweeted[source] = true;
        queue.add(source);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            source = queue.poll();

            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent has not been visited, then mark it
            // visited and enqueue it
            List<Integer> temp = G.getAdjacentNodes(source);
            int i = 0;

            // Every time a node is marked we also have to add it to the text file
            while (i < G.outDegree(source)) {
                int j = temp.get(i); //j is the current node in the adjacency list of source (source is currently retweeted)

                //to only consider paths retweeted we need to add
                i++;
                if (!marked[j]) {
                    marked[j] =  true;
                    if (!retweeted[j] && RandomGenerator.getChance(timeElapsed, curTime)) {	// Subject to Change
                    	retweeted[j] = true;
                    	queue.add(j);
                    	printArray.add(j);
                    }
                    else if (retweeted[j]) {
                    	queue.add(j);
                    }
                }
            }

        }
    }
    
    public boolean isMarked(int v) {
    	return marked[v];
    }
}
