import LinkedPriorityQueue.*;
import LinkedPriorityQueue.PriorityQueue;

public class TestLPQ {
	public static void main(String [] args){
		PriorityQueue<Integer> pq=new LinkedNOPriorityQueue<>();
		System.out.println(pq.isEmpty());
		
		pq.enqueue(2);
		pq.enqueue(1);
		pq.enqueue(5);
		pq.enqueue(4);
		pq.enqueue(0);
		pq.enqueue(3);
		System.out.println(pq);
		
		pq.dequeue();
		System.out.println(pq);
		System.out.println(pq.first());
		
	}
}
