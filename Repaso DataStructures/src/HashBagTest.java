import Bag.Bag;
import dataStructures.hashTable.HashBag;

public class HashBagTest {

	public static void main(String[] args) {
		
		Bag<Integer>bag=new HashBag<>(70,0.55);
		
		System.out.println(bag.isEmpty());
		bag.insert(1);
		bag.insert(2);
		bag.insert(3);
		bag.insert(1);
		bag.insert(2);
		System.out.println(bag.isEmpty());
		System.out.println(bag.occurrences(1));
		System.out.println(bag);
		
//		while(bag.iterator().hasNext()){
//			System.out.println(bag.iterator().next()+" ");
//		}
		
	}

}
