package sort;

import java.util.Arrays;

public class Merge {
	/**
	 * merge sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMerge ( Comparable[] x, int n ) {
		Comparable[] aux = new Comparable[x.length];
        sort(x, aux, 0, x.length-1);
	}
	
	/**
	 * @param x - Comparable that is getting sorted
	 * @param aux - Coppied memory array
	 * @param lo - integer low
	 * @param hi - integer high
	 */
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }
	
	/**
	 * @param x - Comparable that is getting sorted
	 * @param aux - Coppied memory array
	 * @param low - integer low
	 * @param mid - integer middle
	 * @param hi - integer high
	 */
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
       
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
	}
	
	/**
	 * returns a boolean that checks if parameter 1 is bigger than parameter 2.
	 * @param b - the first Comparable to be compared with the next parameter.
	 * @param v - the first Comparable to be compared with the previous parameter.
	 * @return ture is v is less than b. flase other wise.
	 */
	private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }
	
	
	
}
