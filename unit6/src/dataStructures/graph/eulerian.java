package dataStructures.graph;

import dataStructures.list.ArrayList;
import dataStructures.list.List;


public class eulerian<V> {
	List<List<V>> l;
	Graph<V> g;
	
	public eulerian(Graph<V> g){
		this.g=g;
		l=new ArrayList<>();
	}
	
	public boolean isEulerian(){
		for(V v: g.vertices()){
			if(g.degree(v)%2!=0){
				return false;
			}
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public Graph<V> grafo(){
		return (Graph<V>) g.clone();
	}
	
	
	public List<V> sacaciclo(Graph<V> grafo){
		
		Graph<V> gr=grafo;
		List<V> res=new ArrayList<>();
		V aux=gr.vertices().iterator().next();
		V ini=aux;
		V prev=aux;
		res.append(ini);
		aux=gr.successors(aux).iterator().next();
		while(!aux.equals(ini)){
			res.append(aux);
			gr.deleteEdge(prev, aux);
			prev=aux;
			aux=gr.successors(aux).iterator().next();

		}
		gr.deleteEdge(prev, aux);
		res.append(aux);
		
		
		return res;
	}
	
	public void todosciclos(){
		@SuppressWarnings("unchecked")
		Graph<V> grafo=(Graph<V>)g.clone();
		while(grafo.numEdges()!=0){
			List<V> aux=sacaciclo(grafo);
			for(V v:grafo.vertices()){
				if(grafo.degree(v)==0){
					grafo.deleteVertex(v);
				}
			}
			//System.out.println(grafo);
			l.append(aux);
		}
		
	}
	
	public List<List<V>> ciclos(){
		List<List<V>> res=new ArrayList<>();
		for(List<V> v:l){
			res.append(v);
		}
		return res;
	}
	
	public List<V> enlazaciclos(){
		List<V> res=l.get(0);
		int suma=0;
		boolean f=false;
		l.remove(0);
		int idx=0;
		while(l.size()!=0){
			
			for(V v:res){
				if(l.get(0).get(0).equals(v)&&!f){
					for(V w:l.get(0)){
						res.insert(idx, w);
						suma++;
					}
					res.remove(idx+suma);
					f=true;
				}
				idx++;
			}
			suma=0;
			idx=0;
			f=false;
			l.remove(0);
			
		}
		return res;
	}
	
	
	
}
