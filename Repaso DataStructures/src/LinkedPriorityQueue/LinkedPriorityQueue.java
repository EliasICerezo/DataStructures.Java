package LinkedPriorityQueue;

/**(Java) Implementa el TAD colas de prioridad (LinkedPriorityQueue) usando una lista enlazada
de nodos (en orden ascendente). Este TAD debe Implementar la interfaz PriorityQueue. Una cola
de prioridad es parecido a una cola pero en la que el método enqueue coloca los elementos en
orden ascendente. Cread todo en el paquete dataStructures.priorityQueue. 
 * */


public class LinkedPriorityQueue<T extends Comparable <? super T>> implements PriorityQueue<T> {
	
	static private class Node<E> {
		E elem;
		Node<E> next;

		public Node(E x, Node<E> node) {
			elem = x;
			next = node;
		}
	}
	
	Node<T> first;
	
	public LinkedPriorityQueue(){
		first=null;
	}
	
	@Override
	public void enqueue(T elem) {
		Node<T> nuevo= new Node<>(elem,null);
		Node<T> aux=first;
		Node<T> prev=first;
		boolean f=false;
		if(first==null){
			first=nuevo;
		}else if(aux.elem.compareTo(nuevo.elem)>0){
			nuevo.next=first;
			first=nuevo;
		}else{
			while(!f && aux!=null){
				if(aux.elem.compareTo(nuevo.elem)>0){
					nuevo.next=aux;
					prev.next=nuevo;
					f=true;
				}else{
					prev=aux;
					aux=aux.next;
				}
			}
			if(!f){
				prev.next=nuevo;
			}
		}
		
	}

	@Override
	public void dequeue() {
		first=first.next;
		
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return first.elem;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first==null;
	}
	
	@Override
	public String toString(){
		String str=new String();
		Node<T> aux=first;
		while(aux!=null){
			str+=aux.elem+" ";
			aux=aux.next;
		}
		return str;
	}
	

}
