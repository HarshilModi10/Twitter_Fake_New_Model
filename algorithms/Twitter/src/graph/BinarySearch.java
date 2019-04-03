package graph;

import java.util.*;

/**
 * This class contains the implementation of binary search for nodes in an adjacency list
 * @author Justin Rosner and Justin Prez
 * @since 03/27/2019
 */
public class BinarySearch {

	/**
	 * This method performs a binary search on a given list
	 * @param list - An ArrayList representing the adjacency list of a given node
	 * @param left - An integer value representing the leftmost index in the sublist
	 * @param right - An integer value representing the rightmost index in the sublist
	 * @param x - An integer representing the value we are searching for
	 */
	public static boolean Search(List<Integer> list, int left, int right, int x) {
		// Creating the midpoint of the subarray
		if (right >= left) {
            int mid = left + (right - left) / 2;

            // If the middle element is the value we are looking for we can return true right away
            if (list.get(mid) == x)
                return true; 

            // If the given element is smaller then the mid point then we can recursively call
            // binary search on the first half of the array
            if (list.get(mid) > x)
                return Search(list, left, mid - 1, x);

            // If the element is in the right half of the array then we perform a binary search on that half
            return Search(list, mid + 1, right, x);
        }

        // We only get to this point when the element is not in the given array
        return false;
	}
}
