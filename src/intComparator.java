

import java.util.Comparator;
public class intComparator implements Comparator<Integer>{

	public intComparator() {
	
	}
	public int compare(Integer eins, Integer zwei){
		return eins.compareTo(zwei);
	}
}
