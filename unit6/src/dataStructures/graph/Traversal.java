/**
 * @author Pepe Gallardo, Data Structures, Grado en Inform�tica. UMA.
 *
 * Abstract class implementing generic traversals on a graph
 */

package dataStructures.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

import dataStructures.dictionary.Dictionary;
import dataStructures.dictionary.HashDictionary;
import dataStructures.list.LinkedList;
import dataStructures.list.List;
import dataStructures.set.HashSet;
import dataStructures.set.Set;


public abstract class Traversal<V> {

	static class DiEdge<V> { // Edge from src vertex to dst vertex
		V src, dst;
		public DiEdge(V s, V d) {
			src = s;
			dst = d;
		}
	}

	private Traversable<V> graph; // graph to explore
	private V source;             // initial node (source) for exploration

	abstract public Store<DiEdge<V>> newStore(); // will be defined in subclasses to return different kinds of stores
	
	public Traversal(Traversable<V> g, V src) {
		graph = g;
		source = src;
	}	

	private abstract class BaseIterator {
		protected Set<V> visited;             // already visited vertices 
		protected Store<DiEdge<V>> store;     // diEdges to vertices yet to be explored
		protected Dictionary<V,V> sources;    // source for each visited vertex during traversal
		protected V nextVertex;               // next vertex to be visited (or null if end of traversal)

		public BaseIterator() {
			visited = new HashSet<>();
			store = newStore();
			store.insert(new DiEdge<>(source,source));
			sources = new HashDictionary<>();
			advanceTraversal();		
		}
	
		// finds next vertex to be visited in traversal. Leaves this vertex (or null at end of traversal) in nextVertex
		protected void advanceTraversal() {
			nextVertex = null;
			while(!store.isEmpty() && nextVertex==null) {
				DiEdge<V> edge = store.extract();
				V v = edge.dst;
				if(!visited.isElem(v)) {
					nextVertex = v;
					visited.insert(v);
					sources.insert(v, edge.src);
					for(V w : graph.successors(v)) 
						if(!visited.isElem(w))
							store.insert(new DiEdge<>(v, w));
				}
			}
		}	

		public boolean hasNext() {
			return nextVertex != null;
		}			
	}
	
	
	private class VerticesIterator extends BaseIterator implements Iterator<V> {
		public V next() {
			if (!hasNext())
				throw new NoSuchElementException();	
			
			V vertex = nextVertex;
			
			advanceTraversal(); //for next iteration of iterator
			
			return vertex;	
		}
	}	
	
	public Iterator<V> verticesIterator() {
		return new VerticesIterator();
	}
	
	public Iterable<V> vertices() {		
		return new Iterable<V>(){
			public Iterator<V> iterator() {
				return verticesIterator();
			}
		};
	}	
  
	private class PathsIterator extends BaseIterator implements Iterator<Iterable<V>> {	
		// returns path from initial source to vertex v
		private List<V> pathTo(V v) {
			List<V> path = new LinkedList<>();
			while(v!=source) {
				path.insert(0, v);
				v = sources.valueOf(v);
			}
			path.insert(0, v);
			return path;
		}		
		
		public Iterable<V> next() {
			if (!hasNext())
				throw new NoSuchElementException();	
	
			// reconstruct path from source to visited vertex
			Iterable<V> path = pathTo(nextVertex);
			
			advanceTraversal(); //for next iteration of iterator
			
			return path;
		}
	}	

	public Iterator<Iterable<V>> pathsIterator() {
		return new PathsIterator();
	}	
	
	public Iterable<Iterable<V>> paths() {		
		return new Iterable<Iterable<V>>(){
			public Iterator<Iterable<V>> iterator() {
				return pathsIterator();
			}
		};
	}
	
}
