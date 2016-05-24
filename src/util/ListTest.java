package util;

public class ListTest {

	public static void main(String[]argv){
		GenericListe<String> genList=new GenericListe<String>();
		
		String eins="ABC";
		String zwei="DEF";
		String drei="GHI";
		String vier="JKL";
		
		genList.add(eins);
		genList.add(zwei);
		genList.add(drei);
		genList.add(vier);
		
		GenericListe<String> genList2=genList.clone();
		System.out.println("String-Liste:");
		System.out.println("genList.clone()!=genList: "+(genList!=genList2));
		System.out.println("genList.clone().getClass == genList.getClass: "+(genList.getClass()==genList2.getClass()));
		System.out.println("genList.clone().equals(genList):"+genList2.equals(genList));
		
		
		System.out.println("int-Liste:");
		
		
		Integer i=2;
		Integer j=4;
		Integer k=8;
		
		
		GenericListe<Integer> intList=new GenericListe<Integer>();
		intList.add(j);
		intList.add(k);
		intList.add(i);
		
		
		System.out.println("intList.clone()!=intList: "+(intList.clone()!=intList));
		System.out.println("intList.clone().getClass == intList.getClass: "+(intList.clone().getClass()==intList.getClass()));
		System.out.println("intList.clone().equals(intList): "+(intList.clone().equals(intList)));
	}

}
