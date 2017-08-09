package dataStructures.dictionary;

import dataStructures.list.ArrayList;
import dataStructures.searchTree.AVL;
import dataStructures.searchTree.SearchTree;
import dataStructures.tuple.Tuple2;

public class AVLDictionaryMio<K extends Comparable <? super K>,V> implements Dictionary<K,V> {
	SearchTree <K,V> tree;
	
	
	public AVLDictionaryMio() {
		tree=new AVL<>();
	}
	
	
	@Override
	public boolean isEmpty() {
		
		return tree.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return tree.size();
	}

	@Override
	public void insert(K k, V v) {
		// TODO Auto-generated method stub
		
		tree.insert(k, v);
	}

	@Override
	public V valueOf(K k) {
		// TODO Auto-generated method stub
		return tree.search(k);
	}

	@Override
	public boolean isDefinedAt(K k) {
		// TODO Auto-generated method stub
		boolean res	=false;
		
		if(tree.search(k)!=null){
			res=true;
		}
		
		return res;
	}

	@Override
	public void delete(K k) {
		// TODO Auto-generated method stub
		tree.delete(k);
	}

	@Override
	public Iterable<K> keys() {
		ArrayList <K> aux=new ArrayList<K>();
		for(Tuple2<K,V> e :tree.keysValues()){
			aux.append(e._1());
		}
		return aux;
	}

	@Override
	public Iterable<V> values() {
		// TODO Auto-generated method stub
		return tree.values();
	}

	@Override
	public Iterable<Tuple2<K, V>> keysValues() {
		// TODO Auto-generated method stub
		return tree.keysValues();
	}

}
