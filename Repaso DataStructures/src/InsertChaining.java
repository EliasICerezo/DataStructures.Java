import java.util.Random;

import dataStructures.hashTable.SeparateChainingHashTable;

public class InsertChaining {

	
	public static void main(String[] args) {
		Random rnd=new Random();
		SeparateChainingHashTable<Integer, Integer> t1=new SeparateChainingHashTable<>(7, 1);
		int res;
		int i,j;
	
		for(i=0;i<100;i++){
			t1.insert(rnd.nextInt(), 0);
			
		}
	
		
		res=9999999;
		for(j=0;j<t1.tabletam();j++){
			
			if(t1.len(j)>0 && t1.len(j)<res){
				res=t1.len(j);
			}
		}
		
		
		
		
		System.out.println("Para 100 inserciones la longitud mas corta es:"+res);
		
		
		for(i=100;i<1000;i++){
			t1.insert(rnd.nextInt(), rnd.nextInt());
		}
		
		res=9999999;
		for( j=1;j<t1.tabletam();j++){
			if(t1.len(j)>0 && t1.len(j)<res){
				res=t1.len(j);
			}
		}
		System.out.println("Para 1000 inserciones la longitud mas corta es:"+res);
		
		for(i=1000;i<10000;i++){
			t1.insert(rnd.nextInt(), rnd.nextInt());
		}
		
		res=9999999;
		for( j=1;j<t1.tabletam();j++){
			if(t1.len(j)>0 && t1.len(j)<res){
				res=t1.len(j);
			}
		}
		System.out.println("Para 10000 inserciones la longitud mas corta es:"+res);
		
		for(i=10000;i<100000;i++){
			t1.insert(rnd.nextInt(), rnd.nextInt());
		}
		
		res=9999999;
		for( j=1;j<t1.tabletam();j++){
			if(t1.len(j)>0 && t1.len(j)<res){
				res=t1.len(j);
			}
		}
		System.out.println("Para 100000 inserciones la longitud mas corta es:"+res);
		

		for(i=100000;i<1000000;i++){
			t1.insert(rnd.nextInt(), rnd.nextInt());
		}
		
		res=9999999;
		for( j=1;j<t1.tabletam();j++){
			if(t1.len(j)>0 && t1.len(j)<res){
				res=t1.len(j);
			}
		}
		System.out.println("Para 100000 inserciones la longitud mas corta es:"+res);
	}

}
