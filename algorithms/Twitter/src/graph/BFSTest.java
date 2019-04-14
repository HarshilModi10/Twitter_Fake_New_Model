package graph;


import static org.junit.Assert.*;
import java.io.File;
import java.util.*;
import org.junit.*;

/**
 * This class contains all of the methods of testing for BFS
 * @author Justin Rosner and Justin Prez
 * @since 2019-04-13
 */
public class BFSTest {
	public static TwitterUserDiGraph G; 
	
	@Before
	public void setUp() throws Exception {
		File in = new File("data/sample.txt");
		G = new TwitterUserDiGraph(in);
	}

	/**
	 * This test makes sure that every city connected from the source was visited/marked on a run of bfs
	 * In this example we are using the sample.txt file
	 */
	@Test
	public void testBfsMarked() {
		// Setting up variables for the BFS 
		boolean[] retweet = new boolean[G.getVertices() + 1];
		Arrays.fill(retweet, false);
		int currTime = 10;
		int timeElapsed = 1;
		Vector<Integer> arr = new Vector<Integer>();
		
		// Creating a new instance of bfs with the source being Boston
		BreadthFirstSearch bfs = new BreadthFirstSearch(1, 9, G, retweet, currTime, timeElapsed, arr);
		
		// Looping through every vertex connected to the source to make sure that it was marked
		for (int v : G.getAdjacentNodes(1)) {
			assertTrue(bfs.isMarked(v));
		}
	}

}
