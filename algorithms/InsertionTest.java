package graph;

import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;

/**
 * This class contains all of the methods of testing for insertion sort
 * @since 2019-04-13
 */
public class InsertionTest {
	public static List<Integer> normalList;
	public static List<Integer> normalListAnswer;
	public static List<Integer> emptyList;
	public static List<Integer> repeatedList;

	@Before
	public void setUp() throws Exception {
		// Creating a normal list to sort
		normalList = new ArrayList<Integer>();
		normalList.add(5);
		normalList.add(23);
		normalList.add(4);
		normalList.add(23);
		normalList.add(21);
		normalList.add(3);
		normalList.add(7);
		normalList.add(19);
		
		// Creating the sorted list for the normal use case
		normalListAnswer = new ArrayList<Integer>();
		normalListAnswer.add(3);
		normalListAnswer.add(4);
		normalListAnswer.add(5);
		normalListAnswer.add(7);
		normalListAnswer.add(19);
		normalListAnswer.add(21);
		normalListAnswer.add(23);
		normalListAnswer.add(23);
		
		// Creating an empty list to test
		emptyList = new ArrayList<Integer>();
		
		// Creating a list that has a lot of the numbers repeated
		repeatedList = new ArrayList<Integer>();
		repeatedList.add(5);
		repeatedList.add(5);
		repeatedList.add(5);
		repeatedList.add(5);
		repeatedList.add(5);
		repeatedList.add(2);
		repeatedList.add(2);
		repeatedList.add(2);
		repeatedList.add(2);
		repeatedList.add(2);
	
	}

	/**
	 * This method tests for the normal use case of insertion sort
	 */
	@Test
	public void testNormalUsage() {
		Insertion.sort(normalList);
		for (int i = 0; i < normalList.size() - 1; i++) {
			assertTrue(normalList.get(i) == normalListAnswer.get(i)); 
		}
	}
	
	/**
	 * This method tests to make sure that insertion sort can handle the edge case of an empty list
	 */
	@Test
	public void testEmptyList() {
		Insertion.sort(emptyList);
		List<Integer> emptyCorrect = new ArrayList<Integer>();
		for (int i = 0; i < emptyList.size() - 1; i++) {
			assertTrue(emptyList.get(i) == emptyCorrect.get(i));
		}
	}
	
	/**
	 * This method checks the case when a lot of the numbers in the list are repeated
	 */
	@Test
	public void testRepeatedEntries() {
		// Creating the correct list
		List<Integer> correct = new ArrayList<Integer>();
		correct.add(2);
		correct.add(2);
		correct.add(2);
		correct.add(2);
		correct.add(2);
		correct.add(5);
		correct.add(5);
		correct.add(5);
		correct.add(5);
		correct.add(5);
		
		for (int i = 0; i < emptyList.size() - 1; i++) {
			assertTrue(correct.get(i) == repeatedList.get(i));
		}
		
	}
	
		

}
