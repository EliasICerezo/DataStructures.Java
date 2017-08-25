package Deque;

public class Deque<K> implements DoubleEndedQueue<K> {
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
	
	Node<K> first;
	Node<K> last;
	
	public Deque(){
		first=null;
		last=null;
	}
	
	public boolean isEmpty(){
		return first==null && last==null;
	}

	@Override
	public void addFirst(K x) {
		if(isEmpty()){
			first=new Node<>(x,null,null);
			last=new Node<>(x,null,null);
		}else{
			Node<K> aux= new Node<>(x,first,null);
			
			first=aux;
			
			Node<K> aux2=last;
			
			while(aux2.prev!=null){
				
				//System.out.println("hola");
				aux2=aux2.prev;
			}
			aux2.prev=aux;
			
			
		}
		
	}

	@Override
	public void addLast(K x) {
		if(isEmpty()){
			first=new Node<>(x,null,null);
			last=new Node<>(x,null,null);
		}else{
			Node<K> aux= new Node<>(x,null,last);
			
			last=aux;
			
			Node<K> aux2=first;
			
			while(aux2.next!=null){
				aux2=aux2.next;
			}
			aux2.next=aux;
			
			
		}
		
	}

	@Override
	public K first() {
		
		return first.e;
	}

	@Override
	public K last() {
		// TODO Auto-generated method stub
		return last.e;
	}

	@Override
	public void deleteFirst() {
		if(first.next==null){
			first=null;
			last=null;
		}else{
		
		Node<K> aux=last;
			while(aux.prev.prev!=null){
				aux=aux.prev;
			}
			aux.prev=null;
			first=first.next;
		}
		
	}

	@Override
	public void deleteLast() {
		if(first.next==null){
			first=null;
			last=null;
		}else{
		
		Node<K> aux=first;
			while(aux.next.next!=null){
				aux=aux.next;
			}
			aux.next=null;
			
			last=last.prev;
		}
		
	}
	
	@Override
	public String toString(){
		String str=new String();
		Node<K> aux=first;
		while(aux!=null){
			//System.out.println("STR");
			str+= aux.e+" ";
			aux=aux.next;
		}
		return str;
	}
	
	
	public String toStringrev(){
		String str=new String();
		Node<K> aux=last;
		while(aux!=null){
			//System.out.println("STR");
			str+= aux.e+" ";
			aux=aux.prev;
		}
		return str;
	}
	
}
