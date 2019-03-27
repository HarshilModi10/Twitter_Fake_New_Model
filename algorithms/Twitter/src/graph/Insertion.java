package graph;

public class Insertion {
	
	public static void sort(Integer[] x) {
		int n = x.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0 && (x[j]).compareTo(x[j - 1]) < 0; j--)
				exchange(x, j, j - 1);
		}
	}
	
	private static void exchange(Integer[] x, Integer i, Integer j) {
		Integer temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}
}
