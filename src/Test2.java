


import util.*;
public class Test2 {

	public static void main(String[]argv){
		
		StringComparator comp=new StringComparator();
		Heap<String> heap=new Heap<String>();
		Heap<String> compHeap=new Heap<String>(comp);
		
		String eins="eins";
		String zwei="abcde";
		String drei="abc";
		String vier="abcdef";
		String[]sorted={drei, eins, zwei, vier};
		String[]test={eins, zwei, drei, vier};
		
		
		System.out.println("Comparable-Test: "+stringTest(HeapSort.heapSort(heap, test), sorted));
		
		System.out.println("Comparator-Test: "+stringTest(HeapSort.heapSort(compHeap, test),sorted));
	}
	
	static boolean stringTest(String[]a, String[]b){
		if(a.length!=b.length){
			return false;
		}
		boolean test=true;
		
		for(int i=0;i<a.length;i++){
			if(a[i]!=b[i]){
				test=false;
			}
		}
		return test;
	}

}
