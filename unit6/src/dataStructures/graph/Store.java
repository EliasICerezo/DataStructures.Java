/**
 * @author Pepe Gallardo, Data Structures, Grado en Inform�tica. UMA.
 *
 * Interface for a store used to implement a graph exploration
 */

package dataStructures.graph;

interface Store<T> {
	boolean isEmpty();	
	void insert(T elem);
	T extract();
}


