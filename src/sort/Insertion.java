package sort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Class Insertion has seven methods, which are three different versions of the insertion sort algorithm and four methods for comparing the objects in the array.
 * Regular insertion sort, insertion sort using the Comparable interface, and optimized insertion sort using binary search to find the insertion point.
 * @author Bishoy Sefin
 * @version 1.0
 */

public class Insertion {
	/**
	 * regular insertion sort
	 * @param x - the input array containing processing times of jobs that need to be sorted.
	 */
	public static void sortInsert ( Job[] x ) {
		for (int i = 0; i< x.length; i++){
			for (int j = i; j>0 && less(x[j], x[j-1]); j--){
				exch(x, j, j-1);
			}
		}
	}
	
	/**
	 * returns a boolean that checks if parameter 1 is bigger than parameter 2.
	 * @param b - the first job to be compared with the next parameter.
	 * @param v - the first job to be compared with the previous parameter.
	 * @return ture is v is less than b. flase other wise.
	 */
	public static boolean less (Job b, Job v){
		return b.compareTo(v) > 0;
	}
	
	/**
	 * exchanges two elements in an array given their indecies
	 * @param a - array of type Job
	 * @param i - the first element's index.
	 * @param j - the second element's index.
	 */
	public static void exch(Job[] a, int i, int j){
		Job t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable ( Comparable[] x, int n ) {
		for (int i = 0; i< n; i++){
			for (int j = i; j>0 && lessComp(x[j], x[j-1]); j--){
				exchComp(x, j, j-1);
			}
		}
	}
	
	
	/**
	 * returns a boolean that checks if parameter 1 is bigger than parameter 2.
	 * @param b - the first Comparable to be compared with the next parameter.
	 * @param v - the first Comparable to be compared with the previous parameter.
	 * @return ture is v is less than b. flase other wise.
	 */
	public static boolean lessComp (Comparable b, Comparable v){
		return b.compareTo(v) > 0;
	}
	
	/**
	 * exchanges two elements in an array given their indecies
	 * @param a - array of type Comparable
	 * @param i - the first element's index.
	 * @param j - the second element's index.
	 */
	public static void exchComp(Comparable[] a, int i, int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	/**
	 * optimized insertion sort
	 * @param x - the input array containing times of jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary ( Comparable[] x, int n ) {
		for (int i=0;i<n;++i){
            Comparable temp=x[i];
            int left=0;
            int right=i;
            while (left<right){
                int middle=(left+right)/2;
                if (temp.compareTo(x[middle]) < 0)
                    left=middle+1;
                else
                    right=middle;
            }
            for (int j=i;j>left;--j){
                exchComp(x,j-1,j);
            }
        }
	}
	
	
}
