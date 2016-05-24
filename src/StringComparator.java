
import java.util.Comparator;
public class StringComparator implements Comparator<String>{
	
	public StringComparator() {
		// TODO Auto-generated constructor stub
	}
	

		public int compare(String eins, String zwei){
			
			if(eins.length()==zwei.length()){
				return 0;
			}
			if(eins.length()<zwei.length()){
				return -1;
			}
			else{
				return 1;
			}
			
		}

	

	

}
