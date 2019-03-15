package graph;

import java.io.*;
import java.util.*;

public class TwitterUserDiGraph {

	private int V; // number of vertices in this digraph
	private int E; // number of edges in this digraph
	private Map<Integer, List<Integer>> adj; // adj[v] = adjacency list for vertex v

	public TwitterUserDiGraph(File in) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		adj = new HashMap<Integer, List<Integer>>();
		String currLine = reader.readLine();
		
		while (currLine != null) {

			String[] temp = currLine.split(" ");
			Integer node = Integer.parseInt(temp[0]);
			Integer adjNode = Integer.parseInt(temp[1]);

			if (adj.containsKey(node)) {
				if (!adj.get(node).contains(adjNode)) {
					adj.get(node).add(adjNode);
				}
			} else {
				List<Integer> tempList = new ArrayList<Integer>();
				tempList.add(adjNode);
				adj.put(node, tempList);
			}

			currLine = reader.readLine();
			E += 1;
			V = node;
		}
		reader.close();
	}

	/**
	 * Returns the number of vertices in this digraph.
	 *
	 * @return the number of vertices in this digraph
	 */
	public int getVertices() {
		return V;
	}

	/**
	 * Returns the number of edges in this digraph.
	 *
	 * @return the number of edges in this digraph
	 */
	public int getEdges() {
		return E;
	}

	public List<Integer> getAdjacentNodes(int v) {
		if (adj.containsKey(v))
			return adj.get(v);
		else if (v <= getVertices())
			return null;
		else
			throw new IllegalArgumentException("Node not defined within bounds of the Graph");
	}

	public Integer outDegree(int v) {
		if (validateVertex(v))
			return adj.get(v).size();
		else if (v <= getVertices())
			return 0;
		else
			throw new IllegalArgumentException("Node not defined within bounds of the Graph");
		
	}
	
	public boolean validateVertex(int v) {
		if (adj.containsKey(v))
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		File in = new File("sample.txt");
		TwitterUserDiGraph G = new TwitterUserDiGraph(in);
		for (Map.Entry<Integer, List<Integer>> entry : G.adj.entrySet()) {
			Integer key = entry.getKey();
			List<Integer> value = entry.getValue();
			System.out.println(key + " :    " + value);
		}
		System.out.println( "Number of Edges:     " +  G.getEdges() );
		System.out.println( "Number of Vertices:   " +  G.getVertices() );
		System.out.println(  );
		
		G.outDegree(1);
		G.outDegree(2);
		G.outDegree(3);
		G.outDegree(4);
		G.outDegree(5);
		G.outDegree(6);
		G.outDegree(7);
		G.outDegree(8);
		G.outDegree(9);
		
		BreadthFirstSearch.BFS(9, G.getVertices(), G);
	}
}