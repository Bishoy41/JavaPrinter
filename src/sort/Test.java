package sort;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;

import sort.Insertion;

public class Test {

	private Comparable[] input1;
	private Comparable[] input2;
	private Comparable[] input3;
	private Comparable[] input4;
	private Comparable[] input5;
	private static double[][] times = new double [5][5];
	private int location = 0;
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		Scanner sc = new Scanner(new File("data/a2_in.txt"));
		ArrayList<String> s = new ArrayList<String>();
	    while (sc.hasNext()) {
	      s.add(sc.next());
	    }
	    sc.close();
	    
	    String[] a = s.get(0).split("},");
	    
	    input1 = new Job[16];
	    for (int i = 0 ; i<a.length; i++){
	    	if (i != a.length -1){
	    		a[i] = a[i].replace("{", "");
	    	}else{
	    		a[i] = a[i].replace("{", "");
	    		a[i] = a[i].replace("}", "");
	    	}
	    	String [] temp = a[i].split(",");
	    	input1[i] = new Job(temp[0], (int) Integer.parseInt(temp[1]), (int) Integer.parseInt(temp[2]));
	    }
	    
	    a = s.get(1).split("},");
	    
	    input2 = new Job[64];
	    for (int i = 0 ; i<a.length; i++){
	    	if (i != a.length -1){
	    		a[i] = a[i].replace("{", "");
	    	}else{
	    		a[i] = a[i].replace("{", "");
	    		a[i] = a[i].replace("}", "");
	    	}
	    	String [] temp = a[i].split(",");
	    	input2[i] = new Job(temp[0], (int) Integer.parseInt(temp[1]), (int) Integer.parseInt(temp[2]));
	    }
	    
	    a = s.get(2).split("},");
	    
	    input3 = new Job[(int) Math.pow(2, 8)];
	    for (int i = 0 ; i<a.length; i++){
	    	if (i != a.length -1){
	    		a[i] = a[i].replace("{", "");
	    	}else{
	    		a[i] = a[i].replace("{", "");
	    		a[i] = a[i].replace("}", "");
	    	}
	    	String [] temp = a[i].split(",");
	    	input3[i] = new Job(temp[0], (int) Integer.parseInt(temp[1]), (int) Integer.parseInt(temp[2]));
	    }
	    
	    a = s.get(3).split("},");
	    
	    input4 = new Job[(int) Math.pow(2, 10)];
	    for (int i = 0 ; i<a.length; i++){
	    	if (i != a.length -1){
	    		a[i] = a[i].replace("{", "");
	    	}else{
	    		a[i] = a[i].replace("{", "");
	    		a[i] = a[i].replace("}", "");
	    	}
	    	String [] temp = a[i].split(",");
	    	input4[i] = new Job(temp[0], (int) Integer.parseInt(temp[1]), (int) Integer.parseInt(temp[2]));
	    }
	    
	    
	    
	    a = s.get(4).split("},");
	    
