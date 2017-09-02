/**
 * Student's name:
 * Student's group:
 *
 * Data Structures. Grado en Informática. UMA.
 */

package dataStructures.graph;

import dataStructures.list.*;

public class EulerianCycle<V> {
    private List<V> eCycle=null;
    
    @SuppressWarnings("unchecked")
    public EulerianCycle(Graph<V> g) {
        Graph<V> graph = (Graph<V>) g.clone();
        if(isEulerian(g)){
        	eCycle = eulerianCycle(graph);
        }
    }

    public boolean isEulerian() {
       // System.out.println(eCycle);
    	return eCycle != null;
    }

    public List<V> eulerianCycle() {
        return eCycle;
    }

    // J.1
    private static <V> boolean isEulerian(Graph<V> g) {
        // TO DO
        for(V v:g.vertices()){
        	//System.out.println(g.degree(v)%2);
        	if(g.degree(v)%2==1){
        		return false;
        	}
        }
    	return true;
    }

    // J.2
    private static <V> void remove(Graph<V> g, V v, V u) {
        g.deleteEdge(v, u);
        for(V ver:g.vertices()){
        	if(g.degree(ver)==0){
        		g.deleteVertex(ver);
        	}
        }
    }

    // J.3
    private static <V> List<V> extractCycle(Graph<V> g, V v0) {
    	List <V> ciclo=new ArrayList<>();
    	ciclo.append(v0);
    	V aux=g.successors(v0).iterator().next();
    	V aux2=v0;
    	while(!aux.equals(v0)){
    		ciclo.append(aux);
    		remove(g, aux, aux2);
    		aux2=aux;
    		aux=g.successors(aux).iterator().next();
    	}
    	remove(g, aux2, v0);
    	ciclo.append(v0);
        return ciclo;
    }

    // J.4
    private static <V> void connectCycles(List<V> xs, List<V> ys) {
    		
    		if(xs.isEmpty()){
    			xs=ys;
    		}else{
    			int i=0,j=0;
    			if(xs.get(i).equals(ys.get(j)) ){
    				for(int k=j+1;k<ys.size();k++){
    					xs.insert(i, ys.get(k));
    				}
    				
    				
    				
    				
    			}else{
    				boolean f=false;
    				while(!f && i<xs.size() ){
    					if (xs.get(i).equals(ys.get(j))){
    						for(int k=j+1;k<ys.size();k++){
    	    					xs.insert(i, ys.get(k));
    	    				}
    	    				
    	    				
    	    				f=true;
    					}else{
    						i++;
    					}
    					
    				}
    				
    			}
    			
    			
    			
    		}
    }

    // J.5
    private static <V> V vertexInCommon(Graph<V> g, List<V> cycle) {
    		for(V v:g.vertices()){
    			
    			for(V e:cycle){
    				if(e.equals(v)){
    					return v;
    				}
    			}
  
    		}
    		
    	
    		return null;
    }

    // J.6
    private static <V> List<V> eulerianCycle(Graph<V> g) {
    	if(!isEulerian(g)){
    		throw new RuntimeException("El grafo no es euleriano");
    	}
    	List<V>res=new ArrayList<>();
    	res=extractCycle(g,g.vertices().iterator().next());
    	List<V> aux;
    	while(!g.isEmpty()){
    		aux=extractCycle(g,g.vertices().iterator().next());
    		System.out.println(aux);
    		System.out.println(res);
    		connectCycles(res,aux);
    	}
    	
    	
    	
        return res;
    }
}
