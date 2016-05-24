package util;

public class GenericEntry<T> {
	T o;
	Entry next;
	public GenericEntry() {
		this(null, null);
	}
	public GenericEntry(T object){
		this(object, null);
	}
	public GenericEntry(T object, Entry next){
		this.o=object;
		this.next=next;
	}
}
