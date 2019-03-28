package graph;

import java.io.File;
import java.util.*;

public class RetweetTest {
	public static void main(String[] args) throws Exception {
		File in = new File("sample.txt");
		TwitterUserDiGraph G = new TwitterUserDiGraph(in);
		for (Map.Entry<Integer, List<Integer>> entry : G.getNodeMap().entrySet()) {
			Integer key = entry.getKey();
			List<Integer> value = entry.getValue();
			System.out.println(key + " :    " + value);
		}
		System.out.println( "Number of Edges:     " +  G.getEdges() );
		System.out.println( "Number of Vertices:   " +  G.getVertices() );
		System.out.println();
		
		G.outDegree(1);
		G.outDegree(2);
		G.outDegree(3);
		G.outDegree(4);
		G.outDegree(5);
		G.outDegree(6);
		G.outDegree(7);
		G.outDegree(8);
		G.outDegree(9);
		
		List<Integer> tempList = new ArrayList<Integer>();
		
		tempList.add(0);
		tempList.add(1);
		tempList.add(2);
		tempList.add(3);
		tempList.add(4);
		tempList.add(5);
		tempList.add(6);
		tempList.add(7);
		tempList.add(8);
		boolean temp = BinarySearch.Search(tempList, 0, 8, 4);
		System.out.println(temp);
		// Will put this in a for loop for each iteration

		
		boolean[] retweet = new boolean[G.getVertices()];
		Arrays.fill(retweet, false);
		int currTime = 10;
		for (int i = 0; i < 24; i++) {
			BreadthFirstSearch.BFS(2, G.getVertices(), G, retweet, currTime);
			currTime++;
		}
		
		
	}
}
