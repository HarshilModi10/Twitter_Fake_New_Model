package graph;

import java.io.*;
import java.util.*;

public class TwitterUserDiGraph {

	private int V; // number of vertices in this digraph
	private int E; // number of edges in this digraph
	private Map<Integer, List<Integer>> nodeMap; 
	// Need to add list of visited/retweeted nodes as a global variable
	// Add accessor methods to modify that list

	public TwitterUserDiGraph(File in) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		nodeMap = new HashMap<Integer, List<Integer>>();
		String currLine = reader.readLine();
		
		while (currLine != null) {

			String[] temp = currLine.split(" ");
			Integer node = Integer.parseInt(temp[0]);
			Integer adjNode = Integer.parseInt(temp[1]);

			if (nodeMap.containsKey(node)) {
				if (!nodeMap.get(node).contains(adjNode)) {
					nodeMap.get(node).add(adjNode);
				}
			} else {
				List<Integer> tempList = new ArrayList<Integer>();
				tempList.add(adjNode);
				nodeMap.put(node, tempList);
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
	
	public Map<Integer, List<Integer>> getNodeMap() {
		return nodeMap;
	}

	public List<Integer> getAdjacentNodes(int v) {
		if (nodeMap.containsKey(v))
			return nodeMap.get(v);
		else if (v <= getVertices())
			return null;
		else
			throw new IllegalArgumentException("Node not defined within bounds of the Graph");
	}

	public Integer outDegree(int v) {
		if (validateVertex(v))
			return nodeMap.get(v).size();
		else if (v <= getVertices())
			return 0;
		else
			throw new IllegalArgumentException("Node not defined within bounds of the Graph");
		
	}
	
	public boolean validateVertex(int v) {
		if (nodeMap.containsKey(v))
			return true;
		else
			return false;
	}

}