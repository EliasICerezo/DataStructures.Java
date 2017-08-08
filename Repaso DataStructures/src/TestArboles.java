import dataStructures.heap.Heap;
import dataStructures.heap.MaxifobicHeap;

public class TestArboles {

	
		public static void main(String[] args){
	        Heap<Integer> heap = new MaxifobicHeap<>();
	        heap.insert(5);
	        heap.insert(1);
	        heap.insert(8);
	        heap.insert(2);
	        heap.insert(6);
	        heap.insert(4);
	        heap.insert(5);

	        System.out.println(heap.toString());
	    }
		
		
		
		
	
}
