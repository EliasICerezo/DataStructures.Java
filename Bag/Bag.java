package Bag;

public interface Bag<T> extends Iterable<T>{
	
	public boolean isEmpty();
	
	public void insert(T el);
	
	public int occurrences(T el);
	
	public void delete(T el);
	
	@Override
	public String toString();
}
