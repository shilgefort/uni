

import	util.*;
public class Test {

	public static void main(String[]argv){
		
		Heap<Integer> heap=new Heap<Integer>();
		
		intComparator comp=new intComparator();
		
		Heap<Integer> compHeap=new Heap<Integer>(comp);
		boolean test=true;
		
		Integer[]a={1, 8, 4, 16, 2};
		Integer[]aSorted={1, 2, 4, 8, 16};
		//Comparable-Heap
		Integer[]b=HeapSort.heapSort(heap, a);
		//Comparator-Heap
		Integer[]c=HeapSort.heapSort(compHeap, a);
		
		
		for (int j=0;j<aSorted.length;j++){
			if(aSorted[j]!=c[j]){
				test=false;
			System.out.println(""+c[j]);
			}
		}
		System.out.println("Test fuer Heap mit Comparator: "+test);
		
		
		test=true;
		
		for(int k=0; k<aSorted.length;k++){
			if(aSorted[k]!=b[k]){
				test=false;
				
			}
		}
		System.out.println("Test fuer Heap mit Comparables: "+test);
		
		
		
		
		
		
	}
}
