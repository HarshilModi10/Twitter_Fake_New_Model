package graph;

import java.io.*;
import java.util.*;

/**
 * This class makes calls to the other classes to run bfs and print the results to the output file
 * @author Justin Rosner and Justin Prez
 * @since 03/27/2019
 */
public class TwitterUserDiGraph {

	private int V; // number of vertices in this digraph
	private int E; // number of edges in this digraph
	private Map<Integer, List<Integer>> nodeMap; // Hashmap containing the adjacency lists

	/**
	 * This method sets up the graph by reading from an input file
	 * @param in - A text file that contains all of the twitter users and the accounts that follow them
	 * @throws IOException - When there is a problem reading from the text file
	 */
	public TwitterUserDiGraph(File in) throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(in));
		nodeMap = new HashMap<Integer, List<Integer>>();
		String currLine = reader.readLine();
		
		while (currLine != null) {

			String[] temp = currLine.split(" ");
			Integer node = Integer.parseInt(temp[0]);
			Integer adjNode = Integer.parseInt(temp[1]);

			if (nodeMap.containsKey(node)) {
				// Replace contains with a binary search, need to do a insertion sort as well
				if ( !BinarySearch.Search(nodeMap.get(node), 0, nodeMap.get(node).size() - 1, adjNode) ) {
					nodeMap.get(node).add(adjNode);
					Insertion.sort(nodeMap.get(node));
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
	 * @return An integer representing the number of vertices in this digraph
	 */
	public int getVertices() {
		return V;
	}

	/**
	 * Returns the number of edges in this digraph.
	 * @return An integer representing the number of edges in this digraph
	 */
	public int getEdges() {
		return E;
	}

	/**
	 * This method returns the hashmap containing the adjacency lists of the graph
	 * @return A hashmap
	 */
	public Map<Integer, List<Integer>> getNodeMap() {
		return nodeMap;
	}

	/**
	 * This method returns a list of all the adjacent vertices to the given vertex
	 * @param v - An integer representing the given vertex
	 * @return A list of integers representing the vertices adjacent to the given vertex
	 */
	public List<Integer> getAdjacentNodes(int v) {
		if (nodeMap.containsKey(v))
			return nodeMap.get(v);
		else if (v <= getVertices())
			return null;
		else
			throw new IllegalArgumentException("Node not defined within bounds of the Graph");
	}

	/**
	 * This method returns the number of edges coming out of a given vertex
	 * @param v - An integer representing a vertex
	 * @return An integer denoting the number of edges coming out of the specified vertex
	 */
	public Integer outDegree(int v) {
		if (validateVertex(v))
			return nodeMap.get(v).size();
		else if (v <= getVertices())
			return 0;
		else
			throw new IllegalArgumentException("Node not defined within bounds of the Graph");
		
	}
	
	/**
	 * This method checks to see if a vertex is valid/is in the hashmap
	 * @param v - An integer specifying the vertex to be checked
	 * @return A boolean value denoting if the vertex is contained in the hashmap
	 */
	public boolean validateVertex(int v) {
		return nodeMap.containsKey(v);
	}

}