import dataStructures.graph.DictionaryGraph;
import dataStructures.graph.Graph;
import dataStructures.graph.eulerian;

public class EulerianCycle {
	public static void main(String[] args) {
		//Creamos el grafo
		Graph<Character> g = new DictionaryGraph<>();
		g.addVertex('a');
		g.addVertex('b');
		g.addVertex('c');
		g.addVertex('d');
		g.addVertex('e');
		g.addVertex('f');
		g.addEdge('b', 'c');
		g.addEdge('a', 'd');
		g.addEdge('a', 'b');
		g.addEdge('c', 'd');
		g.addEdge('d', 'e');
		g.addEdge('e', 'f');
		g.addEdge('f', 'd');
		
		//generamos el/los ciclos eulerianos
		eulerian<Character> e = new eulerian<>(g);
		if (e.isEulerian()) {
			e.todosciclos();
			System.out.println(e.enlazaciclos());
		}else{
			throw new RuntimeException("El grafo no es euleriano");
		}
	}
}
