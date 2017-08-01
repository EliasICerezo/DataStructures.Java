package Item;

public class Data extends Item {
	
	private int data;
	
	public Data(int d){
		data=d;
	}
	
	public int getValue(){
		return data;
	}
	
	@Override
	public boolean isData(){
		return true;
	}
	
	
}
