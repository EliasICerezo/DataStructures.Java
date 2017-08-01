package Stack;

public class LinkedStack<T> implements Stack<T> {
	static private class Node<E> {
		E elem;
		Node<E> next;

		public Node(E x, Node<E> node) {
			elem = x;
			next = node;
		}
	}
	
	Node<T> top;

	public LinkedStack(){
		top=null;
	}
	
	public LinkedStack(Stack <T> a){
		this();
		while(!a.isEmpty()){
			push(a.top());
			a.pop();
		}
		
	}
	
	@Override
	public void push(T elem) {
		// TODO Auto-generated method stub
		Node<T>aux=new Node<>(elem,null);
		if(top==null){
			top=aux;
		}else{
			aux.next=top;
			top=aux;
		}
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		if(top==null){
			throw new RuntimeException("Error, pop on empty stack");
		}
		top=top.next;
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		if(top==null){
			throw new RuntimeException("Error, top on empty stack");
		}
		return top.elem;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==null;
	}
	
	
}
