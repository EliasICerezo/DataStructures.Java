import java.util.LinkedList;

public class Tests {
	public static void main(String []args){
		LinkedList<Integer> t=new LinkedList<>();
		t.add(1);
		t.add(2);
		t.add(3);
		t.removeLast();
		System.out.println(t.getLast());
		
	}
}
