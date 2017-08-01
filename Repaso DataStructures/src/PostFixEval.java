import java.util.Arrays;

import Item.Add;
import Item.Data;
import Item.Dif;
import Item.Item;
import Item.Mul;
import Stack.LinkedListStack;
import Stack.Stack;

public class PostFixEval {
	
	static int evaluate(Item [] exprList, Stack<Data> s){
		System.out.println(exprList[0]+" , "+exprList.length);
		if(exprList.length==0){
			return s.top().getValue();
		}else if(exprList[0].isData()){
			
			s.push(new Data(exprList[0].getValue()));
			System.arraycopy(exprList, 1, exprList, 0 , (exprList.length-1) );
			exprList=Arrays.copyOf(exprList, exprList.length-1);
			evaluate(exprList,s);
			if(exprList.length==1){
				return s.top().getValue();
			}
		}else{
			
			Data a1=s.top();
			s.pop();
			Data a2=s.top();
			s.pop();
			s.push(new Data(exprList[0].evaluate(a1.getValue(), a2.getValue())));
			System.arraycopy(exprList, 1, exprList, 0 , exprList.length-1 );
			exprList=Arrays.copyOf(exprList, exprList.length-1);
			if(exprList.length==1){
				System.out.println("He pasado por aqui");
				Data s1=s.top();
				s.pop();
				Data s2=s.top();
				s.pop();
				s.push(new Data(exprList[0].evaluate(s1.getValue(), s2.getValue())));
				
				return s.top().getValue();
			}
			evaluate(exprList,s);
		}
		return s.top().getValue();
		
	}
	
	public static void main(String []args){
		Item [] sample = {
				new Data(5),
				new Data(6),
				new Data(2),
				new Dif(),
				new Data(3),
				new Mul(),
				new Add() };
		
		Stack <Data> s= new LinkedListStack<>();
		System.out.println(evaluate(sample, s));

	}
	

}
