package Deque;



public class REPASODQ<T> implements DoubleEndedQueue<T>{
	//HARDCORE PROGRAMMING
	
	private class Node<E>{
		E e;
		Node<E> next;
		Node<E> prev;
		
		public Node(E elem, Node<E> next, Node<E>prev){
			e=elem;
			this.next=next;
			this.prev=prev;
		}
	}
	
	Node<T> first;
	Node<T> last;
	
	
	public REPASODQ() {
		first=null;
		last=null;
		
		
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first==null && last==null;
	}

	@Override
	public void addFirst(T x) {
		Node<T> aux=new Node<>(x,null,null);
		if(first ==null ){
			aux.next=first;
			first=aux;
			last=aux;
		
		}else{
			aux.next=first;
			first=aux;
			
			
			Node<T>aux2=last;
			while(aux2.prev!=null){
				aux2=aux2.prev;
			}
			aux2.prev=aux;
		}
		
	}

	@Override
	public void addLast(T x) {
		Node<T> aux=new Node<>(x,null,null);
		if(first ==null ){
			aux.next=first;
			first=aux;
			last=aux;
		
		}else{
			aux.prev=last;
			last=aux;
			
			Node<T>aux2=first;
			while(aux2.next!=null){
				aux2=aux2.next;
			}
			aux2.next=aux;
			
		}
		
	}

	@Override
	public T first() {
		
		return first.e;
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		return last.e;
	}

	@Override
	public void deleteFirst() {
		if(first==null){
			throw new RuntimeException("Delete on empty DQ");
		}else if (first.next==null){
			first=null;
			last=null;
		}else{
			first=first.next;
			Node<T> aux=last;
			while(aux.prev.prev!=null){
				aux=aux.prev;
			}
			aux.prev=null;
		}
			
		
	}

	@Override
	public void deleteLast() {
		if(first==null){
			throw new RuntimeException("Delete on empty DQ");
		}else if (first.next==null){
			first=null;
			last=null;
		}else{
			last=last.prev;
			Node<T> aux=first;
			while(aux.next.next!=null){
				aux=aux.next;
			}
			aux.next=null;
		}
	}

	@Override
	public String toString(){
		String str=new String();
		Node<T> aux=first;
		while(aux!=null){
			//System.out.println("STR");
			str+= aux.e+" ";
			aux=aux.next;
		}
		return str;
	}
	
	
	public String toStringrev(){
		String str=new String();
		Node<T> aux=last;
		while(aux!=null){
			//System.out.println("STR");
			str+= aux.e+" ";
			aux=aux.prev;
		}
		return str;
	}

}
