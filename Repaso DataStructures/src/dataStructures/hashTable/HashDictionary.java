package dataStructures.hashTable;

import dataStructures.dictionary.Dictionary;
import dataStructures.tuple.Tuple2;

public class HashDictionary<K,V> implements Dictionary<K, V> {
	
	HashTable<K, V> t;
	
	public HashDictionary(int numChains, double loadFactor) {
		t=new SeparateChainingHashTable<>(numChains, loadFactor);
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return t.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return t.size();
	}

	@Override
	public void insert(K k, V v) {
		t.insert(k, v);
		
	}

	@Override
	public V valueOf(K k) {
		// TODO Auto-generated method stub
		return t.search(k);
	}

	@Override
	public boolean isDefinedAt(K k) {
		// TODO Auto-generated method stub
		return t.isElem(k);
	}

	@Override
	public void delete(K k) {
		// TODO Auto-generated method stub
		t.delete(k);
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return t.keys();
	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return t.values();
	}

	@Override
	public Iterable<Tuple2<K, V>> keysValues() {
		// TODO Auto-generated method stub
		return t.keysValues();
	}

}
