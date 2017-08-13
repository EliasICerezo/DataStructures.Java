package dataStructures.hashTable;

import java.util.Iterator;
import java.util.List;

import dataStructures.list.ArrayList;
import dataStructures.tuple.Tuple2;

public class SeparateAlternativeChainingHT<K, V> implements HashTable<K, V> {

	private List<Tuple2<K, V>> table[];

	private int size;

	private double maxLoadFactor;

	@SuppressWarnings("unchecked")
	public SeparateAlternativeChainingHT(int ncel, double mlf) {
		table= (List <Tuple2<K,V>>[])  new List[ncel];
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void insert(K k, V v) {
		int pos = k.hashCode() % table.length;
		Tuple2<K, V> aux = new Tuple2<>(k, v);
		table[pos].add(aux);
		size++;

	}

	@Override
	public V search(K k) {
		int pos = k.hashCode() % table.length;

		if (table[pos].indexOf(k) == -1) {
			return null;
		} else {
			return table[pos].get(table[pos].indexOf(k))._2();
		}

	}

	@Override
	public boolean isElem(K k) {
		if (search(k) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void delete(K k) {
		int pos = k.hashCode() % table.length;
		table[pos].remove(k);
		size--;
	}
	
	private class TablesIter {
		int i; // va a recorrer la tabla por filas
		int j; //recorrera las columnas
		
		public TablesIter(){
			i=0;
			j=0;
		}
		
		public Tuple2<K,V> nextTuple(){
			while(table[i]==null && i<table.length){
				i++;
			}
			
			Tuple2<K,V> res=table[i].get(j);
			if(j+1==table[i].size()){
				j=0;
				i++;
			}else{
				j++;
			}
			return res;
		}
		
		public boolean hasNext(){
			return table[i]==null;
		}
		
		
	}
	
	private class keysIter extends TablesIter implements Iterator<K>{
		public K next(){
			return super.nextTuple()._1();
		}
	}
	
	private class valuesIter extends TablesIter implements Iterator<V>{
		public V next(){
			return super.nextTuple()._2();
		}
	}
	
	private class KeysValuesIter extends TablesIter implements Iterator<Tuple2<K,V>>{
		public Tuple2<K,V> next(){
			return super.nextTuple();
		}
	}
	
	public Iterable<K> keys(){
		return new Iterable<K>(){

			@Override
			public Iterator<K> iterator() {
				// TODO Auto-generated method stub
				return new keysIter();
			}
		
		};
		
	}
	
	

	@Override
	public Iterable<V> values() {
		return new Iterable<V>(){

			@Override
			public Iterator<V> iterator() {
				// TODO Auto-generated method stub
				return new valuesIter();
			}
		
		};
		
	}
	

	@Override
	public Iterable<Tuple2<K, V>> keysValues() {
		return new Iterable<Tuple2<K,V>>(){

			@Override
			public Iterator<Tuple2<K, V>> iterator() {
				
				return new KeysValuesIter();
			}
			
		};
	}

}
