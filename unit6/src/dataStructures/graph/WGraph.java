package dataStructures.graph;

import dataStructures.dictionary.Dictionary;
import dataStructures.set.Set;
import dataStructures.tuple.Tuple2;

public interface WGraph<V> {
	public void addVertex(V v);
	public void addEdge(V src, V fin,int peso);
	public void deleteEdge(V src, V fin);
	public void deleteVertex(V v);
	public Set<V> vertices();
	public Dictionary <Tuple2<V,V>,Integer> aristas();
	public int numVertices();
	public int numEdges();
	public Dictionary<V,Integer> successors(V v);
}
