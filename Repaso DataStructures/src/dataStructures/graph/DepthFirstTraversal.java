/**
 * @author Pepe Gallardo, Data Structures, Grado en Inform�tica. UMA.
 *
 * Depth First Traversal of a graph. Uses a LIFO store
 */

package dataStructures.graph;

import dataStructures.stack.ArrayStack;

public class DepthFirstTraversal<V> extends Traversal<V> {
		
	public DepthFirstTraversal(Traversable<V> g, V source) {
		super(g,source);
	}
	
	private class LIFOStore<T> extends ArrayStack<T> implements Store<T> {
		
		public void insert(T elem) { push(elem); }
		
		public T extract() { T elem = top(); pop(); return elem; }
		
	}
	
	public Store<DiEdge<V>> newStore() {
		return new LIFOStore<>();
	}
	
}
