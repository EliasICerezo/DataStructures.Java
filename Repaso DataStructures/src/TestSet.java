import java.util.Iterator;

import Set.*;
import Set.Set;

public class TestSet {
	public static void main(String [] args){
		Set<Integer> s=new LinkedSet<>();
		
		s.insert(1);
		s.insert(2);
		
		
		System.out.println(s.toString());
		System.out.println(s.isEmpty());
		s.insert(3);
		s.insert(4);
		s.delete(2);
		System.out.println(s.toString());
		Iterator<Integer> it=s.iterator();
		while(it.hasNext()){
			System.out.print(it.next()+" ");
		}
		
	}
}
