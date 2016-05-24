
package util;

import java.util.NoSuchElementException;

public class GenericListe<T> implements Cloneable{

	 /**
	    * Erster Eintrag der Liste
	    */
	   private Entry begin;
	   /**
	    * Zeiger pos;steht vor dem aktuellen Element der Liste
	    */
	   private Entry pos;

	   /**
	    * Erstellt eine neue, leere Liste
	    */
	   public GenericListe() {
	      pos = begin = new Entry();
	   }

	   /**
	    * Ist die Liste leer?
	    * 
	    * @return true, wenn keine Elemente in der Liste
	    * */
	   public boolean empty() {
	      return begin.next == null;
	   }

	   /**
	    * Sind wir am Ende der Liste?
	    * @return true, wenn Zeiger vor letztem Eintrag steht
	    **/
	   public boolean endpos() { // true, wenn am Ende
	      return pos.next == null;
	   }

	   /**
	    * geht zurueck zum ersten Element der Liste
	    */
	   public void reset() {
	      pos = begin;
	   }

	   /**
	    * Geht ein Element weiter
	    * 
	    * @throws NoSuchElementException
	    *            if the last Entry of this List already has been reached.
	    */
	   public void advance() {
	      if (endpos()) {
	         throw new NoSuchElementException("Already at the end of this List");
	      }
	      pos = pos.next;
	   }

	   /**
	    * Gibt das aktuelle Element der Liste zurueck 
	    * @return aktuelles Element
	    * 
	    * @throws NoSuchElementException
	    *            if the last Entry of this List already has been reached.
	    */
	   public T elem() {
	      if (endpos()) {
	         throw new NoSuchElementException("Already at the end of this List");
	      }
	      return (T)pos.next.o;					//gehen von Typsicherheit aus, ignorieren Warnung
	   }

	   /**
	    * Fuegt der Liste ein neues Element hinzu; dieses wird das aktuelle Element 
	    * @param x	hinzuzufuegendes Objekt
	    *           
	    */
	   public void add(T x) {
	      Entry newone = new Entry(x, pos.next);

	      pos.next = newone;
	   }

	   /**
	    * Loescht das aktuelle Element der Liste, nachfolgendes Element wird aktuelles
	    * @throws NoSuchElementException wennn das Ende der Liste erreicht wurde
	    *           
	    */
	   public void delete() {
	      if (endpos()) {
	         throw new NoSuchElementException("Already at the end of this List");
	      }
	      pos.next = pos.next.next;
	   }
	   @Override 
	   public GenericListe<T> clone(){
		 try{
		   return (GenericListe <T>) super.clone();
		 }
		 catch(CloneNotSupportedException e){
			System.out.println(""+e.getStackTrace());
			return null;
		 }
		}
}
