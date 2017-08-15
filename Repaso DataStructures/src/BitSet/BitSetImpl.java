package BitSet;

import java.util.Arrays;
import java.util.Iterator;

public class BitSetImpl implements BitSet{

	
	private	int [] bitset;
	private int size;
	public BitSetImpl(int n) {
		bitset=new int [8*n];
		size=0;
	}
	
	
	@Override
	public void insert(int x) {
		ensureCapacity(x);
		if(x<0 || x>=bitset.length-1){
			throw new ArrayIndexOutOfBoundsException();
		}
		if(bitset[x]==0){
			size++;
		}
		bitset[x]=1;
		
	}

	@Override
	public void delete(int x) {
		if(x<0 || x>=bitset.length-1){
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if(bitset[x]==1){
			size--;
		}
		
		bitset[x]=0;
		
		
	}

	@Override
	public boolean isElem(int x) {
		if(x<0 || x>=bitset.length-1){
			throw new ArrayIndexOutOfBoundsException();
		}
		
		if(bitset[x]==0){
			return false;
		}else{
			return true;
		}
		
		
	}

	@Override
	public boolean isEmpty() {
		
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	public String toString(){
		String res=new String();
		
		res+="BitSet(";
		for(int i=0;i<bitset.length;i++){
			if(bitset[i]==1){
				res+=i+", ";
			}
			
		}
		res=res.substring(0, res.length()-2);
		res+=")";
		
		return res;
	}
	
	private int mascercano(int x){
		int p;
		switch (x){
		case 0 : p=8; break;
		case 1 : p=7; break;
		case 2 : p=6; break;
		case 3 : p=5; break;
		case 4 : p=4; break;
		case 5 : p=3; break;
		case 6 : p=2; break;
		default : p=1; break;
		}
		return p;
	}

	private void ensureCapacity(int x){
		if(x>bitset.length){
			int suma=mascercano(x%8);
			
			bitset=Arrays.copyOf(bitset, x+suma);
			
		}
		
	}
	
	public int len(){
		return bitset.length;
	}
	
	
	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new BitSetIterator();
	}
	
	
	private class BitSetIterator implements Iterator<Integer>{
		int current;
		
		public BitSetIterator() {
			current=0;
			sig();
		}
		
		private boolean sig(){
			
			while(bitset[current]==0&&current<bitset.length-2){
				current++;
			}
			if(bitset[current]==0){
				return false;
			}else{
				return true;
			}
			
			
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return sig();
		}

		@Override
		public Integer next() {
			int res=current;
			
			current++;
			sig();
			
			
			return res;
		}
		
		
		
	}
	
	public void insertAll(int[] array){
		for(int i=0;i<array.length;i++){
			insert(array[i]);
		}
		
	}
	
	public void deleteAll(int [] array){
		for(int i=0;i<array.length;i++){
			delete(array[i]);
		}
	}
	
	public int[] toarray(){
		Iterator<Integer> it=iterator();
		int[] res=new int[bitset.length];
		int i=0;
		while(it.hasNext()){
			res[i]=it.next();
			i++;
		}
		
		res=Arrays.copyOf(res, i);
		return res;
	}
	

	@Override
	public BitSet union(BitSet p) {
		BitSet bs=new BitSetImpl(p.len());
		bs.insertAll(p.toarray());
		bs.insertAll(this.toarray());
		
		return bs;
	}


	@Override
	public BitSet intersection(BitSet p) {
		int[] aux1=p.toarray();
		int[] aux2=this.toarray();
		BitSet bs=new BitSetImpl(p.len());
		for(int i=0;i<aux1.length;i++){
			for(int j=0;j<aux2.length;j++){
				if(aux1[i]==aux2[j]){
					bs.insert(aux1[i]);
				}
			}
		}
	
		return bs;
	}


	@Override
	public BitSet difference(BitSet p) {
		BitSet bs=new BitSetImpl(p.len());
		bs.insertAll(this.toarray());
		bs.deleteAll(p.toarray());
		
		return bs;
	}
	
	
	
}
