package graph;

import java.io.*;
import java.util.*;

public class printText {
	
	public static void print(Vector<Vector<Integer>> arr) throws IOException {
		File out = new File("data/output.txt");
		BufferedWriter writer = new BufferedWriter(new FileWriter (out));
		for (int i = 0; i < 24; i++ ) {
			String temp = String.valueOf(arr.elementAt(i));
			writer.write(temp.substring(1, temp.indexOf("]")));
			writer.newLine();
		}
		writer.close();
		
	}
}
