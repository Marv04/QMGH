package hashes;

import java.util.ArrayList;

public class HashTable2D extends HashTable{
	private int dimensionOneObjectID;
	private int dimensionTwoType;
	private ArrayList<Integer> hashValues;
	
	public HashTable2D(int hashTableID, int dimensionOneObjectID, int dimensionTwoType){
		super(hashTableID);
		this.dimensionOneObjectID = dimensionOneObjectID;
		this.dimensionTwoType = dimensionTwoType;
		this.hashValues = new ArrayList<Integer>();
	}
	
	public int getDimensionOneObjectID(){
		return this.dimensionOneObjectID;
	}
	public int getDimensionTwoType(){
		return this.dimensionTwoType;
	}
	public ArrayList<Integer> getHashValues(){
		return this.hashValues;
	}
	
}
