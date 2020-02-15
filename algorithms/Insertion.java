package graph;

import java.util.List;

/**
 * This class contains the implementation of Insertion sort
 * @since 03/27/2019
 */
public class Insertion {

	/**
	 * This method performs the insertion sort on a List of integers by calling the exchange method
	 * @param x - A List of integers representing the vertices in the graph
	 */
	public static void sort(List<Integer> x) {
		int n = x.size();
		// Swap out of order elements in the list
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && (x.get(j)).compareTo(x.get(j-1)) < 0; j--)
				exchange(x, j, j - 1);
		}
	}

	/**
	 * This method exchanges two elements in the array
	 * @param x - A list of integers representing hvertices in the graph
	 * @param i - An integer representing the location of the first element to be switched
	 * @param j - An integer representing the location of the second element to be switched
	 */
	private static void exchange(List<Integer> x, Integer i, Integer j) {
		Integer temp = x.get(i);
		x.set(i, x.get(j));
		x.set(j, temp);
	}
}
