package Stack;
import java.util.LinkedList;
public class LinkedListStack<T> implements Stack<T>{
	
	private LinkedList <T> list;
	
	
	
	public LinkedListStack(){
		list= new LinkedList<>();
		
	}
	
	public LinkedListStack(Stack<T> a){
		this();
		while(!a.isEmpty()){
			list.add(a.top());
			a.pop();
		}
		
		
	}
	
	
	@Override
	public void push(T elem) {
		list.add(elem);
		
		
	}

	@Override
	public void pop() {
		list.removeLast();
		
		
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		return list.getLast();
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}
	

}
