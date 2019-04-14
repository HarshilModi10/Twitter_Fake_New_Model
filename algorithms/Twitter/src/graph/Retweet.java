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
		File in = new File("data/retweet_data.txt");
		TwitterUserDiGraph G = new TwitterUserDiGraph(in);
		for (Map.Entry<Integer, List<Integer>> entry : G.getNodeMap().entrySet()) {
			Integer key = entry.getKey();
			List<Integer> value = entry.getValue();
		}

		
		boolean[] retweet = new boolean[G.getVertices() + 1];
		Arrays.fill(retweet, false);
		
		int currTime = (int)(Math.random() * 24);
		int start = (int)(Math.random() * 456626 + 1);
		
		
		Vector<Vector<Integer>> arr = new Vector<Vector<Integer>>();
		arr.add(new Vector<Integer>());
		arr.elementAt(0).add(2);
		
		
		for (int i = 1; i <= 24; i++) {
			arr.add(new Vector<Integer>());
			BreadthFirstSearch bfs = new BreadthFirstSearch(start, G.getVertices(), G, retweet, currTime, i,  arr.elementAt(i));
			currTime = (currTime+1)%24;
		}
		printText.print(arr);
		
		
	}
}
