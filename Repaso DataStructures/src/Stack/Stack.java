package Stack;

public interface Stack<T> {
	void push(T elem);
	
	void pop();
	
	T top();
	
	boolean isEmpty();
}
