/**
 * @author Pepe Gallardo, Data Structures, Grado en Inform�tica. UMA.
 *
 * Interface for directed graphs
 */

package dataStructures.graph;

import dataStructures.set.Set;

public interface DiGraph<V> extends Traversable<V>, Cloneable {
	
	void addVertex(V v);
	
	void deleteVertex(V v);

	void addDiEdge(V v, V w);

	void deleteDiEdge(V v, V w);
	
	int numVertices();

	int numEdges();
	
	Set<V> vertices();

	int inDegree(V v);
	
	int outDegree(V v);

	Set<V> predecessors(V dst);
	
	Object clone();	
	
}