	    input5 = new Job[(int) Math.pow(2, 12)];
	    for (int i = 0 ; i<a.length; i++){
	    	if (i != a.length -1){
	    		a[i] = a[i].replace("{", "");
	    	}else{
	    		a[i] = a[i].replace("{", "");
	    		a[i] = a[i].replace("}", "");
	    	}
	    	String [] temp = a[i].split(",");
	    	input5[i] = new Job(temp[0], (int) Integer.parseInt(temp[1]), (int) Integer.parseInt(temp[2]));
	    }
	    
	  }
	

	@After
	public void tearDown() throws Exception {
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("data/a2_out.txt"))); // create a BufferedWriter Object
		String[] sorts = {"Insertion sort: ", ", Comparable Insertion Sort: ", ", Binary sort: ", ", Merge sort: ", ", Heap sort: "}; // array with names of sorting methods
		
		String s1 = "16, " + sorts[0] + times[0][0] + sorts[1] + times[1][0] + sorts[2] + times[2][0] + sorts[3] + times[3][0] + sorts[4] + times[4][0] ;
		String s2 = "64, " + sorts[0] + times[0][1] + sorts[1] + times[1][1] + sorts[2] + times[2][1] + sorts[3] + times[3][1] + sorts[4] + times[4][1] ;
		String s3 = "256, " + sorts[0] + times[0][2] + sorts[1] + times[1][2] + sorts[2] + times[2][2] + sorts[3] + times[3][2] + sorts[4] + times[4][2] ;
		String s4 = "1024, " + sorts[0] + times[0][3] + sorts[1] + times[1][3] + sorts[2] + times[2][3] + sorts[3] + times[3][3] + sorts[4] + times[4][3] ;
		String s5 = "4096, " + sorts[0] + times[0][4] + sorts[1] + times[1][4] + sorts[2] + times[2][4] + sorts[3] + times[3][4] + sorts[4] + times[4][4] ;
		out.write(s1);
		out.write("\n");
		out.write(s2);
		out.write("\n");
		out.write(s3);
		out.write("\n");
		out.write(s4);
		out.write("\n");
		out.write(s5);
		out.close();
	}

	
	@org.junit.Test
	public void testSortInsert(){
		
		Stopwatch timer1 = new Stopwatch();
		double startTime = timer1.elapsedTime();
		Insertion.sortInsert((Job[]) input1);
        double endTime1 = timer1.elapsedTime();
        times[0][0] = (endTime1 - startTime);
		assert isSorted(input1);
		
		startTime = timer1.elapsedTime();
		Insertion.sortInsert((Job[]) input2);
		endTime1 = timer1.elapsedTime();
		times[1][0] = (endTime1 - startTime);
		assert isSorted(input2);
		
		startTime = timer1.elapsedTime();
		Insertion.sortInsert((Job[]) input3);
		endTime1 = timer1.elapsedTime();
		times[2][0] = (endTime1 - startTime);
		assert isSorted(input3);
		
		startTime = timer1.elapsedTime();
		Insertion.sortInsert((Job[]) input4);
		endTime1 = timer1.elapsedTime();
		times[3][0] = (endTime1 - startTime);
		assert isSorted(input4);
		
		startTime = timer1.elapsedTime();
		Insertion.sortInsert((Job[]) input5);
		endTime1 = timer1.elapsedTime();
		times[4][0] = (endTime1 - startTime);
		assert isSorted(input5);
		
	}
	
	@org.junit.Test
	public void testSortComparable(){
		
		Stopwatch timer2 = new Stopwatch();
		double startTime = timer2.elapsedTime();
		Insertion.sortComparable(input1, input1.length);
		double endTime = timer2.elapsedTime();
		times[0][1] = (endTime - startTime);
		assert isSorted(input1);
		
		startTime = timer2.elapsedTime();
		Insertion.sortComparable(input2, input2.length);
		endTime = timer2.elapsedTime();
		times[1][1] = (endTime - startTime);
		assert isSorted(input2);
		
		startTime = timer2.elapsedTime();
		Insertion.sortComparable(input3, input3.length);
		endTime = timer2.elapsedTime();
		times[2][1] = (endTime - startTime);
		assert isSorted(input3);
		
		startTime = timer2.elapsedTime();
		Insertion.sortComparable(input4, input4.length);
		endTime = timer2.elapsedTime();
		times[3][1] = (endTime - startTime);
		assert isSorted(input4);
		
		startTime = timer2.elapsedTime();
		Insertion.sortComparable(input5, input5.length);
		endTime = timer2.elapsedTime();
		times[4][1] = (endTime - startTime);
		assert isSorted(input5);
	}
	
	@org.junit.Test
	public void testSortBinary(){
		
		Stopwatch timer3 = new Stopwatch();
		double startTime = timer3.elapsedTime();
		Insertion.sortBinary(input1, input1.length);
		double endTime = timer3.elapsedTime();
		times[0][2] = (endTime - startTime);
		assert isSorted(input1);
		
		startTime = timer3.elapsedTime();
		Insertion.sortBinary(input2, input2.length);
		endTime = timer3.elapsedTime();
		times[1][2] = (endTime - startTime);
		assert isSorted(input2);
		
		startTime = timer3.elapsedTime();
		Insertion.sortBinary(input3, input3.length);
		endTime = timer3.elapsedTime();
		times[2][2] = (endTime - startTime);
		assert isSorted(input3);
		
		startTime = timer3.elapsedTime();
		Insertion.sortBinary(input4, input4.length);
		endTime = timer3.elapsedTime();
		times[3][2] = (endTime - startTime);
		assert isSorted(input4);
		
		startTime = timer3.elapsedTime();
		Insertion.sortBinary(input5, input5.length);
		endTime = timer3.elapsedTime();
		times[4][2] = (endTime - startTime);
		assert isSorted(input5);
	}
	
	@org.junit.Test
	public void testMerge(){
		Stopwatch timer4 = new Stopwatch();
		double startTime = timer4.elapsedTime();
		Merge.sortMerge(input1, input1.length);
		double endTime = timer4.elapsedTime();
		times[0][3] = (endTime - startTime);
		assert isSorted(input1);
		
		startTime = timer4.elapsedTime();
		Merge.sortMerge(input2, input2.length);
		endTime = timer4.elapsedTime();
		times[1][3] = (endTime - startTime);
		assert isSorted(input2);
		
		startTime = timer4.elapsedTime();
		Merge.sortMerge(input3, input3.length);
		endTime = timer4.elapsedTime();
		times[2][3] = (endTime - startTime);
		assert isSorted(input3);
		
		startTime = timer4.elapsedTime();
		Merge.sortMerge(input4, input4.length);
		endTime = timer4.elapsedTime();
		times[3][3] = (endTime - startTime);
		assert isSorted(input4);
		
		startTime = timer4.elapsedTime();
		Merge.sortMerge(input5, input5.length);
		endTime = timer4.elapsedTime();
		times[4][3] = (endTime - startTime);
		assert isSorted(input5);
	}
	
	@org.junit.Test
	public void testHeap(){
		Stopwatch timer5 = new Stopwatch();
		double startTime = timer5.elapsedTime();
		Heap.sortHeap(input1, input1.length);
		double endTime = timer5.elapsedTime();
		times[0][4] = (endTime - startTime);
		assert isSorted(input1);
		
		startTime = timer5.elapsedTime();
		Heap.sortHeap(input2, input2.length);
		endTime = timer5.elapsedTime();
		times[1][4] = (endTime - startTime);
		assert isSorted(input2);
		
		startTime = timer5.elapsedTime();
		Heap.sortHeap(input3, input3.length);
		endTime = timer5.elapsedTime();
		times[2][4] = (endTime - startTime);
		assert isSorted(input3);
		
		startTime = timer5.elapsedTime();
		Heap.sortHeap(input4, input4.length);
		endTime = timer5.elapsedTime();
		times[3][4] = (endTime - startTime);
		assert isSorted(input4);
		
		startTime = timer5.elapsedTime();
		Heap.sortHeap(input5, input5.length);
		endTime = timer5.elapsedTime();
		times[4][4] = (endTime - startTime);
		assert isSorted(input5);
	}
	
	public boolean isSorted(Comparable [] x){
		for (int i = 0; i < x.length ; i++){
			if (i < x.length - 1 && x[i].compareTo(x[i+1]) < 0){
				return false;
			}
		}
		return true;
	}
	


}
