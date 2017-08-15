package BitSet;

public interface BitSet extends Iterable<Integer>{
		 public void insert(int x); // precondición: 0 x < 8*n. Inserta x
		 public void delete(int x); // precondición: 0 x < 8*n. Elimina x
		 public boolean isElem(int x); //
		 public boolean isEmpty(); //
		 public String toString();
		 public int size();
		 public int len();
		 public BitSet union(BitSet p);
		 public BitSet intersection(BitSet p);
		 public BitSet difference(BitSet p);
		 public void insertAll(int[] array);
		 public int[] toarray();
		 public void deleteAll(int [] array);
}
