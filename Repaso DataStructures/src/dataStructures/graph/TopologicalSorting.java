/**
 * @author Pepe Gallardo, Data Structures, Grado en Inform�tica. UMA.
 *
 * Computes Topological Sorting for DiGraphs
 */

package dataStructures.graph;

import dataStructures.list.ArrayList;
import dataStructures.list.List;


public class TopologicalSorting<V> {
	
	// EXERCISE: implement using reverse graph

	private List<V> order;
	private boolean cycle;
	
	public TopologicalSorting(DiGraph<V> graph) {
		order = new ArrayList<>();
		cycle = false;
		
		DiGraph<V> g = (DiGraph<V>) graph.clone();
		
		while(!cycle && !g.vertices().isEmpty()) {
			
			V next = null;
			for(V v : g.vertices())
				if(g.inDegree(v)==0) {
					next = v;
					break;
				}
			
			if(next!=null) {
				order.append(next);
				g.deleteVertex(next); //also deletes corresponding edges
			}
			else 
				cycle = true;						
		}					
	}	
	
	public boolean hasCycle() {
		return cycle;
	}
	
	public List<V> order() {
		return cycle ? null : order;
	}
	
}
