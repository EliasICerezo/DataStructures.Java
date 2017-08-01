package LinkedPriorityQueue;

public interface PriorityQueue<T> {
	
	public void enqueue(T elem);
	public void dequeue();
	T first();
	boolean isEmpty();

}
