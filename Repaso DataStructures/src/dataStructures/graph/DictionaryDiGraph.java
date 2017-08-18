/**
 * @author Pepe Gallardo, Data Structures, Grado en Inform�tica. UMA.
 *
 * Class for directed graphs implemented with a dictionary
 */

package dataStructures.graph;

import java.util.Iterator;

import dataStructures.dictionary.Dictionary;
import dataStructures.dictionary.HashDictionary;
import dataStructures.set.HashSet;
import dataStructures.set.Set;

public class DictionaryDiGraph<V> implements DiGraph<V> {

	protected Set<V> vertices;               // set with all vertices in graph
	protected Dictionary<V,Set<V>> diEdges;  // Dict with sources as keys and Set of destinations as values
	
	public DictionaryDiGraph() {
		vertices = new HashSet<>();
		diEdges = new HashDictionary<>();
	}
	
	public void addVertex(V v) {
		vertices.insert(v);
	}
	
	public void addDiEdge(V src, V dst) {
		if(!vertices.isElem(src))
			throw new GraphException("vertex "+src+" is not in graph");
		if(!vertices.isElem(dst))
			throw new GraphException("vertex "+dst+" is not in graph");
		
		Set<V> destinations = diEdges.valueOf(src);
		if(destinations == null) {
			destinations = new HashSet<>();
			diEdges.insert(src, destinations);
		}
		destinations.insert(dst);			
	}	
	
	public void deleteDiEdge(V src, V dst) {
		Set<V> destinations = diEdges.valueOf(src);
		if(destinations != null) 
			destinations.delete(dst);
	}	

	public void deleteVertex(V v) {
		vertices.delete(v); // remove from set of vertices
		diEdges.delete(v); //remove all edges from v
		// remove all edges to v
		for(V w : vertices) 
		  deleteDiEdge(w,v);
	}
		
	public Set<V> vertices() {
		return vertices;
	}	
	
	public int numVertices() {
		return vertices.size();
	}	
	
	public int numEdges() {
		int sz = 0;
		for(V src : diEdges.keys())
			sz += diEdges.valueOf(src).size();
		return sz;
	}	
	
	public Set<V> successors(V src) {
		Set<V> destinations = diEdges.valueOf(src);
		return destinations == null ? new HashSet<>() : destinations;
	}

	public Set<V> predecessors(V dst) {
		Set<V> sources = new HashSet<>();
		for(V src : vertices)
			if(successors(src).isElem(dst))
				sources.insert(src);
		return sources;
	}
	
	public int inDegree(V v) {
		return predecessors(v).size();
	}

	public int outDegree(V v) {
		return successors(v).size();
	}

	public String toString() {
    String className = getClass().getSimpleName();
		String s = className+"(vertices=(";

		Iterator<V> it = vertices.iterator();
		while(it.hasNext()) 
			s += it.next() + (it.hasNext() ? "," : "");
		s += ")";
		
		int edges = numEdges();
		
		s += ", edges=(";
		for (V v : vertices())
			for(V w : successors(v)) {
				edges--;
				s += v + "->" + w + (edges > 0 ? "," : "");
			}
		s += "))";
		
		return s;
	}	

	public Object clone() {
		DictionaryDiGraph<V> clone = new DictionaryDiGraph<>();

		for(V v : vertices)
			clone.addVertex(v);
		
		for(V v : vertices)
			for(V w : successors(v))
				clone.addDiEdge(v, w);
			
		return clone;
	}	
	
}
