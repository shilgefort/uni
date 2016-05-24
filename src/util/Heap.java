package util;
import java.util.*;

public class Heap<T>{

	private Object[]heap;
	private int counter;
	private Comparator<T> comp;
	
	public Heap(){
		int counter=0;
		heap=new Object[0];
	}
	public Heap(Comparator<T> comp){
		this();
		this.comp=comp;
	}
	/**
	 * gibt den kleinsten Schlüssel im Heap zurueck
	 * @return
	 */
	Object getMin(){
		if(empty()){
			return null;
		}
		else{
			return  heap[0];
		}
	}
	/**
	 * gibt an, ob der Heap leer ist oder nicht
	 * @return	boolean  true, wenn leer; false falls nicht
	 */
	public boolean empty(){
		return counter==0;
	}
	/**
	 * legt ein neues Array an, das die Inhalte aus dem alten Array kopiert und um eine Stelle verlaengert wird
	 */
	private void arrayErweitern(){
		if(counter >= heap.length){			
			heap = Arrays.copyOf(heap, heap.length + 1);
		}
	}
	/**
	 * loescht das erste Element aus dem Heap und gibt es zurueck
	 * @return	geloeschtes Element
	 */
	public T deleteFirst(){
		if(empty()){
			return null;
		}
		else{
		counter--;
		Object temp = (Object) heap[0];
		heap[0]=null;
		siftDown(0);
		return (T)temp;
		}
	}
	/**
	 * fuegt dem Heap ein neues Element hinzu
	 * @param o hinzuzufuegendes Element
	 * @throws NullPointerException, wenn uebergebenes Objekt leer ist
	 */
	public void insert(Object o){
		if(o==null){
			throw new NullPointerException("Objekt darf nicht null sein");
		}
		//Zaehler erhoehen, Array verlaengern
		counter++;
		arrayErweitern();
		
		if(counter<=1){
			heap[0]=o;
		}
		else{
			heap[heap.length-1]=o;
			siftUp(o, counter--);
		}
	}
	/**
	 * stellt die Heap-Bedingungen wieder her, nachdem ein Element hinzugefuegt wurde
	 * @param pos  aktuelle Position des Elements
	 */
	private void siftUp(Object o, int pos){
		
		if(comp!=null){
			compSiftUp(o, pos);
		}
		else{
			comparableSiftUp(o, pos);
		}
		
	}
	/**
	 * COMPARATOR-HEAP
	 * stellt die Heap-Bedingungen wieder her, nachdem ein Element hinzugefuegt wurde
	 * @param o
	 * @param pos
	 */
	private void compSiftUp(Object o, int pos){
		//vorrausgesetzt, wir sind nicht an der Wurzel
		if(pos!=0){
		//Ermittle Vaterknoten	
			int posVater=getVater(pos);
		//Wenn Schluessel groesser als Vaterknoten, 
			if(comp.compare((T)o, (T)heap[posVater])>=0){				//Unsicherer Type-Cast; ignoriert, da wir von Typsicherheit ausgehen
				  Object tmp = heap[posVater];
                  heap[posVater] = o;
                  heap[counter] = tmp;
                  siftUp(o ,posVater);
			}
		}
	}
	/**
	 * COMPARABLE-HEAP
	 * stellt die Heap-Bedingungen wieder her, nachdem ein Element hinzugefuegt wurde
	 * @param o
	 * @param pos
	 */
	private void comparableSiftUp(Object o, int pos){
		
		int posVater=getVater(pos);
		Comparable <T> hilf2=(Comparable <T>)heap[posVater];			//Unsicherer Type-Cast; ignoriert, da wir von Typsicherheit ausgehen
		if(pos!=0){
			
			if(((Comparable<T>) o).compareTo((T) hilf2)<=0){			//Unsicherer Type-Cast; ignoriert, da wir von Typsicherheit ausgehen
				  Object tmp = heap[posVater];
                  heap[posVater] = o;
                  heap[counter] = tmp;
                  siftUp(o ,posVater);
			}
		}
	}
	/**
	 * stellt die Heap-Bedingungen wieder her, nachdem ein Element geloescht wurde
	 * @param pos Position, an der geloescht wurde(in der Regel [0])
	 */
	private void siftDown(int pos){
		//siftDown fuer Comparator-Heap
		if(comp!=null){
			compSiftDown(pos);
		}
		else{
		//siftDown fuer Comparable-Heap
			comparableSiftDown(pos);
		}
	}
	/**
	 * COMPARATOR-HEAP
	 * stellt die Heap-Bedingungen wieder her, nachdem ein Element geloescht wurde
	 * @param pos Position, an der geloescht wurde(in der Regel [0])
	 */
	private void compSiftDown(int pos){
		if(comp!=null){
			
			int left=2*pos+1;
			int right=2*pos+2;
			//Gibt es rechten Sohn?
			if (right >= heap.length) {
            //Gibt es linken Sohn?
				 if (left >= heap.length){
            //Falls weder linker noch rechter Sohn, tue nichts 	      
                       return;
                 }      
                 else{
            //Falls nur linker Sohn, setze ihn in die Wurzel
                	 heap[0] = left;
                 }      
           }
		    //Falls rechter Sohn
		   else {
			//Wenn linker Sohn kleiner oder gleich rechter Sohn
                 if (comp.compare((T)heap[left] , (T)heap[right])<=0){		//Unsicherer Type-Cast; ignoriert, da wir von Typsicherheit ausgehen
                      heap[0] = left;
                 }      
            //Falls rechter Sohn kleiner
                 else
                       heap[0] = right;
           }
			//Wenn Objekt kleiner als Wurzel
           if (comp.compare((T)heap[pos], (T) heap[0])<0) {					//Unsicherer Type-Cast; ignoriert, da wir von Typsicherheit ausgehen
            //speichere Wurzel 
        	   	 Object tmp = heap[0];
        	//Setze neues Objekt in Wurzel   	 
                 heap[0] = heap[pos];
            //Setze Wurzel an letzte Stelle
                 heap[pos] = tmp;
            //Stelle Heap-Bedingungen wieder her     
                 compSiftDown(0);
           }
     }
   }
	/**
	 * COMPARABLE-HEAP
	 * stellt die Heap-Bedingungen wieder her, nachdem ein Element geloescht wurde
	 * @param pos Position, an der geloescht wurde(in der Regel [0])
	 */
   private void comparableSiftDown(int pos){
		if(comp==null){
			//Berechne Soehne
			int left=2*pos+1;
			int right=2*pos+2;
		   //Wenn rechter Sohn ausserhalb des Arrays
			if (right >= heap.length) {
		   //Und linker Sohn ausserhalb des Arrays	
                 if (left >= heap.length)
           //Tue nichts
                	 return;
                 else{
           //Falls linker Sohn, mache ihn zur neuen Wurzel     	 
                	 	heap[0] = left;
                 }	 	
            } 
			else {
			//Anlegen von Comparables, wenn sowohl linker als auch rechter Sohn	
        	   	 Comparable<T> help=(Comparable <T>)heap[left];				//Unsicherer Type-Cast; ignoriert, da wir von Typsicherheit ausgehen
        	   	 Comparable<T> help2=(Comparable <T>)heap[right];			//Unsicherer Type-Cast; ignoriert, da wir von Typsicherheit ausgehen
        	//Wenn linker Sohn kleiner als rechter Sohn
        	   	 if (help.compareTo((T) help2)<=0){							//Unsicherer Type-Cast; ignoriert, da wir von Typsicherheit ausgehen
            //Mache links zur Wurzel   
        	   		   heap[0] = left;
                 }      
                 else
            //Andernfalls mache den rechten Sohn zur Wurzel    	 
                       heap[0] = right;
           }
		   //Wenn Wurzel da, tausche	 
		   if (heap[0]!=null && (((Comparable<T>) heap[pos]).compareTo((T) heap[0])<0)) {	//Unsicherer Type-Cast; ignoriert, da wir von Typsicherheit ausgehen
                
        	   	 Object tmp = heap[0];
                 heap[0] = heap[pos];
                 heap[pos] = tmp;
			 }
		   }
		
		}
   	
	/**
	 * liefert Position des Vaterknotens
	 * @param pos	Position, zu der der Vaterknoten gesucht wird
	 * @return	Position des Vaterknotens
	 */
	private int getVater(int pos){
		return (pos-1)/2;
	}

	}

