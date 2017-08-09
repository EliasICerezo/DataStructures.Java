import dataStructures.dictionary.AVLDictionaryMio;
import dataStructures.dictionary.Dictionary;
import dataStructures.tuple.Tuple2;

public class TestAvlDic {
	public static void main(String []args){
		Dictionary<Integer,Integer> test=new AVLDictionaryMio<>();
		test.insert(1, 2);
		test.insert(3, 4);
		test.insert(5, 6);
		test.insert(2, 7);
		test.delete(2);
		for(Tuple2<Integer,Integer> e:test.keysValues()){
			System.out.println( e._1()+"->"+e._2());
		}
		
		System.out.println(test.isDefinedAt(2));
		
	}
}
