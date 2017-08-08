package dataStructures.heap;

import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

import dataStructures.heap.Heap;

public class MaxiphobicHeap<T extends Comparable<? super T>> implements Heap<T>{

	public static void main(String[] args){
		MaxiphobicHeap<Integer> heap = new MaxiphobicHeap<>();
		heap.insert(1);heap.insert(2);heap.insert(3);heap.insert(4);
		heap.insert(5);heap.insert(7);heap.insert(8);heap.insert(9);
		
		System.out.println(heap.toString());
	}
	
	private static class Tree<E>{
		E elem;
		int weight;
		Tree<E> lt,rt;
		
		private static String toStringRec(Tree<?> tree) {
			return tree == null ? "null" : "Node<" + toStringRec(tree.lt) + ","
					+ tree.elem + "," + toStringRec(tree.rt) + ">";
		}
		
		/** 
		 * Returns representation of heap as a String.
		 */
		public String toString() {
			String className = getClass().getSimpleName();

			return className+"("+toStringRec(this)+")";
		}
		
	}
	
	private Tree<T> root;
	
	public MaxiphobicHeap() {
		root = null;
	}
	
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	private static int weight(Tree<?> heap) {
		return heap == null ? 0 : heap.weight;
	}
	
	private static <T extends Comparable<? super T>> Tree<T> singleton(T elem){
		Tree<T> h = new Tree<>();
		h.elem = elem;
		h.lt = null;
		h.rt = null;
		h.weight = 1;
		return h;
	}
	
	private static <T extends Comparable<? super T>> Tree<T> merge(Tree<T> h1, Tree<T> h2){
		if(weight(h1) == 0 && weight(h2) == 0){
			return null;
		}else if(weight(h1) == 0){
			return h2;
		}else if(weight(h2) == 0){
			return h1;
		}else if(h1.elem.compareTo(h2.elem) <= 0){
			Tree<T> current = new Tree<>();
			current.elem = h1.elem;
			current.weight = weight(h1) + weight(h2);
			current.lt = chooseLeft(h1.lt,h1.rt,h2);
			current.rt = chooseRight(h1.lt,h1.rt,h2);
			return current;
		}else{
			return merge(h2,h1);
		}
	}
	
	private static <T extends Comparable<? super T>> Tree<T> chooseLeft(Tree<T> lt, Tree<T> rt, Tree<T> h2){
		if(weight(lt) >= weight(rt) && weight(lt) >= weight(h2)){
			return merge(h2,rt);
		}else if(weight(rt) >= weight(lt) && weight(rt) >= weight(h2)){
			return merge(h2,lt);
		}else{
			return merge(lt,rt);
		}
	}
	
	private static <T extends Comparable<? super T>> Tree<T> chooseRight(Tree<T> lt, Tree<T> rt, Tree<T> h2){
		if(weight(lt) >= weight(rt) && weight(lt) >= weight(h2)){
			return lt;
		}else if(weight(rt) >= weight(lt) && weight(rt) >= weight(h2)){
			return rt;
		}else{
			return h2;
		}
	}
			

	@Override
	public void insert(T x) {
		root = merge(singleton(x),root);
	}

	@Override
	public T minElem() {
		if(root == null){
			throw new NoSuchElementException("minElem on empty heap.");
		}
		return root.elem;
	}

	@Override
	public void delMin() {
		if(root == null){
			throw new NoSuchElementException("minElem on empty heap.");
		}
		root = merge(root.lt,root.rt);
	}
	
	private static String toStringRec(Tree<?> tree) {
		return tree == null ? "null" : "Node<" + toStringRec(tree.lt) + ","
				+ tree.elem + "," + toStringRec(tree.rt) + ">";
	}
	
	/** 
	 * Returns representation of heap as a String.
	 */
	public String toString() {
		String className = getClass().getSimpleName();

		return className+"("+toStringRec(this.root)+")";
	}

	@Override
	public int size() {
		try {
			throw new NoSuchAlgorithmException();
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Unsopported Operation.");
		}
		return 0;
	}

}
