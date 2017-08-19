import dataStructures.graph.Dijkstra;
import dataStructures.graph.WGraph;
import dataStructures.graph.WeightedGraph;
import dataStructures.set.Set;

public class DijkstraExe {
	public static void main(String[] args){
		WGraph<Character> g=new WeightedGraph<>();
		
		g.addVertex('a');
		g.addVertex('b');
		g.addVertex('c');
		g.addVertex('d');
		g.addVertex('e');
		//System.out.println(g.vertices());
		
		g.addEdge('a', 'b', 3);
		g.addEdge('a', 'd', 7);
		g.addEdge('b', 'd', 2);
		g.addEdge('b', 'c', 4);
		g.addEdge('d', 'c', 5);
		g.addEdge('d', 'e', 4);
		g.addEdge('c', 'e', 6);
		//g.addEdge('a', 'a', 0);
		Dijkstra<Character> d=new Dijkstra<Character>(g,'a');
		
		
		
		
		
		System.out.println(d.dijkstra());
//		Set<Character> test=g.vertices();
//		test.insert('l');
//		System.out.println(g.vertices()+" "+test);
//		
		
	}
}
