package graph;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;

/**
 * This class contains all of the methods of testing for insertion sort
 * @since 2019-04-13
 */
public class BinarySearchTest {
	public static List<Integer> normalList;
	
	@Before
	public void setUp() throws Exception {
		// Creating a list that works with the normal usage
		normalList = new ArrayList<Integer>();
		normalList.add(2);
		normalList.add(3);
		normalList.add(4);
		normalList.add(5);
		normalList.add(6);
		normalList.add(7);
		normalList.add(8);
		normalList.add(9);
		normalList.add(21);
		normalList.add(45);
	}

	/**
	 * This method tests for the normal use case for binary search
	 */
	@Test
	public void testNormalBinarySearch() {
		assertTrue(BinarySearch.Search(normalList, 0, normalList.size() - 1, 5));
		assertTrue(BinarySearch.Search(normalList, 0, normalList.size() - 1, 7));
		assertTrue(BinarySearch.Search(normalList, 0, normalList.size() - 1, 9));
		assertTrue(BinarySearch.Search(normalList, 0, normalList.size() - 1, 3));
		assertTrue(BinarySearch.Search(normalList, 0, normalList.size() - 1, 2));
		assertTrue(BinarySearch.Search(normalList, 0, normalList.size() - 1, 21));
		assertTrue(!BinarySearch.Search(normalList, 0, normalList.size() - 1, 77));
		
	}

}
