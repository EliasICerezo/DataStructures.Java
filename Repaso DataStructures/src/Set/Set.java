package Set;

public interface Set<T> extends Iterable<T> {
	
	boolean elem (T el);
	
	void insert (T el);
	
	void delete (T el);
	
	boolean isEmpty();
	
}
