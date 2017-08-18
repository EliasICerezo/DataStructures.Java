/**
 * @author Pepe Gallardo, Data Structures, Grado en Inform�tica. UMA.
 *
 * Breadth First Traversal of a graph. Uses a FIFO store
 */

package dataStructures.graph;

import dataStructures.queue.ArrayQueue;

public class BreadthFirstTraversal<V> extends Traversal<V> {
		
	public BreadthFirstTraversal(Traversable<V> g, V source) {
		super(g,source);
	}
	
	private class FIFOStore<T> extends ArrayQueue<T> implements Store<T> {

		public void insert(T elem) { enqueue(elem); }
		
		public T extract() { T elem = first(); dequeue(); return elem; }

	}
	
	public Store<DiEdge<V>> newStore() {
		return new FIFOStore<DiEdge<V>>();
	}	

}
