package Stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<T> implements Stack<T>{
	
	private List <T> al;
	private int idx;
	
	public ArrayStack(){
		al=new ArrayList<>();
		idx=-1;
	}
	
	public ArrayStack(Stack<T> a){
		this();
		while(!a.isEmpty()){
			al.add(a.top());
			a.pop();
		}
	}
	
	@Override
	public void push(T elem) {
		// TODO Auto-generated method stub
		al.add(elem);
		idx++;
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new RuntimeException("Error, pop on empty stack");
		}
		al.remove(idx);
		idx--;
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new RuntimeException("Error, top on empty stack");
		}
		return al.get(idx);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return al.isEmpty();
	}
	
}
