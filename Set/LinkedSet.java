package Set;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedSet<T> implements Set<T> {
	
	static private class Node<E> {
		E elem;
		Node<E> next;
		public Node(E el,Node<E> nx){
			elem=el;
			next=nx;
		}
		
	}
	
	Node<T> first=null;
	
	@Override
	public boolean elem(T el) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void insert(T el) {
		// TODO Auto-generated method stub
		Node<T> e=new Node<>(el,null);
		if(first==null){
			first=e;
		}else{
			e.next=first;
			first=e;
		}
		
		
	}

	@Override
	public void delete(T el) {
		Node<T> aux=first;
		Node<T> prev=aux;
		if(first.elem.equals(el)){
			first=first.next;
		}else{
		
		
		boolean f=false;
		while(!f&&aux!=null){
			if(aux.elem.equals(el)){
				f=true;
			}else{
				prev=aux;
				aux=aux.next;
			}
			
		}
		prev.next=aux.next;
		aux=null;
		
		}
		
	}
	
	@Override
	public String toString(){
		Node<T> aux=first;
		String str=new String();
		while(aux!=null){
			str+=aux.elem.toString()+" ";
			aux=aux.next;
		}
		return str;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first==null;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedSetIterator();
	}
	
	private class LinkedSetIterator implements Iterator<T>{
		Node<T>current;
		
		public LinkedSetIterator(){
			current=first;
		}
		
		
		@Override
		public boolean hasNext() {
			return current!=null;
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			T res=current.elem;
			current=current.next;
			return res;
		}
		
	}

}
