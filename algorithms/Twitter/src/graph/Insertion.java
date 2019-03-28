package graph;

import java.util.List;

public class Insertion {
	
	public static void sort(List<Integer> x) {
		int n = x.size();
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && (x.get(j)).compareTo(x.get(j-1)) < 0; j--)
				exchange(x, j, j - 1);
		}
	}
	
	private static void exchange(List<Integer> x, Integer i, Integer j) {
		Integer temp = x.get(i);
		x.set(i, x.get(j));
		x.set(j, temp);
	}
}
