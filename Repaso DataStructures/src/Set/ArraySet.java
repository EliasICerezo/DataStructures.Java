package Set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet<T> implements Set<T> {
	
	Object elem[];
	int idx;
	
	public ArraySet(){
		elem = new Object[10] ;
		idx=0;
	}
	
	
	@Override
	public boolean elem(T el) {
		
		if(busca(el)!=-1){
			return true;
		}else{
			return false;
		}
	}
	
	private int busca(T el){
		Object c=(Object) el;
		for(int i=0;i<idx;i++){
			if(c.equals(elem[i])){
				return i;
			}
		}
		
		
		return -1;
	}
	
	
	@Override
	public void insert(T el) {
		ensureCapacity();
		Object c=(Object) el;
		elem[idx]=c;
		idx++;
	}

	@Override
	public void delete(T el) {
		int k=busca(el);
		if(k!=-1){
			for(int i=k;i<idx;i++){
				elem[i]=elem[i+1];
			}
			idx--;
		}
		
	}
	
	private void ensureCapacity(){
		if(idx==elem.length){
			elem=Arrays.copyOf(elem, 2*elem.length);
		}
		
		
	}
	
	@Override
	public boolean isEmpty() {
		return idx==0;
	}


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArraySetIterator();
	}
	
	@Override
	public String toString(){
		String str=new String();
		Object e=new Object();
		for(int i=0;i<idx;i++){
			e=elem[i];
			str+=e.toString()+" ";
			
		}
		return str;
		
	}
	
	private class ArraySetIterator implements Iterator<T>{
		int current;
		
		public ArraySetIterator(){
			current=0;
		}
		
		
		@Override
		public boolean hasNext() {
			
			return current<idx;
		}

		@Override
		public T next() {
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			@SuppressWarnings("unchecked")
			T res= (T) elem[current];
			current++;
			return res;
		}
		
		
		
		
	}
	
}


