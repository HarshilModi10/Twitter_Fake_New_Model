package graph;

import java.io.*;
import java.util.*;

/**
 * This class contains the method required to output the retweeted vertices(twitter users) to the output file
 * @since 03/27/2019
 */
public class printText {
	
	/**
	 * This method prints the retweeted twitter users to an output file
	 * @param arr - A 2D vector, where each sub vector of integers represents the users who retweeted the tweet in a given time frame
	 * @throws IOException - When there is an error writing to the text file
	 */
	public static void print(Vector<Vector<Integer>> arr) throws IOException {
		File out = new File("data/output.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter (out));
		// 24 represents the 24 hours that we are tracking the tweet for
		for (int i = 0; i < 24; i++ ) {
			String temp = String.valueOf(arr.elementAt(i));
			writer.write(temp.substring(1, temp.indexOf("]")));
			writer.newLine();
		}
		writer.close();
		
	}
}
