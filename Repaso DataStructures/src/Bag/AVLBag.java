package Bag;

import java.util.Iterator;

import dataStructures.searchTree.AVL;
import dataStructures.searchTree.SearchTree;
import dataStructures.tuple.Tuple2;

public class AVLBag<K extends Comparable <? super K>> implements Bag<Tuple2<K ,Integer>> {

	SearchTree<K,Integer> tree=new AVL<>();

	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return tree.isEmpty();
	}
	
	private int get(K k){
		if(tree.search(k)==null){
			return 0;
		}
		return tree.search(k);
	}
	
	
	@Override
	public void insert(Tuple2<K, Integer> el) {
		int times=get(el._1());
		times++;
		tree.insert(el._1(), times);
	}

	@Override
	public int occurrences(Tuple2<K, Integer> el) {
		// TODO Auto-generated method stub
		return tree.search(el._1());
	}

	@Override
	public void delete(Tuple2<K, Integer> el) {
		// TODO Auto-generated method stub
		tree.delete(el._1());
	}


	@Override
	public Iterator<Tuple2<K, Integer>> iterator() {
		// TODO Auto-generated method stub
		return tree.keysValues().iterator();
	}

	

}
