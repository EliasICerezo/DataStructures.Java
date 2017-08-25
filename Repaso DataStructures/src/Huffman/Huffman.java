package Huffman;

/**
 * Huffman trees and codes.
 *
 * Data Structures, Grado en Informatica. UMA.
 *
 *
 * Student's name:
 * Student's group:
 */

import dataStructures.dictionary.AVLDictionary;
import dataStructures.dictionary.Dictionary;
import dataStructures.list.ArrayList;
import dataStructures.list.List;
import dataStructures.priorityQueue.PriorityQueue;
import dataStructures.priorityQueue.WBLeftistHeapPriorityQueue;
import dataStructures.tuple.Tuple2;

public class Huffman {

	// Exercise 1
	public static Dictionary<Character, Integer> weights(String s) {
		Dictionary<Character, Integer> res = new AVLDictionary<>();
		int i = 0;
		while (i < s.length()) {
			char aux = s.charAt(i);
			if (res.isDefinedAt(aux)) {
				int v = res.valueOf(aux);
				v++;
				res.delete(aux);
				res.insert(aux, v);
			} else {
				res.insert(aux, 1);
			}

			i++;
		}

		return res;
	}

	// Exercise 2.a
	public static PriorityQueue<WLeafTree<Character>> huffmanLeaves(String s) {
		Dictionary<Character, Integer> k = weights(s);
		PriorityQueue<WLeafTree<Character>> res = new WBLeftistHeapPriorityQueue<>();
		for (Tuple2<Character, Integer> kv : k.keysValues()) {
			res.enqueue(new WLeafTree<Character>(kv._1(), kv._2()));
		}

		return res;
	}

	// Exercise 2.b
	public static WLeafTree<Character> huffmanTree(String s) {
    	Dictionary<Character,Integer> k=weights(s);
    	if(k.size()<2){
    		throw new HuffmanException("Menos de 2 elementos distintos en el string");
    	}
    	
    	PriorityQueue<WLeafTree<Character>> cola= huffmanLeaves(s);
    	
    	while(true){
    		WLeafTree<Character> aux1= cola.first();
    		cola.dequeue();
    		if(cola.isEmpty()){
    			return aux1;
    		}else{
    			WLeafTree<Character> aux2=cola.first();
    		    cola.dequeue();
    			aux2=merge(aux1,aux2);
    			cola.enqueue(aux2);
    		}	
    	}
    }
	
	
	
	private static WLeafTree<Character> merge(WLeafTree<Character> aux1, WLeafTree<Character> aux2) {
		return new WLeafTree<Character>(aux1, aux2);
	}

	// Exercise 3.a
	public static Dictionary<Character, List<Integer>> joinDics(Dictionary<Character, List<Integer>> d1, Dictionary<Character, List<Integer>> d2) {
		Dictionary<Character, List<Integer>> res=new AVLDictionary<>();
		Dictionary<Character, List<Integer>> d1c=new AVLDictionary<>();
		for(Tuple2<Character, List<Integer>>k:d1.keysValues()){
			d1c.insert(k._1(), k._2());
		}
		Dictionary<Character, List<Integer>> d2c=new AVLDictionary<>();
		for(Tuple2<Character, List<Integer>>k:d2.keysValues()){
			d1c.insert(k._1(), k._2());
		}
		
		
		res=mezcla(d1c,d2c,new AVLDictionary<>());
		//System.out.println(res);
		return res;
	}
	
	public static Dictionary<Character, List<Integer>> mezcla(Dictionary<Character, List<Integer>> d1, Dictionary<Character, List<Integer>> d2, Dictionary<Character, List<Integer>> res){
		//System.out.println(res);
		if(d1.isEmpty()&& d2.isEmpty()){
			return res;
		}else if(d1.isEmpty() && !d2.isEmpty()){
			for(Tuple2<Character,List<Integer>>k : d2.keysValues()){
				res.insert(k._1(), k._2());
				d2.delete(k._1());
			}
			return res;
		}else if(!d1.isEmpty() && d2.isEmpty()){
			for(Tuple2<Character,List<Integer>>k : d1.keysValues()){
				res.insert(k._1(), k._2());
				d2.delete(k._1());
			}
			return res;
		}else{
			Tuple2<Character,List<Integer>> aux1=d1.keysValues().iterator().next();
			Tuple2<Character,List<Integer>> aux2=d2.keysValues().iterator().next();
			
			if(aux1._2().get(aux1._2().size()-1)<=aux2._2().get(0)){
				//System.out.println("hola");
				res.insert(aux1._1(), aux1._2());
				d1.delete(aux1._1());
				mezcla(d1,d2,res);
			}else{
				res.insert(aux2._1(), aux2._2());
				d2.delete(aux2._1());
				mezcla(d1,d2,res);
			}
		}
		return res;
	
	}
	//No estoy seguro de que este bien implementado
	// Exercise 3.b
	public static Dictionary<Character, List<Integer>> prefixWith(int i, Dictionary<Character, List<Integer>> d) {
		
		for(Tuple2<Character, List<Integer>>k : d.keysValues()){
			k._2().insert(0, i);
			d.insert(k._1(), k._2());
			
		}
		
		return d;
	}

	// Exercise 3.c
	public static Dictionary<Character, List<Integer>> huffmanCode(WLeafTree<Character> ht) {
		Dictionary<Character, List<Integer>> d=new AVLDictionary<>();
		
		return code(ht, new ArrayList<Integer>(), d);
	}

	private static Dictionary<Character, List<Integer>> code(WLeafTree<Character> ht, ArrayList<Integer> r, Dictionary<Character, List<Integer>> d) {
		if(ht.isLeaf()){
			d.insert(ht.elem(), r);
			return d;
		}else{
			ArrayList<Integer> right=new ArrayList<>();
			
			ArrayList<Integer> left=new ArrayList<>();
			for(int i:r){
				right.append(i);
				left.append(i);
			}
			right.append(1);
			left.append(0);
			
			d=joinDics(code(ht.leftChild(), left,d) , code(ht.rightChild(),right,d) );
			return d;
		}
	}

	// Exercise 4
	public static List<Integer> encode(String s, Dictionary<Character, List<Integer>> hc) {
		// to do
		return null;
	}

	// Exercise 5
	public static String decode(List<Integer> bits, WLeafTree<Character> ht) {
		// to do
		return null;
	}
}
