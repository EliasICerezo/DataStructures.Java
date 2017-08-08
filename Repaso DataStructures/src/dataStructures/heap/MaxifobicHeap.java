package dataStructures.heap;

import java.util.List;

import dataStructures.list.ArrayList;

public class MaxifobicHeap<T extends Comparable<? super T>> implements Heap<T> {

	private static class Tree<E> {
		E elem;
		int weight; // number of elements on tree
		Tree<E> left;
		Tree<E> right;
	}

	private Tree<T> root; // reference to root of this heap

	private static <T> int weight(Tree<T> t) {
		return t == null ? 0 : t.weight;
	}

	private static <T extends Comparable<? super T>> ArrayList<Tree<T>> mayor(Tree<T> h1, Tree<T> h2, Tree<T> h3) {

		ArrayList<Tree<T>> l = new ArrayList<Tree<T>>();

		if (weight(h1) >= weight(h2) && weight(h1) >= weight(h3)) {
			l.append(h1);
			l.append(h2);
			l.append(h3);
			return l;
		} else if (weight(h2) >= weight(h1) && weight(h2) >= weight(h3)) {
			l.append(h2);
			l.append(h1);
			l.append(h3);
			return l;
		} else {
			l.append(h3);
			l.append(h1);
			l.append(h2);
			return l;
		}

	}

	// Merges two heap trees along their right spines.
	// Returns merged heap.
	// Reuses nodes during merge
	private static <T extends Comparable<? super T>> Tree<T> merge(Tree<T> h1, Tree<T> h2) {
		if(weight(h1)==0 && weight(h2)==0){
			return null;
		}else if (h1 == null){
			return h2;
		}else if (h2 == null){
			return h1;
		}else if (h1.elem.compareTo(h2.elem) <= 0) {
			Tree<T> current=new Tree<>();
			current.elem=h1.elem;
			current.weight=weight(h1)+weight(h2);
			
			ArrayList<Tree<T>> aux = mayor(h1.right, h1.left, h2);
			if (aux.size() != 3) {
				throw new RuntimeException("numero de elementos devueltos por mayor incorrectos");
			}
			Tree<T> mayor = aux.get(0);
			Tree<T> resto1 = aux.get(1);
			Tree<T> resto2 = aux.get(2);
			
			current.right = mayor;
			current.left = merge(resto1, resto2);
			
			System.out.println("ROOT "+weight(h1)+" R "+weight(h1.right)+" L " + weight(h1.left));
			return current;
		} else {
			System.out.println("He pasado x aqui");
			return merge(h2, h1);
		}
	}

	public Tree<T> mezcla(Tree<T> h2) {
		return merge(root, h2);

	}

	// copies a tree
	private static <T extends Comparable<? super T>> Tree<T> copy(Tree<T> h) {
		if (h == null)
			return null;
		else {
			Tree<T> h1 = new Tree<>();
			h1.elem = h.elem;
			h1.weight = h.weight;
			h1.left = copy(h.left);
			h1.right = copy(h.right);
			return h1;
		}
	}

	public MaxifobicHeap() {
		root = null;
	}

	public MaxifobicHeap(MaxifobicHeap<T> h) {
		root = copy(h.root);
	}

	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Time complexity: O(1)
	 */
	public int size() {
		return isEmpty() ? 0 : root.weight;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Time complexity: O(1)
	 * 
	 * @throws <code>EmptyHeapException</code>
	 *             if heap stores no element.
	 */
	public T minElem() {
		if (isEmpty())
			throw new EmptyHeapException("minElem on empty heap");
		else
			return root.elem;
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Time complexity: O(log n)
	 * 
	 * @throws <code>EmptyHeapException</code>
	 *             if heap stores no element.
	 */
	public void delMin() {
		if (isEmpty())
			throw new EmptyHeapException("delMin on empty heap");
		else
			root = merge(root.left, root.right);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * Time complexity: O(log n)
	 */
	public void insert(T x) {
		Tree<T> newHeap = new Tree<>();
		newHeap.elem = x;
		newHeap.weight = 1;
		newHeap.left = null;
		newHeap.right = null;

		root = merge(root, newHeap);
	}

	public void clear() {
		root = null;
	}

	private static String toStringRec(Tree<?> tree) {
		return tree == null ? "null"
				: "Node<" + toStringRec(tree.left) + "," + tree.elem + "," + toStringRec(tree.right) + ">";
	}

	/**
	 * Returns representation of heap as a String.
	 */
	@Override
	public String toString() {
		String className = getClass().getName().substring(getClass().getPackage().getName().length() + 1);

		return className + "(" + toStringRec(this.root) + ")";
	}

	/*
	 * Equals: Return if a tree is equal to another one taking in consideration
	 * his weight, root and if it is a heap or not
	 */

	public int compareTo(Heap<T> o) {

		if (o.size() == root.weight) {
			return 0;
		} else if (o.size() < root.weight) {
			return 1;
		} else {
			return -1;
		}

	}

}
