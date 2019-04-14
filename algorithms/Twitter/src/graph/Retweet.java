package graph;

import java.io.File;
import java.util.*;

/**
 * This class makes calls to the other classes to run bfs and print the results to the output file
 * @author Justin Rosner and Justin Prez
 * @since 03/27/2019
 */
public class Retweet {
	public static void main(String[] args) throws Exception {
		// Creating a new graph to work with 
		File in = new File("data/retweet_data.txt");
		TwitterUserDiGraph G = new TwitterUserDiGraph(in);

		// Creating an array of booleans that will determine if a certain vertex/node in the 
		// graph has been retweeted yet, not that this array does not get reinstantiated every
		// time we run bfs, there is only one copy		
		boolean[] retweet = new boolean[G.getVertices() + 1];
		Arrays.fill(retweet, false);
		
		// CurrTime is a random time of the representing when the tweet originated
		int currTime = (int)(Math.random() * 24);
		// Start represents one of the nodes in the data set, as an initial starting place
		int start = (int)(Math.random() * 456626 + 1);
		
		// This 2D vector represents the nodes that are getting retweeted every iteration
		Vector<Vector<Integer>> arr = new Vector<Vector<Integer>>();
		arr.add(new Vector<Integer>());
		// We initially add the starting node to this vertex
		arr.elementAt(0).add(2);
		
		// We have a for loop for 24 iterations, representing the 24 hours in the day
		// Every iteration (hour) we add to the vector all of the nodes that retweeted the tweet during
		// the course of that hour
		for (int i = 1; i <= 24; i++) {
			arr.add(new Vector<Integer>());
			BreadthFirstSearch bfs = new BreadthFirstSearch(start, G.getVertices(), G, retweet, currTime, i,  arr.elementAt(i));

			// Update currTime to the next hour in the day, note we use % here in case currTime goes over 24
			currTime = (currTime+1)%24;
		}
		printText.print(arr);
		
		
	}
}
