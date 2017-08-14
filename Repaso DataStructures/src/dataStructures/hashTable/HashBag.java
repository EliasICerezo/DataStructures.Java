package dataStructures.hashTable;

import java.util.Iterator;

import Bag.Bag;
import dataStructures.tuple.Tuple2;

public class HashBag<K> implements Bag<K> {
	
	HashTable<K,Integer> t; 
	
	public HashBag(int tam, double maxloadFactor){
		t=new SeparateChainingHashTable<>(tam, maxloadFactor);
	}
	
	

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return t.isEmpty();
	}

	@Override
	public void insert(K el) {
		if(t.isElem(el)){
			int newtam=t.search(el)+1;
			t.insert(el, newtam);
		}else{
			t.insert(el, 1);
		}
		
	}

	@Override
	public int occurrences(K el) {
		// TODO Auto-generated method stub
		if(t.isElem(el)){
			return t.search(el);
		}else{
			return 0;
		}
	}

	@Override
	public void delete(K el) {
		t.delete(el);
		
	}
	
	@Override
	public String toString(){
		return t.toString();
	}
	
	@Override
	public Iterator<K> iterator() {
		
		return t.keys().iterator();
	}
	
	private class HashBagIterator implements Iterator<K>{
		
		
		Iterator<K> current;
		int veces;
		
		public HashBagIterator(){
			current=t.keys().iterator();
			veces=0;
		}
		
		
		@Override
		public boolean hasNext() {
			
			return current.hasNext();
		}

		@Override
		public K next() {
//			if(veces==0){
//				System.out.println("Hola");
//				current=it.iterator().next();
//				veces++;
//				return current._1();
//			}else{
//				veces++;
//				if(veces==current._2()){
//					veces=0;
//				}
//				return current._1();
//			}
			return current.next();
		}
		
	}
	
}
