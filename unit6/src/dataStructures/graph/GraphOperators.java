package dataStructures.graph;



import dataStructures.dictionary.Dictionary;
import dataStructures.dictionary.HashDictionary;
import dataStructures.list.ArrayList;
import dataStructures.list.List;
import dataStructures.set.HashSet;
import dataStructures.set.Set;
import dataStructures.tuple.Tuple2;

public class GraphOperators<V> {
	
	WGraph<V> g;
	Set<V>v;
	Set<V>vopt;
	V src;
	Dictionary<Integer,V> dict;
	public GraphOperators(WGraph<V> g,V ini){
		this.g=g;
		//Inicializamos v con todos los vertices menos el inicial
		v=g.vertices();
		v.delete(ini);
		//Iniciamos vopt con ini
		vopt=new HashSet<>();
		vopt.insert(ini);
		//Inicializamos el diccionario
		dict=new HashDictionary<>();
		dict.insert(0, ini);
	}
	
	
	public Set<List<V>> dijkstra(){
		Tuple2<V,Integer> aux;
		Set<List<V>> res=new HashSet<>();
		
		
		while(!v.isEmpty()){
			List<V> path= new ArrayList<>();
			for(V v: dict.values()){
				path.append(v);
			}
			
			res.insert(path);
			aux=minimo(sacasucesores());
			v.delete(aux._1());
			vopt.insert(aux._1());
			
			dict.insert(aux._2(), aux._1());
			g.updateEdges(aux, updatevalue());
			
			
		}
		
		
		
		return res;
	}
	
	public Dictionary<V, Integer> sacasucesores(){
		Dictionary<V,Integer>dict=new HashDictionary<>();
		for(V e:vopt){
			for(Tuple2<V,Integer> k : g.successors(e).keysValues()){
				dict.insert(k._1(), k._2());
			}
		}
		
		for(V v:vopt){
			dict.delete(v);
		}
		
		
		return dict;
	}
	
	public Tuple2<V,Integer> minimo(Dictionary<V,Integer> d){
		//Lo inicio al primer elemento
		Tuple2<V,Integer>min=d.keysValues().iterator().next();
		
		for(Tuple2<V, Integer> t:d.keysValues()){
			if(t._2()<min._2()){
				min=t;
			}
			
			
		}
		return min;
	}
	
	public int updatevalue(){
		int res=0;
		for(int k: dict.keys()){
			res+=k;
		}
		return res;
	}
	
	
}
