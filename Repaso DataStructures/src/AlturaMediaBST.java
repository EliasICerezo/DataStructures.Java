import java.util.Random;
import java.util.Scanner;

import dataStructures.searchTree.BST;
import dataStructures.searchTree.SearchTree;

public class AlturaMediaBST {
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("¿Cuantos nodos quieres?: ");
		int n=sc.nextInt();
		while(n<0){
			System.out.print("¿Cuantos nodos quieres?: ");
			n=sc.nextInt();
		}
		
		
		Random rnd=new Random();
		SearchTree<Integer,Integer> st=new BST<>();
		for(int i=0;i<n;i++){
			st.insert(rnd.nextInt(1000000), rnd.nextInt(1000000));
		}
		System.out.println("La altura media de este arbol es: "+st.height());
	}
}
