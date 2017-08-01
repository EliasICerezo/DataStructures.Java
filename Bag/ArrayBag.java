package Bag;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayBag<T extends Comparable <? super T>> implements Bag<T>{
	
	
	
	Object [] elements;
	int [] times;
	int nele;
	
	public ArrayBag(){
		elements=new Object[10];
		times=new int[10];
		nele=0;
	}
	
	private void ensureCapacity(){
		if(nele==elements.length){
			elements=Arrays.copyOf(elements, 2*elements.length);
			times=Arrays.copyOf(times, 2*times.length);
		}
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return nele==0;
	}
	


	@Override
	public void insert(T el) {
		ensureCapacity();
		boolean f=false;
		Object e= (Object) el;
		if(nele==0){
			elements[0]=e;
			times[0]=1;
			nele++;
		}else{
			for(int i=0;i<nele;i++){
				if( e.equals(elements[i])){
					times[i]+=1;
					f=true;
				}
				
				
			}
			if(!f){
				elements[nele]=e;
				times[nele]=1;
				nele++;
			}
			
			
		}
		
	
	
	}

	@Override
	public int occurrences(T el) {
		Object e=(Object) el;
		for(int i=0;i<nele;i++){
			if( e.equals(elements[i])){
				return times[i];
			}
			
			
		}
		
		return -1;
	}

	@Override
	public void delete(T el) {
		if(nele==0){
			throw new RuntimeException("Delete on empty Nag");
		}
		
		Object e= (Object) el;
		
		for(int i=0;i<nele;i++){
			if( e.equals(elements[i])){
				times[i]-=1;
				if(times[i]==0){
					for(int j=i;j<nele;j++){
						elements[j]=elements[j+1];
						times[j]=times[j+1];
					}
					nele--;
				}
				
			}
			
			
		}
		
		
		
	}
	
	@Override
	public String toString(){
		String str=new String();
		
		for(int i=0;i<nele;i++){
			str+=elements[i]+"->"+times[i]+" ";
		}
		
		
		return str;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ArrayBagIterator();
	}
	
	private class ArrayBagIterator implements Iterator<T>{
		int current;
		int veces;
		public ArrayBagIterator(){
			current=0;
			veces=1;
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current<nele;
		}

		@Override
		public T next() {
			@SuppressWarnings("unchecked")
			T res=(T)elements[current];
			if(veces==times[current]){
				current++;
				veces=1;
			}else{
				veces++;
			}
			
			
			return res;
		}
		
	}

}
