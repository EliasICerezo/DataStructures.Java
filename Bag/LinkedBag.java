package Bag;

import java.util.Iterator;

public class LinkedBag<T extends Comparable<? super T>> implements Bag<T> {

	static private class Node<E> {
		E elem;
		int times;
		Node<E> next;

		public Node(E el, int t, Node<E> sig) {
			elem = el;
			times = t;
			next = sig;
		}

	}

	private Node<T> first;

	public LinkedBag() {
		first = null;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public void insert(T el) {
		// TODO Auto-generated method stub
		Node<T> nuevo = new Node<>(el, 1, null);
		Node<T> aux = first;
		Node<T> prev = first;

		boolean f = false;
		if (first == null) {
			first = nuevo;
		} else {
			while (!f && aux != null) {
				if (aux.elem.equals(el)) {
					aux.times = aux.times + 1;

					f = true;
				} else if (aux.elem.compareTo(el) > 0) {
					prev.next = nuevo;
					nuevo.next = aux;
					f = true;
				} else {
					prev = aux;
					aux = aux.next;
				}
			}
			if (!f) {
				prev.next = nuevo;
			}
		}

	}

	@Override
	public int occurrences(T el) {
		Node<T> aux = first;

		while (aux != null) {
			if (aux.elem.compareTo(el) == 0) {
				return aux.times;
			} else {
				aux = aux.next;
			}
		}
		return -1;
	}

	@Override
	public void delete(T el) {
		Node<T> aux = first;
		Node<T> prev = aux;
		boolean f = false;
		if (first != null) {
			if (first.elem.equals(el) && first.times == 1) {
				first = first.next;
			} else {
				while (!f && aux != null) {
					if (el.equals(aux.elem)) {
						if (aux.times - 1 == 0) {
							prev.next = aux.next;
							aux = null;
						} else {
							aux.times -= 1;
						}
					} else {
						prev = aux;
						aux = aux.next;
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		String str = new String();
		Node<T> aux = first;
		while (aux != null) {
			str += aux.elem + "->" + aux.times + " ";
			aux = aux.next;
		}
		return str;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedBagIterator();
	}

	private class LinkedBagIterator implements Iterator<T> {
		Node<T> current;
		int veces;
		
		public LinkedBagIterator() {
			current = first;
			veces=1;
		}

		@Override
		public boolean hasNext() {

			return current != null;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new RuntimeException("It hasn't next");
			}
			T res = current.elem;
			if(veces==current.times){
				veces=1;
				current=current.next;
			}else{
				veces++;
			}
			
			return res;
		}

	}

}
