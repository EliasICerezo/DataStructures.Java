import Deque.Deque;
import Deque.DoubleEndedQueue;

public class TestDeque {
	public static void main(String [] args){
		DoubleEndedQueue<Integer> d=new Deque<>();
		d.addFirst(3);
		d.addFirst(2);
		d.addFirst(1);
//		d.addLast(3);
		d.addLast(4);
		d.addLast(5);
		d.addFirst(0);
		d.addFirst(-1);
		d.deleteFirst();
		d.deleteLast();
		System.out.println(d);
		System.out.println(d.toStringrev());
		
		
		
	}
}
