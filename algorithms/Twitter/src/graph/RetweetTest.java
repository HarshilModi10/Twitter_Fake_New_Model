package graph;

import java.io.File;
import java.util.List;
import java.util.Map;

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
		
		BreadthFirstSearch.BFS(2, G.getVertices(), G);
	}
}
