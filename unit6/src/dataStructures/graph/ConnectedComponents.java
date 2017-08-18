/**
 * @author Pepe Gallardo, Data Structures, Grado en Inform�tica. UMA.
 *
 * Connected components for an undirect graph
 */

package dataStructures.graph;

import dataStructures.dictionary.Dictionary;
import dataStructures.dictionary.HashDictionary;
import dataStructures.set.HashSet;
import dataStructures.set.Set;

public class ConnectedComponents<V> {
	private Set<Set<V>> components;
	private Dictionary<V, Integer> inComponent;
	
	public ConnectedComponents(Graph<V> g) {
		components = new HashSet<>();
		inComponent = new HashDictionary<>();
		
		Set<V> unvisited = new HashSet<>();
		for(V v : g.vertices())
			unvisited.insert(v);
		
		for(int c = 0; !unvisited.isEmpty(); c++) {
			V src = unvisited.iterator().next();
			inComponent.insert(src, c);
			
			Set<V> component = new HashSet<>();
			for(V v : new DepthFirstTraversal<>(g, src).vertices()) {
				component.insert(v);
				inComponent.insert(v, c);
			}	
			
			components.insert(component);
			
			for(V v : component)
				unvisited.delete(v);
		}
	}
	
	public Set<Set<V>> components() {
		return components;
	}
	
	public boolean areConnected(V v, V w) {
		return inComponent.valueOf(v).equals(inComponent.valueOf(w));
	}
	

}
