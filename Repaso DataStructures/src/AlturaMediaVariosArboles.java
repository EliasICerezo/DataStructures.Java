import java.util.Random;
import java.util.Scanner;

import dataStructures.searchTree.BST;
import dataStructures.searchTree.SearchTree;

public class AlturaMediaVariosArboles {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("¿Cuantos nodos quieres?: ");
		int n = sc.nextInt();
		while (n < 0) {
			System.out.print("¿Cuantos nodos quieres?: ");
			n = sc.nextInt();
		}
		double result=0;

		Random rnd = new Random();
		SearchTree<Integer, Integer> st = new BST<>();
		for (int j = 0; j < 20; j++) {
			for (int i = 0; i < n; i++) {
				st.insert(rnd.nextInt(1000000), rnd.nextInt(1000000));
			}
			result+=st.height();
			
			st=null;
			st=new BST<Integer,Integer>();
			
			
		}
		System.out.println("La altura media de 20 arboles es: " + result/20);
		
		result=0;
		for (int j = 0; j < 100; j++) {
			for (int i = 0; i < n; i++) {
				st.insert(rnd.nextInt(1000000), rnd.nextInt(1000000));
			}
			result+=st.height();
			
			st=null;
			st=new BST<Integer,Integer>();
			
			
		}
		System.out.println("La altura media de 100 arboles es: " + result/100);
		
		result=0;
		for (int j = 0; j < 1000; j++) {
			for (int i = 0; i < n; i++) {
				st.insert(rnd.nextInt(1000000), rnd.nextInt(1000000));
			}
			result+=st.height();
			
			st=null;
			st=new BST<Integer,Integer>();
			
			
		}
		System.out.println("La altura media de 1000 arboles es: " + result/1000);
	}
}
