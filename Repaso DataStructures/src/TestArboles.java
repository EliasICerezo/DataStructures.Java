import dataStructures.heap.Heap;
import dataStructures.heap.MaxifobicHeap;


public class TestArboles {
	public static void main(String [] args){
		Heap<Integer> h1=new MaxifobicHeap<>();
		Heap<Integer> h2=new MaxifobicHeap<>();
		
		h1.insert(9);
		h1.insert(4);
		h1.insert(2);
		h1.insert(5);
		h1.insert(9);
		h1.insert(7);
		
		
		h2.insert(2);
		h2.insert(3);
		h2.insert(5);
		h2.insert(4);
		h2.insert(1);
		h2.insert(0);
		
		
		
		
		
		
	
		System.out.println(h1);
		
		
		
		
	}
}
