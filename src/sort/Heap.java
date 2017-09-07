package sort;

import java.util.Arrays;

public class Heap {
	/**
	 * heap sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortHeap ( Comparable[] x, int n ) {
        for (int k = n/2; k >= 1; k--)
            sink(x, k, n);
        while (n > 1) {
            exch(x, 1, n--);
            sink(x, 1, n);
        }
	}
	
	
	private static void sink(Comparable[] x, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(x, j, j+1)) j++;
            if (!less(x, k, j)) break;
            exch(x, k, j);
            k = j;
        }
    }
	
	/**
	 * exchanges two elements in an array given their indecies
	 * @param a - array of type Comparable
	 * @param i - the first element's index.
	 * @param j - the second element's index.
	 */
	private static void exch(Comparable[] x, int i, int j) {
        Comparable swap = x[i-1];
        x[i-1] = x[j-1];
        x[j-1] = swap;
    }
	
	/**
	 * returns a boolean that checks if parameter 1 is bigger than parameter 2.
	 * @param b - the first Comparable to be compared with the next parameter.
	 * @param v - the first Comparable to be compared with the previous parameter.
	 * @return ture is v is less than b. flase other wise.
	 */
	private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) > 0;
    }
	
}
