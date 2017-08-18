import dataStructures.graph.WGraph;
import dataStructures.graph.WeightedGraph;

public class TestWeightedGraph {
	public static void main(String[] args){
		WGraph<Character> g=new WeightedGraph<>();
		
		g.addVertex('a');
		g.addVertex('b');
		g.addVertex('c');
		g.addVertex('d');

		System.out.println(g.vertices());
		
		g.addEdge('a', 'b', 2);
		g.addEdge('a', 'd', 7);
		g.addEdge('b', 'd', 2);
		g.addEdge('b', 'c', 4);
		g.addEdge('d', 'c', 5);
		g.deleteVertex('a');
		System.out.println(g.numEdges());
		
	}
}
