import java.util.Iterator;

import BitSet.BitSet;
import BitSet.BitSetImpl;

public class BitSetTest {
	public static void main(String []args){
		BitSet p=new BitSetImpl(3);
		BitSet q=new BitSetImpl(5);
		int[] is={1,2,4,3,5,67,32,12,31};
		q.insertAll(is);
		p.insert(1);
		p.insert(2);
		p.insert(5);
		p.insert(20);
		p.insert(18);
		p.delete(18);
		//System.out.println(p.size());
		System.out.println(p);
		System.out.println(q);
		Iterator<Integer> it=p.iterator();
//		while(it.hasNext()){
//			System.out.print(it.next()+" ");
//		}
		p.insert(25);
		//System.out.println("\n"+p.len());
		
		System.out.println("Union:"+p.union(q));
		System.out.println("Diferencia:"+p.difference(q));
		System.out.println("Interseccion:"+p.intersection(q));
		
	}
}
