import java.util.Iterator;

import Bag.ArrayBag;
import Bag.Bag;


public class TestBag {
	public static void main(String[] args){
		Bag<Integer> a=new ArrayBag<>();
		
		a.insert(1);
		a.insert(2);
		a.insert(1);
		a.insert(4);
		a.insert(3);
		a.insert(10);
		a.insert(7);
		System.out.println(a.toString());
		System.out.println(a.occurrences(1));
//		a.delete(1);
//		a.delete(1);
		System.out.println(a.toString());
		//System.out.println(it.hasNext());
		Iterator<Integer> it=a.iterator();
		while(it.hasNext()){
			
			System.out.print(it.next()+" ");
		}
		//System.out.println(it.hasNext());
		
	}
	
}
