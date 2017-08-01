package LinkedPriorityQueue;



//(Java) Resuelve el ejercicio anterior usando una lista enlazada no ordenada
//(LinkedNOPriorityQueue). Este ejercicio se resolvería igual que el ejercicio 1 y en el mismo
//paquete.
public class LinkedNOPriorityQueue <T extends Comparable <? super T>> implements PriorityQueue<T> {
	
	static private class Node<E> {
		E elem;
		Node<E> next;

		public Node(E x, Node<E> node) {
			elem = x;
			next = node;
		}
	}
	
	Node<T> first;
	
	public LinkedNOPriorityQueue(){
		first=null;
	}
	
	@Override
	public void enqueue(T elem) {
		Node<T> nuevo= new Node<>(elem,null);
		nuevo.next=first;
		first=nuevo;
		
	}
	
	private Node<T> menorque(){
		Node<T> i=first;
		Node<T> j=first.next;
		boolean f=false;
		
		if(first==null){
			throw new RuntimeException();
		}
		
		while(i!=null){
			//System.out.print("Hola ");
			while(j!=null&& !f){
				//System.out.print(i.elem.compareTo(j.elem)+" ");
				if(i.elem.compareTo(j.elem)>0){
					
					f=true;
				}
				j=j.next;
			}
			//System.out.println(f);
			if(f==false){
				return i;
			}
			
			
			f=false;
			i=i.next;
			j=first;
		}
		throw new RuntimeException();
		
	}
	
	
	@Override
	public void dequeue() {
		Node<T> aux=first;
		Node<T> borra=menorque();
		Node<T> prev=aux;
		boolean f=false; //variable que comprueba si hemos borrado o no, para cortar el bucle cuando encontremos el elemento
		while(!f && aux!=null){
			if(aux.equals(borra)){
				prev.next=aux.next;
				aux=null;
				f=true;
			}else{
				aux=aux.next;
			}
		}
		
		
		
	}

	@Override
	public T first() {
		
		return menorque().elem;
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
